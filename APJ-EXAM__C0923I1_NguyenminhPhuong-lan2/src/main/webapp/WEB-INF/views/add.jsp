<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2/23/2024
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/home">
    <input name="action" value="add" type="hidden">
    Name:<input name="name" value=""> <br>
    DateOfBirth:<input name="dateOfBirth" value=""> <br>
    Email:<input name="email" value=""><br>
    Phone:<input name="phone" value=""><br>
    Address: <input name="address" value=""><br>
    Class: <select name="class_id">
    <c:forEach var="i" items="${listClassName}">
        <option value="${i.getId()}">${i.getName()}</option>
    </c:forEach>
</select>
    <input type="submit" value="Tạo">
</form>
</body>
</html>
