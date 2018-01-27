<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mybean.data.showExamineeByIDBean" %>
<jsp:useBean id="examineeinfo" type="mybean.data.showExamineeByIDBean" scope="request"/>
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
          <p><font size=4 color=red>欢迎您使用浏览功能！</font></p></center>
          <p>
          <center><p><font size=5 color=blue>
             <jsp:getProperty name="examineeinfo" property="backMessage"/></font></p>
            <table width="318" border="1">
              <tr>
                <th width="19" scope="row">身份证号</th>
                <td colspan="3"><jsp:getProperty name="examineeinfo" property="examID" /></td>
                <td colspan="2" rowspan="2">照片
                   <img src=image/<jsp:getProperty name="examineeinfo" property="pic"/> width=90 height=100></td>
              </tr>
              <tr>
                <th width="19" height="15" scope="row">考生姓名</th>
                <td width="18" ><jsp:getProperty name="examineeinfo" property="examName"/></td>
                <td >性别</td>
                <td><jsp:getProperty name="examineeinfo" property="sex"/></td>
              </tr>
              <tr>
                <th scope="row">工作单位</th>
                <td colspan="5"><jsp:getProperty name="examineeinfo" property="company"/></td>
              </tr>
              <tr>
                <th scope="row">单位地址</th>
                <td colspan="5"><jsp:getProperty name="examineeinfo" property="address"/></td>
              </tr>
              <tr>
                <th scope="row">联系电话</th>
                <td colspan="3"><jsp:getProperty name="examineeinfo" property="phone"/></td>
                <td>考试类别</td>
                <td><jsp:getProperty name="examineeinfo" property="examType"/></td>
              </tr>
              <tr>
                <th scope="row">邮箱</th>
                <td colspan="5"><jsp:getProperty name="examineeinfo" property="email"/></td>
              </tr>
              <tr>
                <th scope="row">备注</th>
                <td colspan="5"><jsp:getProperty name="examineeinfo" property="memo"/></td>
              </tr>
            </table>
            <p>&nbsp;</p>
            </center>
      </div>
      <br class="clearfloat" />
      <%@ include file="txtfile/footer.txt" %>
    </div>
  </body>
</html>  

