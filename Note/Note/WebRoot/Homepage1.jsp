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
                	 <p><span><strong><font size="5" color="red"><s:property value="username"/></font></strong></span><br>
                	 <s:a href="invitation_show.action?username=%{username}&password=%{password}"><font size="3" color="blue"><s:property value="newinvitation"/></s:a><br class="spacer" /><br/>
                	 <s:a href="createtopic_Go.action?username=%{username}&password=%{password}&host=%{host}">创建讨论</s:a><br class="spacer" />
					</p>					
                </div>
				
            </div><!--end of left content-->
			
			
			<div class="left_content_myhome">
            	<div class="calendar_box_myhome">
					<br>
                	 <p><span>您所参加的讨论</span><br><br>
                	 <s:iterator value="ht" status="satt">
                	 	<!--<s:a href="topic_ShowHost.action?username=%{username}&password=%{password}&topic=%{topic}&host=%{host}"><s:property value="topic"/>---<s:property value="host"/></s:a> <br class="spacer" />-->
						<s:a href="topic_ShowTime.action?username=%{username}&password=%{password}&topic=%{topic}&host=%{host}"><font color="red"><s:property value="topic"/>---<s:property value="host"/></font></s:a> <br class="spacer" />
					</s:iterator>
					<!-- 
                   		<a href="#" title="topic">讨论一:aaaaaa</a> <br class="spacer" />
                   		<a href="#" title="topic">讨论二:bbbbbb</a> <br class="spacer" />
						<a href="#" title="topic">讨论三:cccccc</a> <br class="spacer" />
                        <a href="#" title="topic">讨论四:dddddd</a> <br class="spacer" /><br>
                     -->
					</p>
					<form>
	   					 <tr>
      					    <td><s:a href="Login1.jsp">登出</s:a></td>
     					   </tr>
   					 </form>						
                </div>
				
            </div><!--end of left content-->
            
            
            
            
           
            
            
         <!-- 
            <div class="left_content_myhome">
            	<div class="calendar_box_myhome">
					<br>
                	 <p><span>您收藏的话题</span><br><br>
                	 <s:iterator value="fm" status="satt">
						<s:a href="topic_ShowMessage.action?username=%{username}&password=%{password}&topic=%{topic}&author=%{author}&host=%{host}&parentid=%{id}&parentmessage=%{message}"><font color="red"><s:property value="author"/>:</font><font color="black"><s:property value="message"/></font></s:a> <br class="spacer" />
					</s:iterator>
					</p>
					<form>
	   					 <tr>
      					    <td><s:a href="Login1.jsp">登出</s:a></td>
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
