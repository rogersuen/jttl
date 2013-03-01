<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://www.javaplus.org/taglib/template" prefix="t"%>

<t:view name="content">
  <font color="red">This is placeholder for content view. Did you forget to override this view in your page?</font>
</t:view>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JTTL Examples - Quick Start</title>
  </head>
  <body>
    <table width="100%" border="1">
      <tr>
        <td>TOP</td>
      </tr>
      <tr>
        <td>
          <table width="100%" border="1">
            <tr>
              <td>LEFT</td>
              <td><t:render template="content"/></td>
              <td>RIGHT</td>
            </tr>
          </table>
        </td>
      </tr>
      <tr>
        <td>BOTTOM</td>
      </tr>
    </table>
  </body>
</html>
