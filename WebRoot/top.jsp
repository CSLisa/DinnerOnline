<%@page import="exmvc.entity.impl.Users"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'top.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <div style="padding:0px;font:bold 13px/43px 'Microsoft YaHei','SimSun',Arial,Sans-Serif;color:#feab43;"> 
                 <%
                   if(session.getAttribute("user") != null ){
                   Users ur = (Users)session.getAttribute("user");
                   String name = "";
                   name=ur.getName();
                   %>
                                                               亲爱的<%=name %>您好!&nbsp;&nbsp;欢迎光临!
                   <%} %>
    </div>
  </body>
</html>
