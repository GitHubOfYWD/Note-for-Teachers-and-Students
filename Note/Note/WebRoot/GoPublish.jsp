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
<s:textfield name="topic"   value="%{topic}" style="display:none"/>
<s:textfield name="password"   value="%{password}" style="display:none"/>
<s:textfield name="host"   value="%{host}" style="display:none"/>
<s:textarea rows="10" cols="50" name="pmessage" align="center" width="300" height="100"/>
<s:submit style="width:100px" align="center" value="发布"/>
</s:form>

<s:form align="center">
<tr><td><strong><font size="3" color="red"><s:property value="message" /></font></strong></td></tr>
</s:form>

<form>
	<tr>
      <td><s:a href="login.action?username=%{username}&password=%{password}">主页</s:a></td>
    </tr>
</form>
	
</table>

</body>
</html>
