<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://www.javaplus.org/taglib/template" prefix="t"%>

<t:view name="content">
  <h2>Using Parameters</h2> 
  <p>This section contains a collection of simple JSP pages that demonstrate using parameters with &lt;t:view&gt; and &lt;t:render&gt;:</p> 

  <h3>Parameters of type <tt>String</tt> <a href="string.jsp"><img src="../images/execute.gif" width="20" height="20" border="0"></a> <a href="../showSource.jsp?filenames=/param/string.jsp,/param/template.jsp"><img src="../images/code.gif" width="20" height="20" border="0"></a></h3>
  <p>Using parameters of type <tt>java.lang.String</tt>:</p>
  <ul>
    <li>Defining named parameters using &lt;t:param&gt; tags for JSP pages intended to be templates</li>
    <li>Referring parameters through scoped variables in templates</li>
    <li>Passing parameter values using nested &lt;t:param&gt; tags when calling templates</li>
    <li><b>Tip: </b>Defining parameters in templates with default values</li>
    <li><b>Tip: </b>Scoped variables for parameters are exposed as request-scoped attributes</li>
    <li><b>Tip: </b>In the lack of convenient scoped variables, named subviews can serve the same purpose as parameters of type <tt>String</tt></li>
  </ul>

  <h3>Request-time expression values for parameters <a href="rtexp.jsp"><img src="../images/execute.gif" width="20" height="20" border="0"></a> <a href="../showSource.jsp?filenames=/param/rtexp.jsp,/param/forumTemplate.jsp,/param/messageTemplate.jsp"><img src="../images/code.gif" width="20" height="20" border="0"></a></h3>
  <p>Using request-time expression values of any type for parameters</tt>:</p>
  <ul>
    <li>Parameters accept request-time expression values of any type</li>
    <li><b>Tip: </b>Scoped variables exposed by parameters have nested visibility in the containing tags of parameters</li>
    <li><b>Tip: </b>Any prior request-scoped attributes hidden by parameters will be automatically restored after parameters go out of scope</li>
    <li><b>Tip: </b>Using parameters help to avoid name conflict</li>
  </ul>
</t:view>

<t:render template="/template.jsp">
  <t:param name="title">Using Parameters</t:param>
  <t:view name="content" template="content"/>
</t:render>