<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://www.javaplus.org/taglib/template" prefix="t"%>

<t:render template="/template.jsp">
  <t:param name="title">Examples Application</t:param>
  <t:view name="content">
    <h1>JSP Template Tag Library</h1> 
    <h2>Examples Web Application </h2> 
    <p>Welcome to the template-examples web application! This standalone application includes a variety of basic JSP pages that demonstrate using JSP template tag library (JTTL). </p> 
    <p>The examples have been divided into some categories as follow:</p> 
    <ul> 
      <li><a href="quickstart/index.jsp">Quick Start</a></li> 
      <li><a href="param/index.jsp">Using Parameters</a></li>
    </ul> 
    <p>When navigating the examples, you can always return back to this index page by following the link <a href="index.html">Examples Index</a> at the top of every example page.</p> 
    <p>For each example, the following icons will allow you to examine the source code as well as execute the example JSP page.</p> 
    <table  border="1" cellspacing="2" cellpadding="2"> 
      <tr> 
        <td width="20"><img src="images/execute.gif" alt="Execute" width="20" height="20"></td> 
        <td>Execute the example JSP page</td> 
      </tr> 
      <tr> 
        <td width="20"><img src="images/code.gif" alt="Source Code" width="20" height="20"></td> 
        <td>Look at the source code of the example JSP pages</td> 
      </tr> 
    </table>
  </t:view>
</t:render>