<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Displays the content of the source files specified in request
  parameter "filenames" (a comma separated list).
--%>

<% pageContext.setAttribute("filenames", request.getParameter("filenames")); %>
<html>
    <head>
        <title>JTTL example source code for <c:forEach var="filename" items="${filenames}"><c:out value="${filename}"/> </c:forEach></title>
    </head>
    <body>
        <c:forEach var="filename" items="${filenames}">
        <h3>${filename}:</h3>
        <% 
            String filename = (String)pageContext.getAttribute("filename");
            pageContext.setAttribute("filepath",
                    application.getResource(filename).toExternalForm());
        %>
        <c:import var="source" url="${filepath}"/>
        <pre><c:out value="${source}" escapeXml="true"/></pre>
        </c:forEach>
    </body>
</html>
