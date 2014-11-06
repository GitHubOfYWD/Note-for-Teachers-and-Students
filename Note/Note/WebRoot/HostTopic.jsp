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
<s:a href="topic_GoPublish.action?username=%{username}&password=%{password}&topic=%{topic}&host=%{host}">增加新的结论</s:a>
</s:form>

<s:form>
<tr><td><strong><font size="2">邀请组员</font></strong></td></tr>
</s:form>
<s:form action="topic_Invite" theme="simple">
<s:textfield name="username" label="用户：" value="%{username}" style="display:none"/>
<s:textfield name="password"   value="%{password}" style="display:none"/>
<s:textfield name="topic" label="话题：" value="%{topic}" style="display:none"/>
<s:textfield name="host" value="%{host}" style="display:none"/>
<s:textfield name="invitename" label="用户名" value=""/>
<s:submit style="width:100px" value="邀请"/>
</s:form>

<s:form>
<tr><td><strong><font size="3" color="red"><s:property value="message" /></font></strong></td></tr>
</s:form>

<s:form>
    <tr>
      <td>话题</td>
      <td>创建人</td>
      <td>发布时间</td>
    </tr>
     <s:iterator value="tpm">
    <tr>
      <td><s:property value="topic"/></td>
      <td><s:property value="host"/></td>
      <td><s:property value="time"/></td>
    </tr>
      <tr><td colspan="4">*概要：<s:property value="message"/></td></tr>
      <tr><td colspan="4">**********************************************************************************************</td></tr>
    </s:iterator>
</s:form>

<form>
	<tr>
      <td><s:a href="login.action?username=%{username}&password=%{password}">主页</s:a></td>
    </tr>
</form>

	
</table>

</body>
</html>