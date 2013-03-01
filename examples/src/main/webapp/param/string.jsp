<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://www.javaplus.org/taglib/template" prefix="t"%>

<t:render template="template.jsp">
  <t:param name="title">Using Parameters</t:param>
  <t:view name="content">
    <p>Hello! The actual content goes here.</p>
  </t:view>
</t:render>