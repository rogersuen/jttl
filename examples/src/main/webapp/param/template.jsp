<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://www.javaplus.org/taglib/template" prefix="t"%>

<t:param name="title" value="Untitled"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JTTL Examples - ${title}</title>
  </head>
  <body>
    <h2>${title}</h2>
    <p>Using parameter throught the scoped variable for the above title.</p>
  </body>
</html>
