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
 <s:form>
<tr><td><strong><font size="6" color="red">Note for Class师生笔记</font></strong></td></tr>
</s:form>

<s:form action="login">
<s:textfield name="username" label="username" value="TOM"/>
<s:password name="password" label="password" value="123456"/>
<s:submit style="width:100px" align="center" value="login" method="Login"/>
<s:submit style="width:100px" align="center" value="register" method="Register"/>
</s:form>


<s:form align="center">
<tr><td><strong><font size="3" color="red"><s:property value="message" /></font></strong></td></tr>
</s:form>

</body>
</html>