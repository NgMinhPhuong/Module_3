<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form method="post" action="calculator.jsp">
    <label for="first-operand">First Operand: </label>
    <input type="text" id="first-operand" name="first">
    <br>
    <br>
    <label for="count">Operator: </label>
    <select name="cnt" id="count" size="1">
        <option value="+">cộng</option>
        <option value="-">trừ</option>
        <option value="*">nhân</option>
        <option value="/">chia</option>
    </select>

    <Br>
    <Br>
    <label for="second-operand">Second Operand: </label>
    <input type="text" id="second-operand" name="second">
    <br>
    <input type="submit" value="Calculator">
</form>
</body>
</html>