<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/8/2024
  Time: 9:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<%--<form action="" method="post">--%>
<%--    <table>--%>
<%--        <tr>--%>
<%--            <td>Email:</td> <td><input name="email" type="text" value="${employee.getEmail()}"></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Name:</td> <td><input name="name" type="text" value="${employee.getName()}"> </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Address:</td> <td><input name="address" type="text" value="${employee.getAddress()}"></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Phone Number:</td> <td><input name="phonenumber" type="text" value="${employee.getPhoneNumber()}"></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Salary:</td> <td><input name="salary" type="text" value="${employee.getSalary()}"></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Department:</td> <td><input name="department" type="text" value="${employee.getDepartment()}"> <br><br></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td><input type="submit" value="Sửa"></td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--</form>--%>

<div class="container">
    <h2>Cập nhật</h2>

    <form action="" method="post">
        <div class="form-group">
            <label for="usr">Email:</label>
            <input type="text" class="form-control" id="usr" name="email" value="${employee.getEmail()}">
        </div>
        <div class="form-group">
            <label for="pwd">Name:</label>
            <input type="text" class="form-control" id="pwd" name="name" value="${employee.getName()}">
        </div>
        <div class="form-group">
            <label for="pwd">Address:</label>
            <input type="text" class="form-control" id="usr" name="address" value="${employee.getAddress()}">
        </div>
        <div class="form-group">
            <label for="pwd">Phone Number:</label>
            <input type="text" class="form-control" id="usr" name="phonenumber" value="${employee.getPhoneNumber()}">
        </div>
        <div class="form-group">
            <label for="pwd">Salary:</label>
            <input type="text" class="form-control" id="usr" name="salary" value="${employee.getSalary()}">
        </div>
        <div class="form-group">
            <label for="pwd">Department:</label>
            <input type="text" class="form-control" id="usr" name="department" value="${employee.getDepartment()}">
        </div>
        <input type="submit" value="Cập nhật">
    </form>
</div>
</body>
</html>
