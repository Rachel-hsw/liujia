<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mybean.data.modifyMessageBean" %>
<jsp:useBean id="modify" type="mybean.data.modifyMessageBean" scope="request"/>
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
          <p><font size=4 color=red>欢迎您来修改报考信息！</font></p></center>
          <blockquote> <center>
          <p><font size=4 color=red><jsp:getProperty name="modify" property="backMessage"/>
          </font><br>
          <table >
             <tr><th colspan="2">您修改后的信息如下：</th></tr>
             <tr><td>考生姓名：</td><td><jsp:getProperty name="modify" property="examName"/></td></tr>
             <tr><td>考生性别：</td><td><jsp:getProperty name="modify" property="sex"/></td></tr>
             <tr><td>工作单位：</td><td><jsp:getProperty name="modify" property="company"/></td></tr>
             <tr><td>单位地址：</td><td><jsp:getProperty name="modify" property="address"/></td></tr>
             <tr><td>EMail：</td><td><jsp:getProperty name="modify" property="email" /></td></tr>
             <tr><td>联系电话：</td><td><jsp:getProperty name="modify" property="phone"/></td></tr>
             <tr><td>考试类别：</td><td><jsp:getProperty name="modify" property="examType"/></td></tr>
             <tr><td>备    注：</td><td><jsp:getProperty name="modify" property="memo"/></td></tr>  
          </table>
          </center>
          </blockquote>
      </div>
      <br class="clearfloat" />
      <%@ include file="txtfile/footer.txt" %>
    </div>
  </body>
</html>  

