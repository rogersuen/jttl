<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://www.javaplus.org/taglib/template" prefix="t"%>

<t:render template="derivedTemplate.jsp">
  <t:view name="derivedContent">
    <p>Hello! The actual content goes here.</p>
  </t:view>
</t:render>