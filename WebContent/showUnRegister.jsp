<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mybean.data.unregisterBean" %>
<jsp:useBean id="unregister" type="mybean.data.unregisterBean" scope="request"/>

<%
request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>职称计算机考试报名</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="网上报名,职称考试,计算机">
	<meta http-equiv="description" content="网上报名首页">
	<link href="css/mystylesheet.css" rel="stylesheet" type="text/css" />

</head>
  
  <body class="twoColHybLtHdr">
    <div id="container">
      <div id="header">
         <%@ include file="txtfile/header.txt" %>
      </div>
      <div id="sidebar1">
         <%@ include file="txtfile/left.txt" %>
      </div>
      <div id="mainContent"  >
          <center > 
           <p><font size=4 color=red>欢迎您使用注销功能！</font></p></center>
          <br><center><font size=4 color=blue>
          <jsp:getProperty name="unregister" property="backMessage" />
          </font></center>
          <% if(unregister.isFlag()){%>
            <center><br>考生:<jsp:getProperty name="unregister" 
             property="loginName" />已经删除</center>
          <%}
            else {
          %><br><center>考生：<jsp:getProperty name="unregister" 
             property="loginName" />未删除</center>
          <%} %>
      </div>
      <br class="clearfloat" />
      <%@ include file="txtfile/footer.txt" %>
    </div>
  </body>
</html>  

