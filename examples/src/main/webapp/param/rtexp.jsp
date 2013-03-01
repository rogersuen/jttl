<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://www.javaplus.org/taglib/template" prefix="t"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- initialize bean --%>
<%@include file="init.jsp"%>

<%-- render the page using JTTL, JSTL --%>
<t:render template="forumTemplate.jsp">
  <t:param name="title">Forum Messages</t:param>
  <t:view name="content">
    <c:forEach var="message" items="${messageList}">
      <t:render template="messageTemplate.jsp">
        <t:param name="message" value="${message}"/>
      </t:render>
    </c:forEach>
  </t:view>
</t:render>