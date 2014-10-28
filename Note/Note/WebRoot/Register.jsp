<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

<head>
<style type="text/css">
		body{text-align:center;}
		div{text-align:center;}
</style>
</head>

 <body>
 <s:form>
<tr><td><strong><font size="6" color="red">Register</font></strong></td></tr>
</s:form>

<s:form action="register">
<s:textfield name="username" label="username" value=""/>
<s:password name="password" label="password" value=""/>
<s:submit style="width:100px" align="center" value="OK"/>
</s:form>


<s:form>
<tr><td><strong><font size="3" color="red"><s:property value="message" /></font></strong></td></tr>
</s:form>

</body>
</html>