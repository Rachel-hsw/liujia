<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="register" type="mybean.data.registerBean" scope="request"/>
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
	<script type="text/javascript">
	function check(){
        var txt=document.form1.email.value;
        if(txt.search("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$")!=0){
          alert("电子邮件地址不正确！");
          document.form1.email.select();
          return false;
          }
        }
	</script>
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
          <blockquote>
            <center>
            <form action="helpModifyMessage" name=form1 method="post" onsubmit="return check()" >
            <p><jsp:getProperty name="register" property="backMessage"/>
            <p>
            <table bgcolor=>
              <tr>
              <td>考生姓名：</td><td><Input name="examName" type=text id="examName"
                  value=<jsp:getProperty name="register" property="examName" /> >*</td></tr>
              <tr>
              <td>考生性别：</td><td>
              <% if("男".equals(register.getSex())){
               %><Input name="sex" type=radio id="sex" value="男" checked>男
                <input type=radio name="sex" value="女" id="sex" >女
              <%}
               else{%>
                <Input name="sex" type=radio id="sex" value="男" >男
                <input type=radio name="sex" value="女" id="sex" checked >女
              <%}%>
               </td></tr>
              <tr>
                <td>工作单位: </td><td><Input name="company" type=text id="company"
                 value=<jsp:getProperty name="register" property="company" /> ></td></tr>
              <tr>
                <td>单位地址: </td><td><input name="address" type=text id="address"
                  value=<jsp:getProperty name="register" property="address"/> ></td></tr>
              <tr>
                <td>联系电话:</td><td><input name="phone" type=text id="phone"
                  value=<jsp:getProperty name="register" property="phone"/> ></td></tr>
              <tr>
                <td>EMIL:</td><td><input name="email" type=text id="email"
                  value=<jsp:getProperty name="register" property="email"/>></td></tr>
              <tr>
                <td>报考类别:</td><td><Select name="examType" size=2>
                    <% if("高级".equals(register.getExamType())){ %>
                               <option Selected value="高级">高级
                               <option value="中级">中级
                    <%}
                    else{ %>
                               <option value="高级">高级
                               <option Selected value="中级">中级
                    <%} %>                              
                               </Select></td></tr>
              <tr><td>备注:</td><td><TextArea name="memo" Rows="6" Cols="30"><jsp:getProperty 
              name="register" property="memo"/>
              </TextArea>
              </td></tr>
              <tr><td></td><td align="center" >
              <input type="submit" value="提交" name="submit" >
              <input type="reset" value="重置" name="submit" ></td></tr>
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

