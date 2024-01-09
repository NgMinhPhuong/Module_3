<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/8/2024
  Time: 9:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>


<div class="container">
    <form action="" class="search">
        <input style="display: none" name="action" value="search">
        <input type="text" name="key">
        <input type="submit" value="Search">
    </form>
    <table class="table">
        <thead>
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Email</th>
                <th>Adress</th>
                <th>PhoneNumber</th>
                <th>Salary</th>
                <th>Department</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="employee" items="${employees}">
            <tr>
            <td>${employee.getId()}</td>
            <td>${employee.getName()}</td>
            <td>${employee.getEmail()}</td>
            <td>${employee.getAddress()}</td>
            <td>${employee.getPhoneNumber()}</td>
            <td>${employee.getSalary()}</td>
            <td>${employee.getDepartment()}</td>
            <td>
                <a href="/?action=edit&email=${employee.getEmail()}">Edit</a>
                <a href="/?action=delete&email=${employee.getEmail()}">Delete</a>
                <a href="/?action=add">Add</a>
            </td>
                </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<style>
    .search input{
        border-radius: 10px;
    }
</style>
</body>
</html>
