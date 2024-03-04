<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2/23/2024
  Time: 9:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<a href="/home?action=add">ADD</a>
<form action="/home">
    <input type="hidden" name="action" value="search">
    <input name="name">
    <button type="submit">Tìm kiếm</button>
</form>
<body>
    <table border="1">
        <tr>
            <td>#</td>
            <td>Name</td>
            <td>DateOfBirth</td>
            <td>Email</td>
            <td>Address</td>
            <td>Phone</td>
            <td>ClassRoom</td>
            <td>Action</td>
        </tr>
        <c:forEach var="i" items="${lists}">
            <tr>
                <td>${i.getId()}</td>
                <td>${i.getName()}</td>
                <td>${i.getDateOfBirth()}</td>
                <td>${i.getEmail()}</td>
                <td>${i.getAddress()}</td>
                <td>${i.getPhone()}</td>
                <td>${i.getClass_name()}</td>
                <td>
                    <a href="/home?action=edit&id=${i.getId()}">Edit</a>
                    <a href="/home?action=delete&id=${i.getId()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
