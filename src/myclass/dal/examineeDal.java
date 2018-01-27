package myclass.dal;



import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import myclass.dal.DBAccess;
import myclass.bol.examinee;


public class examineeDal {
	

	
	public int CreateExaminee(String examID,String examName,String sex,
			String company,String address,String phone,String email,
			String password,String examType,String memo,String pic){
		int result=0;
		String createSql="insert into examinee(id,name,sex,company," +
				"address,phone,email,password,examType,memo,pic)"+
		        "values('"+examID+"','"+examName+"','"+sex+"','"+
		        company+"','"+address+"','"+phone+"','"+email+"','"+
		        password+"','"+examType+"','"+memo+"','"+pic+"')";
		DBAccess dba=new DBAccess();
        try{ 
             if(dba.getConn()!=null) 
             {
            	 result=dba.executeSql(createSql);
             }
         }
         catch(Exception ne)
         {
             System.out.println("examineedal 出现如下错误：<br>");
             System.out.println(ne);
         }
         finally{
        	 dba.closeConnection(); 
         }	
         return result;
	}
	

	public examinee getExamineeByID(String examID){
        DBAccess dba=new DBAccess();
        examinee exam=null;
        try{ 
             if(dba.getConn()!=null&&examID!=null) 
             { 
              	String str="select * from examinee where id='"+examID+"'";
       	 		ResultSet rst=dba.query(str);
        		if(rst!=null&&rst.next()){
      	           exam=new examinee(rst.getString(1),rst.getString(2),rst.getString(3),
      	        		   rst.getString(4),rst.getString(5),rst.getString(6),
      	        		   rst.getString(7),rst.getString(8),rst.getString(10),
      	        		   rst.getString(9),rst.getString(11));
      	      
                }
             }
         }
         catch(Exception ne)
         {
        	 System.out.println("examineedal:getExamineeByID发生错误");
         }
         finally{
        	 dba.closeConnection(); 
         }
         return exam;
	}
	

	public ArrayList<examinee> getExamineeAll(){
		DBAccess dba=new DBAccess();
        ArrayList<examinee> examList=new ArrayList<examinee>();
        try{ 
             if(dba.getConn()!=null) 
             {
              	String str="select * from examinee";
       	 		ResultSet rst=dba.query(str);
        		while (rst!=null&&rst.next())
        		{
        			if(rst.getString("id")!=null){
        			    examinee exam=new examinee(rst.getString(1),rst.getString(2),rst.getString(3),
      	        		   rst.getString(4),rst.getString(5),rst.getString(6),
      	        		   rst.getString(7),rst.getString(8),rst.getString(10),
      	        		   rst.getString(9),rst.getString(11));
        			    examList.add(exam);
        			}
                }
             }
         }
         catch(Exception ne)
         {  
        	 System.out.println("examineedal:getExamineeall发生错误");
         }
         finally{
        	 dba.closeConnection(); 
         }
         return examList;		
	}
	

	public examinee getExamineeByIdPwd(String examID,String password){
		DBAccess dba=new DBAccess();
        examinee exam=null;
        try{ 
             if(dba.getConn()!=null&&examID!=null&&password!=null) 
             {  System.out.println("数据库连接已建立");
              	String str="select * from examinee where id=? and password=?";
              	PreparedStatement prpSql;
              	prpSql=dba.getConn().prepareStatement(str);
              	prpSql.setString(1, examID);
              	prpSql.setString(2, password);
       	 		ResultSet rst=dba.query(prpSql);
        		if(rst!=null&&rst.next()){
      	           exam=new examinee(rst.getString(1),rst.getString(2),rst.getString(3),
      	        		   rst.getString(4),rst.getString(5),rst.getString(6),
      	        		   rst.getString(7),rst.getString(8),rst.getString(10),
      	        		   rst.getString(9),rst.getString(11));
                }
                if(prpSql!=null){
                	prpSql.close();
                	prpSql=null;
                }
             }
         }
         catch(Exception ne)
         {
        	 System.out.println("examineedal:getexamineebyIDPwd发生错误");
         }
         finally{
        	 dba.closeConnection(); 
         }
         return exam;
	}

	public int setExaminePwd(String examID,String newPassword){
		DBAccess dba=new DBAccess();
		int result=0;		
		try{  
            if(dba.getConn()!=null){
		      PreparedStatement prpSql;
		      String strSql="Update examinee set password=? where id=?";
		      prpSql=dba.getConn().prepareStatement(strSql);
		      prpSql.setString(1, newPassword);
		      prpSql.setString(2, examID);
			  result=dba.executeSql(prpSql);
	          if(prpSql!=null){
	            	prpSql.close();
	            	prpSql=null;
	          }
            }
		}
		catch(Exception ne)
		{
			System.out.println("exmaineedal:setPassword发生错误");
			result=-1;
		}
		finally
		{
			dba.closeConnection();			
		}
		return result;
	}

	public int updateExamineeByID(String examID,String examName,String sex,
			String company,String address,String phone,String email,
			String examType,String memo){
		DBAccess dba=new DBAccess();
		int result=0;
		try{  
            if(dba.getConn()!=null){
			  PreparedStatement prpSql;
		      String strSql="update examinee set name=?,sex=?,company=?,"+
		      		"address=?,phone=?,email=?,examType=?,memo=? where id=?";
		      prpSql=dba.getConn().prepareStatement(strSql);
		      prpSql.setString(1, examName);
		      prpSql.setString(2, sex);
		      prpSql.setString(3, company);
		      prpSql.setString(4, address);
		      prpSql.setString(5, phone);
		      prpSql.setString(6, email);
		      prpSql.setString(7, examType);
		      prpSql.setString(8, memo);
		      prpSql.setString(9, examID);
		      result=prpSql.executeUpdate();
	          if(prpSql!=null){
	            	prpSql.close();
	            	prpSql=null;
	          }
            }
		}
		catch(Exception ne){
			ne.printStackTrace();
			System.out.println(ne.toString());
			return -1;
		}
		finally{
			dba.closeConnection();
		}
		return result ;
	}
	

	public int setExamineePic(String examID,String picStr){
		DBAccess dba=new DBAccess();
		int result=0;
		try{
            if(dba.getConn()!=null){
		        String strSql="update examinee set pic='"+picStr+
		          "' where id='"+examID+"'";
		        result=dba.executeSql(strSql);
            }
		}
		catch(Exception ne)
		{
			System.out.println("发生错误"+ne);
			ne.printStackTrace();			
		}
		finally{
			dba.closeConnection();
		}
		return result;
	}
	

	public int deleteExmineeByID(String examID){
		DBAccess dba=new DBAccess();
		int result=0;
		try{
			if(dba.getConn()!=null){
			  PreparedStatement prpSql;
		      String strSql="delete from examinee where id=?";
		      prpSql=dba.getConn().prepareStatement(strSql);
		      prpSql.setString(1, examID);
		      result=prpSql.executeUpdate();
	          if(prpSql!=null){
	            	prpSql.close();
	            	prpSql=null;
	          }
			}
		}
		catch(Exception ne){
			ne.printStackTrace();
			System.out.println(ne.toString());
			return -1;
		}
		finally{
			dba.closeConnection();
		}
		return result ;
	}
}

