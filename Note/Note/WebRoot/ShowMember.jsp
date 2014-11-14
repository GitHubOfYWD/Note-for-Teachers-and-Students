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
                	 <p><span>成员</span><br><br>
                	 <s:iterator value="member" status="satt">
						<s:a href="topic_ShowMessage.action?username=%{username}&password=%{password}&topic=%{topic}&author=%{name}&host=%{host}&parentid=0"><s:property value="name"/></s:a> <br class="spacer" />
					</s:iterator>
					</p>					
                </div>
				
            </div><!--end of left content-->

			
			
			
			
			<div id="footer"></div>
		</div> <!--end of center box-->
		
	</div> <!--end of main content-->
</div> 
<!--end of main container-->
</body>
</html>
