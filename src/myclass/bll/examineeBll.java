package myclass.bll;
import java.sql.*;
import java.io.Serializable;
import java.util.ArrayList;
import myclass.dal.*;
import myclass.bol.*;


public class examineeBll {

	public int CreateExaminee(String examID,String examName,String sex,
			String company,String address,String phone,String email,
			String password,String examType,String memo,String pic){
		examineeDal examDal=new examineeDal();
		int result=0;
		if((examID.length()==15||examID.length()==18)&&
				password.length()>0){			
			boolean isLD=true;
			for(int i=0;i<examID.length();i++){
				char c=examID.charAt(i);
				if(!((c<='z'&&c>='a')||(c<='Z')&&(c>='A')||
						(c<='9')&&(c>='0'))){
					isLD=false;				
				}				
			}
			if(isLD==true && examDal.getExamineeByID(examID)!=null){
				return result=-2;			
			}
			if(isLD==true){
				result=examDal.CreateExaminee(examID, examName, sex, company,
						address, phone, email, password, examType, memo, pic);				
			}
		}
		else{
			System.out.println("身份证号或密码不符合要求！");
			System.out.println("函数返回值："+result);
		}
		return result;
	}

	public int examineeLogin(String examID,String password){
		examineeDal examDal=new examineeDal();
		int result=0;
		if((examID.length()==15||examID.length()==18)&&password.length()>0){
			examinee exam=null;
			exam=examDal.getExamineeByIdPwd(examID, password);
			if(exam!=null){
				result=1;
			}
			else{
				result=-1;
			}
	    }
		return result;
	}
	

	public int setExamineePic(String examID,String picStr){
		examineeDal examDal=new examineeDal();
		
		return examDal.setExamineePic(examID, picStr);		
	}
	
	public examinee getExamineeByID(String examID){
		examinee exam  =null;
		examineeDal examdal=new examineeDal();
		exam=examdal.getExamineeByID(examID);
		return exam;
		
	}
	
    public ArrayList<examinee> getExamineeAll(){
    	examineeDal examdal=new examineeDal();
    	return examdal.getExamineeAll();
    }

    public int setExamineePwd(String examID,String newPassword,
    		String oldPassword){
    	int result=0;
    	examineeDal examdal=new examineeDal();
    	if(newPassword =="" || newPassword.equals(oldPassword)){
    		return result;
    	}
    	if(examdal.getExamineeByIdPwd(examID, oldPassword)!=null){
    		result=examdal.setExaminePwd(examID, newPassword);
    	}
    	else {
    		result=-1;
    	}
    	return result; 	
    }

    public int updateExaminByID(String examID,String examName,String sex,
			String company,String address,String phone,String email,
			String examType,String memo){
    	examineeDal examdal=new examineeDal();
    	int result=0;
    	if(examName.length()>0){
    		result=examdal.updateExamineeByID(examID, examName, sex, 
    			company, address, phone, email, examType, memo);
    	}
    	else{
    		return result=-1;
    	}
    	return result;	
    }
    

    public int deleteExmineeByID(String examID){
		examineeDal examdal=new examineeDal();
		int result=0;
    	if(examID==null){
    		result=-2;			
		}
    	if(examID.length()>0){
    		result=examdal.deleteExmineeByID(examID);    		
    	}
    	return result;
	}
	
}
