JSP Template Tag Library (JTTL)
================================

Thanks for using JSP Template Tag Library (JTTL), an extreme simple, yet powerful 
JSP tag library that implements "composite view" pattern.

The tag library has only three tags:

	<t:view>   - defines a view
	<t:render> - renders a view
	<t:param>  - defines a parameter for a view

Using the Tag Library
---------------------

To use the tag library with your own web applications, simply copy the JAR
files in the 'lib' directory to your application's WEB-INF/lib directory. 
Then, import the template tag library into your pages with the following directives:

    <%@taglib uri="http://www.javaplus.org/taglib/template" prefix="t"%>

or introducing a new namespace with the above URI in a JSP document
in XML syntax.

The following is a simple JSP page (template.jsp) from the examples web application, 
demonstrating typical usage of the tag library.

	<%@page contentType="text/html"%>
	<%@page pageEncoding="UTF-8"%>
	<%@taglib uri="http://www.javaplus.org/taglib/template" prefix="t"%>
	
	<t:view name="header" template="header.html"/>
	<t:view name="content">
	<font color="red">This is placeholder for content view. Did you forget to override this view in your page?</font>
	</t:view>
	<t:view name="footer" template="footer.html"/>
	
	<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
	  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	  <title>JTTL Examples - Quick Start</title>
	</head>
	<body>
	  <table width="100%" border="1">
	    <tr>
	      <td><t:render template="header"/></td>
	    </tr>
	    <tr>
	      <td><t:render template="content"/></td>
	    </tr>
	    <tr>
	      <td><t:render template="footer"/></td>
	    </tr>
	  </table>
	</body>
	</html>

This JSP page defines a template (it can be used directly). You can create a page 
using the above template, by "overriding" views declared in the template:

	<%@page contentType="text/html"%>
	<%@page pageEncoding="UTF-8"%>
	<%@taglib uri="http://www.javaplus.org/taglib/template" prefix="t"%>
	
	<t:render template="template.jsp">
	  <t:view name="content">
	    <p>Hello! The actual content goes here.</p>
	  </t:view>
	</t:render>

The best way to learn about the usage of these tags, is the examples web application.

Examples Web Application
------------------------

In the source code distribution, an standalone examples web application is provided.
You can build it, deploy the application to your favorite container, and follow 
the examples to familiarize yourself with the usage of the tag library.

Rumtime Dependencies
--------------------

This version of JMP has the following runtime dependencies provided
by Java EE containers:

- Servlet 2.5
- JSP 2.1
- JSTL 1.2 (needed only by examples web application)

Documentation
-------------

I'm busy in working on the documentation of the tag library. 

Building from Source Code
-------------------------

Download a source distribution. Build it from the source code with Maven.

Comment and Feedback
--------------------

Any comment, question and feedback should go to rogersuen@live.com.

Enjoy!
