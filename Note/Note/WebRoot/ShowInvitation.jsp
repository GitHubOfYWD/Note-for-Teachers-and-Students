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
                	 <p><span><strong><font size="5" color="red"><s:property value="username"/></font></strong></span><br><br>
					</p>					
                </div>
				
            </div><!--end of left content-->
			
			
			<div class="left_content_myhome">
            	<div class="calendar_box_myhome">
					<br>
                	 <p><span>邀请</span><br><br>
                	<s:form>
                	 <s:iterator value="iv" status="satt">
						<tr>
						<td><font size="3" color="red"><s:property value="inviting"/></font>邀请您到讨论组<font size="3" color="red"><s:property value="topic"/></font></td>
						<td> <s:a href="invitation_accept.action?topic=%{topic}&inviting=%{inviting}&invited=%{username}&host=%{host}&username=%{username}&password=%{password}" onclick="return confirm('接受邀请');">接受</s:a></td>
						</tr>
					</s:iterator>
					</s:form>
					</p>	
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
