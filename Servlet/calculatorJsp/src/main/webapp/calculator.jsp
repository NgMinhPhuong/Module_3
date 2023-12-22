<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 12/20/2023
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Result:</h1>
    <%double result = 0.0;%>
    <c:catch var="er">

    <%

        String first = request.getParameter("first");
        String operand = request.getParameter("cnt");
        String second = request.getParameter("second");

        if(operand.equals("+")){
             result = Double.parseDouble(first) + Double.parseDouble(second);
        } else if(operand.equals("-")){
             result = Double.parseDouble(first) - Double.parseDouble(second);
        } else if(operand.equals("*")){
             result = Double.parseDouble(first) * Double.parseDouble(second);
        } else if(operand.equals("/")){
            result = Double.parseDouble(first) / Double.parseDouble(second);
        }
    %>
    </c:catch>
    <c:if test="${er == null}">
        result:<%=result%>
    </c:if>
    <c:if test="${er != null}">
        Exception: ${er}
        <br>
        Message: ${er.message}
    </c:if>





</body>
</html>
