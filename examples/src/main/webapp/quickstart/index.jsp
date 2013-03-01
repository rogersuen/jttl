<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://www.javaplus.org/taglib/template" prefix="t"%>

<t:view name="content">
  <h2>Quick Start Examples</h2> 
  <p>This section contains a collection of simple JSP pages that demonstrate basic usage of JSP template tag library (JTTL). Follow these exmples to familiarize yourself with the basic features and usage of JTTL tags:</p> 

  <h3>Encapsulating layout in templates <a href="template.jsp"><img src="../images/execute.gif" width="20" height="20" border="0"></a> <a href="../showSource.jsp?filenames=/quickstart/template.jsp,/quickstart/header.html,/quickstart/footer.html"><img src="../images/code.gif" width="20" height="20" border="0"></a></h3>
  <p>Encapsulating layout in a template using &lt;t:render&gt; and &lt;t:view&gt;:</p>
  <ul>
    <li>Defining views using &lt;t:view&gt; tags with external resources</li>
    <li>Defining a view using &lt;t:view&gt; tag with inline template as a placeholder intended to be substituted by the caller</li>
    <li>Rendering the template using &lt;t:render&gt; tags with named views defined before</li>
    <li><b>Tip: </b>Pages intended to be used as templates can be access directly by clients</li>
  </ul>

  <h3>Using templates <a href="basicView.jsp"><img src="../images/execute.gif" width="20" height="20" border="0"></a> <a href="../showSource.jsp?filenames=/quickstart/basicView.jsp,/quickstart/template.jsp"><img src="../images/code.gif" width="20" height="20" border="0"></a></h3>
  <p>Rendering a page by calling a external template using &lt;t:render&gt; with nested &lt;t:view&gt;:</p>
  <ul>
    <li>Calling a template using &lt;t:render&gt;</li>
    <li>Defining a local view using &lt;t:view&gt; with inline template to substitute the one defined in the template</li>
  </ul>

  <h3>Omitting views <a href="omittingViews.jsp"><img src="../images/execute.gif" width="20" height="20" border="0"></a> <a href="../showSource.jsp?filenames=/quickstart/omittingViews.jsp,/quickstart/template.jsp"><img src="../images/code.gif" width="20" height="20" border="0"></a></h3>
  <p>Omitting views using empty &lt;t:view&gt;:</p>
  <ul>
    <li>Calling a template using &lt;t:render&gt;</li>
    <li>Defining a local view using empty &lt;t:view&gt; to substitute the one defined in the template</li>
    <li><b>Tip: </b>Define a view using empty &lt;t:view&gt; in a template if the view is optional; otherwise, define it as placeholder with some useful message if the view is mandatory</li>
  </ul>

  <h3>Extending templates <a href="extendingTemplates.jsp"><img src="../images/execute.gif" width="20" height="20" border="0"></a> <a href="../showSource.jsp?filenames=/quickstart/extendingTemplates.jsp,/quickstart/derivedTemplate.jsp,/quickstart/template.jsp"><img src="../images/code.gif" width="20" height="20" border="0"></a></h3>
  <p>Extending templates by refining subviews:</p>
  <ul>
    <li>Extending the base template by refining its subviews to create an extended template</li>
    <li><b>Tip: </b>Extedning templates effectively creates a hierarchy of templates. You can easily manage modifications to page layout.</li>
  </ul>

  <h3>Using request-time expression <a href="rtexp.jsp?layout=hcf"><img src="../images/execute.gif" width="20" height="20" border="0"></a> <a href="../showSource.jsp?filenames=/quickstart/rtexp.jsp,/quickstart/hcf.jsp,/quickstart/tlcrb.jsp"><img src="../images/code.gif" width="20" height="20" border="0"></a></h3>
  <p>Using request-time expression value for attributes of &lt;t:view&gt; and &lt;t:render&gt;:</p>
  <ul>
    <li><b>Tip: </b>With request-time expression value, templates can be determined dynamically.</li>
  </ul>
</t:view>

<t:render template="/template.jsp">
  <t:param name="title">Quick Start Examples</t:param>
  <t:view name="content" template="content"/>
</t:render>