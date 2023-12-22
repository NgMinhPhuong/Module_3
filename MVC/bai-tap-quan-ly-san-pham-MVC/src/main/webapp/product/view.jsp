<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View customer</title>
</head>
<body>
<h1>Customer details</h1>
<p>
    <a href="/customers">Back to customer list</a>
</p>
<table>
    <tr>
        <td>Id: </td>
        <td>${requestScope["products"].getId()}</td>
    </tr>
    <tr>
        <td>Name: </td>
        <td>${requestScope["products"].getName()}</td>
    </tr>
    <tr>
        <td>Price: </td>
        <td>${requestScope["products"].getPrice()}</td>
    </tr>
</table>
</body>
</html>