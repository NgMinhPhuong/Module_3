


<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%--<c:set var="myArray" value="${['Apple', 'Banana', 'Orange']}" />--%>


<%--<c:if test="${param.username.equals('abc')}">--%>
<%--    Oke--%>
<%--</c:if>--%>
<%--<c:set var="s" value="tao,la,phuong" />--%>
<%--<c:choose>--%>
<%--    <c:when test = "${requestScope.name.equals('hai')}">--%>
<%--        Salary is very low to survive.--%>
<%--        ${requestScope.name.length()}--%>
<%--    </c:when>--%>
<%--    <c:when test = "${requestScope.name == 'ba'}">--%>
<%--        <c:forEach var="i" items="${myArray}">--%>
<%--            [{--%>
<%--            "id": "${i}",--%>
<%--            "name": "${i}"--%>
<%--            },--%>
<%--            {"id":"" ,"name":""}]--%>

<%--        </c:forEach>--%>
<%--        <c:forTokens var="t" items="${s}" delims=",">--%>
<%--            ${t} 1--%>
<%--        </c:forTokens>--%>
<%--    </c:when>--%>
<%--    <c:otherwise>--%>
<%--        No comment sir...--%>
<%--    </c:otherwise>--%>
<%--</c:choose>--%>
<%---------------------------------------------------------------------------%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title>fmt:formatNumber example</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h2>fmt:formatNumber example</h2>--%>
<%--<c:set var="accountBalance" value="12345.6789" />--%>
<%--<h3>accountBalance=<c:out value="${accountBalance}"/></h3>--%>

<%--The Account Balance can be displayed using various ways:--%>

<%--<p>--%>
<%--    formatNumber (type='currency'):--%>
<%--    <strong>--%>
<%--        <fmt:formatNumber value="${accountBalance}" type="currency"/>--%>
<%--    </strong>--%>
<%--</p>--%>
<%--<p>--%>
<%--    formatNumber (type='number', maxIntegerDigits= '3'):--%>
<%--    <strong>--%>
<%--        <fmt:formatNumber type="number" maxIntegerDigits="3" value="${accountBalance}" />--%>
<%--    </strong>--%>
<%--</p>--%>
<%--<p>--%>
<%--    formatNumber (type='number', maxFractionDigits= '3'):--%>
<%--    <strong>--%>
<%--        <fmt:formatNumber type="number" maxFractionDigits="3" value="${accountBalance}" />--%>
<%--    </strong>--%>
<%--</p>--%>
<%--<p>--%>
<%--    formatNumber (type='number', groupingUsed= 'false'):--%>
<%--    <strong>--%>
<%--        <fmt:formatNumber type="number" groupingUsed="false" value="${accountBalance}" />--%>
<%--    </strong>--%>
<%--</p>--%>
<%--<p>--%>
<%--    formatNumber (type='percent', maxIntegerDigits= '3'):--%>
<%--    <strong>--%>
<%--        <fmt:formatNumber type="percent" maxIntegerDigits="3" value="${accountBalance}" />--%>
<%--    </strong>--%>
<%--</p>--%>
<%--<p>--%>
<%--    formatNumber (type='percent', maxIntegerDigits= '10'):--%>
<%--    <strong>--%>
<%--        <fmt:formatNumber type="percent" minFractionDigits="10" value="${accountBalance}" />--%>
<%--    </strong>--%>
<%--</p>--%>
<%--<p>--%>
<%--    formatNumber (type='number', pattern= '###.###E0'):--%>
<%--    <strong>--%>
<%--        <fmt:formatNumber type="number" pattern="###.###E0" value="${accountBalance}" />--%>
<%--    </strong>--%>
<%--</p>--%>
<%--<p>--%>
<%--    Account Balance in USA (fmt:setLocale value='en_US'):--%>
<%--    <br/>--%>
<%--    formatNumber (type='currency'):--%>
<%--    <fmt:setLocale value="en_US"/>--%>
<%--    <strong>--%>
<%--        <fmt:formatNumber value="${accountBalance}" type="currency"/>--%>
<%--    </strong>--%>
<%--</p>--%>
<%--    Account Balance in Canada (fmt:setLocale value='fr_CA'):--%>
<%--    <br/>--%>
<%--    formatNumber (type='currency'):--%>
<%--    <fmt:setLocale value="fr_CA"/>--%>
<%--    <strong>--%>
<%--        <fmt:formatNumber value="${accountBalance}" type="currency"/>--%>
<%--    </strong>--%>

