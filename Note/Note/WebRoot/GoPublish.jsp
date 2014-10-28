<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<style type="text/css">
		body{text-align:center;}
		div{text-align:center;}
</style>
</head>
 <body>
 <table width="300" height="100">
<s:form align="center">
<tr><td><strong><font size="5"><s:property value="topic" /></font></strong></td></tr>
</s:form>

<s:form action="topic_Publish" align="center">
<s:textfield name="username" value="%{username}" style="display:none"/>
<s:textfield name="topic"  value="%{topic}" style="display:none"/>
<s:textarea name="message" align="center" width="300" height="100"/>
<s:submit style="width:100px" align="center" value="发布"/>
</s:form>

	
</table>

</body>
</html>
