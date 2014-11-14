<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>讨论</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="main_container">
	<div class="parrot"><img src="images/arrow1.gif" alt="" title=""></div>
	
	<div class="main_content">
	
    	<div id="header">
        	<div class="logo"><a href="#"><img src="images/logo.gif" alt="" title="" border="0"></a></div>
        </div>	
			
        <div class="top_center_box"></div>
		
		<div class="center_box">
		
            <div id="menu_tab"></div> 
			
            <div class="left_content_myhome">
            	<div class="calendar_box_myhome">
					<br>
					<s:form>
						<tr><td><strong><font size="5"><s:property value="topic" /></font></strong></td></tr>
						<tr><td><strong><font size="5"><s:property value="author" />的观点</font></strong></td></tr>
					</s:form>
					<br>	
					<s:form>
    					<tr>
    					   <td><font size="3" color="red"><strong>话题</strong></font></td>
    					  <td><font size="3" color="red"><strong>发布人</strong></font></td>
    					  <td><font size="3" color="red"><strong>发布时间</strong></font></td>
    					  <td><font size="3" color="red"><strong>ID</strong></font></td>
    					  <td><font size="3" color="red"><strong>ParentID</strong></font></td>
    					</tr>
                	 <s:iterator value="tmm">
                    	 <tr>
                      	 <td><font size="3"><s:property value="topic"/></font></td>
                     	  <td><font size="3"><s:property value="author"/></font></td>
                      	 <td><font size="3"><s:property value="time"/></font></td>
                      	 <td><font size="3"><s:property value="id"/></font></td>
                      	 <td><font size="3"><s:property value="parentid"/></font></td>
                    	 </tr>
                     	  <tr><td colspan="4"><font size="3">*概要：<s:property value="message"/></font></td></tr>
                     	  <tr><td><s:a href="topic_ShowMessage.action?username=%{username}&password=%{password}&topic=%{topic}&author=%{author}&host=%{host}&parentid=%{id}&parentmessage=%{message}"><font color="red">相关讨论</font></s:a></td></tr>
                      	 <tr><td colspan="4">**********************************************************************************************</td></tr>
   					 </s:iterator>	
   					 </s:form>
   					 <form>
	   					 <tr>
      					    <td><s:a href="login.action?username=%{username}&password=%{password}">主页</s:a></td>
     					   </tr>
   					 </form>		
                </div>
				
            </div><!--end of left content-->
			
			
			
			
			<div id="footer"></div>
		</div> <!--end of center box-->
		
	</div> <!--end of main content-->
</div> 
<!--end of main container-->
</body>
</html>
