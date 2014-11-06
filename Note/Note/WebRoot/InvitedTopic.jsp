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
      <tr><td colspan="4">*                                 概要：<s:property value="message"/></td></tr>
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