<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2/21/2024
  Time: 10:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="resources/css/talk.css">
</head>
<body>
<input type="hidden" name="idTalk" value="${idTalk}">
<input type="hidden" name="idUser2" value="${userTalkDTO.getUser2().getId()}">
<div class="header">
    <a href="">
        <img src="https://png.pngtree.com/png-vector/20190803/ourlarge/pngtree-arrow-back-sign-blue-dotted-line-line-icon-png-image_1647600.jpg" alt="">
    </a>
    <a href="">
        <img src="${userTalkDTO.getUser2().getImage()}" alt="">
    </a>
    <a href="">
        <h1>${userTalkDTO.getUser2().getName()}</h1>
    </a>
    <div class="background">
        <img src="https://img6.thuthuatphanmem.vn/uploads/2022/03/04/background-powerpoint-tinh-yeu_021055251.jpg">
        <img src="https://png.pngtree.com/thumb_back/fh260/background/20230615/pngtree-landscape-landscape-photo-image_2902263.jpg">
        <img src="https://img3.thuthuatphanmem.vn/uploads/2019/10/10/background-3d-dong_032845717.gif">
    </div>
</div>

<div class="main">
    <c:forEach var="i" items="${userTalkDTO.getContent()}">
        <c:if test="${fn:substring(i,0,fn:length(user.getUsername())) eq user.getUsername()}">
            <span class="one">${fn:substring(i,fn:length(user.getUsername())+19,fn:length(i))}</span>
            <br>
        </c:if>
        <c:if test="${fn:substring(i,0,fn:length(userTalkDTO.getUser2().getUsername())) eq userTalkDTO.getUser2().getUsername()}">
            <span class="two">${fn:substring(i,fn:length(userTalkDTO.getUser2().getUsername())+19,fn:length(i))}</span>
            <br>
        </c:if>
    </c:forEach>
</div>
<div class="footer">
    <input name="contentTalk" type="text">
    <a href="">
        <img class="imgSend" src="https://cdn.pixabay.com/photo/2012/04/05/01/58/arrow-25864_960_720.png" alt="">
    </a>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="resources/js/talk.js"></script>

</body>
</html>
