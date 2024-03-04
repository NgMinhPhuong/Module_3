<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2/20/2024
  Time: 9:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" href="resources/css/home.css">
</head>
<body>
<div class="header">
    <div class="header1">
        <a href="">
            <img src="https://freesvg.org/img/menu-icon.png" alt="">
        </a>
        <h1>Đoạn Chat</h1>
        <div class="header1-3">
            <img src="${user.getImage()}" alt="">
            <a href="/login?action=logout">Đăng xuất</a>
        </div>
    </div>
    <div class="header2">
            <input type="text" name="search" placeholder="Nhập tên tìm kiếm">
            <div class="resultSearch"></div>
<%--        <button type="submit">Tìm kiếm</button>--%>
    </div>
</div>
<div class="main">
    <c:forEach var="i" items="${lists}">
    <a href="/talk?idUser1=${user.getId()}&idUser2=${i.getUser().getId()}">
        <div class="line">
            <div class="line1">
                <img src="${i.getUser().getImage()}" alt="">
                <h1>${i.getUser().getName()}</h1>
            </div>
            <div class="line3">
                <img src="https://s1.img.yan.vn/YanNews/2167221/201611/20161102-121706-bestie-kiem-tra-thi-luc-9-20161024154752_600x450.jpg" alt="">
            </div>
        </div>
    </a>
    </c:forEach>
</div>


<%--    <a href="">--%>
<%--        <div class="line">--%>
<%--            <div class="line1">--%>
<%--                <img src="https://s1.img.yan.vn/YanNews/2167221/201611/20161102-121706-bestie-kiem-tra-thi-luc-9-20161024154752_600x450.jpg" alt="">--%>
<%--                <h2>name</h2>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </a>--%>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="resources/js/home.js"></script>

</body>
</html>
