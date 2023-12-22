<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
    <body>
        <% String[] name = request.getParameterValues("check");%>
        <%
            for(String x : name)
            {
        %>
        tham số là: <%=x%>
        <%}%>


    </body>
</html>