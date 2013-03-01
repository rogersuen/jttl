<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://www.javaplus.org/taglib/template" prefix="t"%>

<t:view name="sidebar" template="sidebar.html"/>
<t:view name="derivedContent">
  <font color="red">This is placeholder for the view "derivedContent". Did you forget to override this view in your page?</font>
</t:view>

<t:render template="template.jsp">
  <t:view name="content">
    <table width="100%" border="1">
      <tr>
        <td width="180"><t:render template="sidebar"/></td>
        <td><t:render template="derivedContent"/></td>
      </tr>
    </table>
  </t:view>
</t:render>