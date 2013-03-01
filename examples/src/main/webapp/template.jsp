<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://www.javaplus.org/taglib/template" prefix="t"%>

<t:param name="title"/>

<t:view name="header">
  <c:url value="/index.jsp" var="urlIndex"/>
  <table width="100%" cellpadding="2" cellspacing="2"> 
    <tr> 
      <td align="left" nowrap><a href="${urlIndex}">Examples Index</a></td> 
      <td align="right" nowrap><b>JSP Template Tag Library</b></td> 
    </tr> 
  </table> 
</t:view>

<t:view name="content">
  <font color="red">This is placeholder for content view. Did you forget to override this view in your page?</font>
</t:view>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JSP Template Tag Library (JTTL) - ${title}</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  </head>
  <body>
    <t:render template="header"/>
    <t:render template="content"/>
  </body>
</html>
