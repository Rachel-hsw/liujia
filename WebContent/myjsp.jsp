<%@ page contentType="text/html;  charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.naming.Context" %> 
<%@ page import="javax.sql.DataSource"%> 
<%@ page import="javax.naming.InitialContext"%> 
<%@ page import="java.sql.*"%> 
<%@ page import="myclass.dal.*" %>
<%@ page import="myclass.bol.*" %>
<%@ page import="java.util.ArrayList" %>
<html>
<body>

<%request.setCharacterEncoding("UTF-8");
response.setCharacterEncoding("UTF-8");
        DBAccess dba=new DBAccess();
        examineeDal examd=new examineeDal();
        ArrayList<examinee> list=new ArrayList<examinee>();        
        try{ 
        	int rsult= examd.CreateExaminee("123456789123456789","杨学全","男","河北农大","保定市领域四杰",
            		 "838838383","kdiek@die.kdi","yang","高级","计算机类","框框"); 
        	 out.println(rsult);
             dba.getConnection(); 
             if(dba.getConn()!=null) 
             {
             	out.println("已经获得DataSource!"); 
              	out.println("<br>");
              	String str="select * from examinee";
       	 		ResultSet rst=dba.query(str);//从一个已存在的表中读取数据
       	 		out.println("以下是从数据库中读取出来的数据:<br>");
        		while(rst.next()){
        		   out.println("<br>");
        		   out.println(rst.getString(1));}        	
                }
                out.println("<br>系统时间："+DBAccess.getSysDate());
                examinee exambean=null;
                exambean=examd.getExamineeByID("123456789123456789");
                out.println("<br><br>"+exambean.getExamID());
                list=examd.getExamineeAll();
                for(examinee e:list){
                	out.println("<br>这是通过ArrayList得到的值："+e.getExamID());
                }
         }
         catch(Exception ne)
         {
             out.println("出现如下错误：<br>");
             out.println(ne);
         }
         finally{
        	 dba.closeConnection(); 
        	 out.println("<br>已经关闭DataSource!");
         }
%> 
</body>
</html>
