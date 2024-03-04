<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2/23/2024
  Time: 10:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="/home">
        <input name="action" value="edit" type="hidden">
        <input name="id" value="${studentDTO.getId()}" type="hidden">
        Name:<input name="name" value="${studentDTO.getName()}"> <br>
        DateOfBirth:<input name="dateOfBirth" value="${studentDTO.getDateOfBirth()}"> <br>
        Email:<input name="email" value="${studentDTO.getEmail()}"><br>
        Phone:<input name="phone" value="${studentDTO.getPhone()}"><br>
        Address: <input name="address" value="${studentDTO.getAddress()}"><br>
        Class: <select name="class_id">
                <c:forEach var="i" items="${listClassName}">
                    <option value="${i.getId()}">${i.getName()}</option>
                </c:forEach>
            </select>
        <input type="submit" value="Sửa">
    </form>
</body>
</html>
