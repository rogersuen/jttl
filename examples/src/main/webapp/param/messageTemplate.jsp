<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://www.javaplus.org/taglib/template" prefix="t"%>

<%-- define template parameter for the message bean --%>
<t:param name="message"/>

<h3>${message.title}</h3>
<h4>by ${message.author}</h4>
<p>${message.content}</p>
<hr />