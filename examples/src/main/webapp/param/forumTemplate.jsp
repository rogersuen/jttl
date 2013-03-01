<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://www.javaplus.org/taglib/template" prefix="t"%>

<%-- define template parameter for title --%>
<t:param name="title" value="Untitled"/>

<%-- define subview for content --%>
<t:view name="content">
  <font color="red">This is placeholder for content view. Did you forget to override this view in your page?</font>
</t:view>
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${title}</title>
  </head>
  <body>
    <h2>${title}</h2>
    <hr />
    <t:render template="content"/>
  </body>
</html>
