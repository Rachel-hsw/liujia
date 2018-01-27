<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <script src="js/check.js" language="JavaScript" type="text/javascript"></script>
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
              <p><font size=4 color=red>欢迎您来报名！</font></p></center>
          <blockquote>
          <center>
          <form action="helpRegister" name="form1" method="post"  onsubmit="return check()" >
           <p>输入你的信息，身份证号必须由字母或者数字组成，带*号必须填写。
           <table bgcolor=>
           <tr>
           <td>身份证号:</td><td><Input name="examID" type=text id="examID" >*</td></tr>
           <tr>
           <td>考生姓名：</td><td><Input name="examName" type=text id="examName">*</td></tr>
           <tr>
           <td>设置密码：</td><td><Input name="password" type=password id="password">*</td></tr>
           <tr>
           <td>考生性别：</td><td><Input name="sex" type=radio id="sex" value="男" checked >男
           <input type=radio name="sex" value="女" id="sex" >女</td></tr>
           <tr>
           <td>工作单位: </td><td><Input name="company" type=text id="company"></td></tr>
           <tr>
           <td>单位地址: </td><td><input name="address" type=text id="address"></td></tr>
           <tr>
           <td>联系电话:</td><td><input name="phone" type=text id="phone"></td></tr>
           <tr>
           <td>EMIL:</td><td><input name="email" type=text id="email">*</td></tr>
           <tr>
           <td>报考类别:</td><td><Select name="examType" size=2>
             <option Selected value="高级">高级
                  <option value="中级">中级
             </Select></td></tr>
           <tr><td>备注:</td><td><TextArea name="memo" Rows="6" Cols="30"></TextArea>
           </td></tr>
           <tr><td></td><td><input type="submit" value="提交" name="submit"  ></td></tr>
           </table>
           </form>
           </center>
          </blockquote>
      </div>
      <br class="clearfloat" />
      <%@ include file="txtfile/footer.txt" %>
    </div>
  </body>
</html>  