<%--</body>--%>

<%--</html>--%>



<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%---------------------------------------------------------------------------%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title>fmt:formatDate example</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h2>fmt:formatDate example</h2>--%>
<%--<c:set var="now" value="<%=new java.util.Date()%>" />--%>
<%--<p>--%>
<%--    Time (fmt:formatDate type="time"):--%>
<%--    <strong>--%>
<%--        <fmt:formatDate type="time" value="${now}" />--%>
<%--    </strong>--%>
<%--</p>--%>
<%--<p>--%>
<%--    Date (fmt:formatDate type="date"):--%>
<%--    <strong>--%>
<%--        <fmt:formatDate type="date" value="${now}" />--%>
<%--    </strong>--%>
<%--</p>--%>
<%--<p>--%>
<%--    Date, Time (fmt:formatDate type="both"):--%>
<%--    <strong>--%>
<%--        <fmt:formatDate type="both" value="${now}" />--%>
<%--    </strong>--%>
<%--</p>--%>
<%--<p>--%>
<%--    Date, Time Short (fmt:formatDate type="both" dateStyle="short"):--%>
<%--    <strong>--%>
<%--        <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${now}" />--%>
<%--    </strong>--%>
<%--</p>--%>
<%--<p>--%>
<%--    Date, Time Medium (fmt:formatDate type="both" dateStyle="medium" timeStyle="medium"):--%>
<%--    <strong>--%>
<%--        <fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${now}" />--%>
<%--    </strong>--%>
<%--</p>--%>
<%--<p>--%>
<%--    Date, Time Long (fmt:formatDate type="both" dateStyle="long" timeStyle="long"):--%>
<%--    <strong>--%>
<%--        <fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${now}" />--%>
<%--    </strong>--%>
<%--</p>--%>
<%--<p>--%>
<%--    Date, Time (dd-MM-yyyy HH:mm:ss):--%>
<%--    <strong>--%>
<%--        <fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss" value="${now}" />--%>
<%--    </strong>--%>
<%--</p>--%>

<%--<!-- Store in variable -->--%>
<%--<fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${now}" var="nowString"/>--%>

<%--<p>--%>
<%--    Now String (dd-MM-yyyy HH:mm):--%>
<%--    <strong>--%>
<%--        <c:out value="${nowString}" />--%>
<%--    </strong>--%>
<%--</p>--%>
<%--</body>--%>
<%--</html>--%>
<%---------------------------------------------------------------------------%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>fmt:parseDate example</title>
</head>
<body>
<h2>fmt:parseDate example hay á</h2>

<!-- Một chuỗi có định dạng ngày tháng thời gian -->
<c:set var="dateTimeString" value="17-11-2015 11:49" />
<h4>
    dateTimeString:
    <c:out value="${dateTimeString}"/>
</h4>
<!-- Phân tích chuỗi mô tả ngày tháng thời gian lưu vào biến kiểu java.util.Date -->

<fmt:parseDate value="${dateTimeString}"
               type="both" var="parsedDatetime" pattern="dd-MM-yyyy HH:mm" />
<p>
    The date time after parsing:
    <c:out value="${parsedDatetime}" />
</p>
<br/>
<p>
    Date only (dd/MM/yyyy):
    <fmt:formatDate value="${parsedDatetime}" pattern="dd/MM/yyyy"/>
</body>

</html>
<%---------------------------------------------------------------------------%>
