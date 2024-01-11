<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/8/2024
  Time: 9:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<%--            <td>Email:</td> <td><input name="email" type="text"></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Name:</td> <td><input name="name" type="text"> </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Adress:</td> <td><input name="address" type="text"></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Phone Number:</td> <td><input name="phonenumber" type="text"></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Salary:</td> <td><input name="salary" type="text"></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>Department:</td> <td><input name="department" type="text"> <br><br></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td><input type="submit" value="Thêm"></td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--</form>--%>
<div class="container">
    <h2>Thêm Nhân viên</h2>

    <form action="" method="post">
        <div class="form-group">
            <label for="usr">Email:</label>
            <input type="email" class="form-control" id="usr" name="email">
        </div>
        <div class="form-group">
            <label for="pwd">Name:</label>
            <input type="text" class="form-control" id="pwd" name="name">
        </div>
        <div class="form-group">
            <label for="pwd">Address:</label>
            <input type="text" class="form-control" id="usr" name="address">
        </div>
        <div class="form-group">
            <label for="pwd">Phone Number:</label>
            <input type="text" class="form-control" id="usr" name="phonenumber">
        </div>
        <div class="form-group">
            <label for="pwd">Salary:</label>
            <input type="text" class="form-control" id="usr" name="salary">
        </div>
        <div class="form-group">
            <label for="pwd">Department:</label>
            <input type="text" class="form-control" id="usr" name="department">
        </div>
        <input type="submit" value="Thêm">
    </form>
</div>
</body>
</html>
