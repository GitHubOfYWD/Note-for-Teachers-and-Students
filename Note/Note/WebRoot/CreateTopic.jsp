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
<tr><td><strong><font size="6">创建讨论组</font></strong></td></tr>
</s:form>
<s:form action="createtopic_Set" theme="simple">
<s:textfield name="username" label="用户" value="%{username}" style="display:none"/>
<s:textfield name="topic" label="话题：" value="%{topic}"/>
<s:submit style="width:100px" value="创建"/>
</s:form>
<s:form align="center">
<tr><td><strong><font size="3" color="red"><s:property value="topicmessage" /></font></strong></td></tr>
</s:form>


<s:form>
<tr><td><strong><font size="6">邀请组员</font></strong></td></tr>
</s:form>
<s:form action="createtopic_Invite" theme="simple">
<s:textfield name="username" label="用户：" value="%{username}" style="display:none"/>
<s:textfield name="topic" label="话题：" value="%{topic}" style="display:none"/>
<s:textfield name="invitename" label="用户名" value=""/>
<s:submit style="width:100px" value="邀请"/>
</s:form>


<s:form align="center">
<tr><td><strong><font size="3" color="red"><s:property value="invitemessage" /></font></strong></td></tr>
</s:form>

</body>
</html>