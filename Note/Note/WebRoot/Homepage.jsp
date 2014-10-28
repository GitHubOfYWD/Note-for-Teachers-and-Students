<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
</head>
 <body>
 <table width="300" height="100">
<s:form>
<tr><td><strong><font size="5" color="red">你好，<s:property value="username" /></font></strong></td></tr>
</s:form>

<s:form>
<s:a href="createtopic_Go.action?username=%{username}">创建讨论</s:a>
</s:form>


<s:form>
	<tr>
      <td colspan="4"><strong><font size="3" color="red">创建的讨论组</font></strong></td>
    </tr>
    <tr>
      <td>讨论组</td>
      <td>创建者</td>
      <td> </td>
      <td> </td>
    </tr>
    <s:iterator value="ht" status="satt">
    <tr>
      <td> <s:a href="topic_ShowHost.action?username=%{host}&topic=%{topic}"><s:property value="topic"/></s:a></td>
      <td><s:property value="host"/></td>
    </tr>
    </s:iterator>
    <tr>
      <td><strong>..................................................</strong></td>
      <td><strong>..................................................</strong></td>
    </tr>
</s:form>

<s:form>
	<tr>
      <td colspan="4"><strong><font size="3" color="red">受邀请的讨论组</font></strong></td>
    </tr>
    <tr>
      <td>讨论组</td>
      <td>创建者</td>
      <td> </td>
      <td> </td>
    </tr>
    <s:iterator value="it" status="satt">
    <tr>
      <td><s:property value="topic"/></td>
      <td><s:property value="host"/></td>
    </tr>
    </s:iterator>
    <tr>
      <td><strong>..................................................</strong></td>
      <td><strong>..................................................</strong></td>
    </tr>
</s:form>
	
</table>

</body>
</html>
