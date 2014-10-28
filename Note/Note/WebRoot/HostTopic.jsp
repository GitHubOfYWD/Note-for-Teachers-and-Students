<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
</head>
 <body>
 <table width="300" height="100">
<s:form>
<tr><td><strong><font size="5"><s:property value="topic" /></font></strong></td></tr>
</s:form>

<s:form>
<s:a href="topic_GoPublish.action?username=%{username}&topic=%{topic}">增加新的结论</s:a>
</s:form>

	
</table>

</body>
</html>