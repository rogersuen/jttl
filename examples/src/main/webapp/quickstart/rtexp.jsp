<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://www.javaplus.org/taglib/template" prefix="t"%>

<t:render template="${param.layout}.jsp">
  <t:view name="content">
    <p>Choose your preferred layout:</p>
    <ul>
        <li><a href="rtexp.jsp?layout=hcf">header, content, footer</a></li>
        <li><a href="rtexp.jsp?layout=tlcrb">top, left, content, right, bottom</a></li>
    </ul>
  </t:view>
</t:render>