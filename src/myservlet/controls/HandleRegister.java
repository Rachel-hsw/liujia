package myservlet.controls;

import mybean.data.*;
import java.io.*;
import myclass.bll.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class HandleRegister extends HttpServlet{
	public void init(ServletConfig config) throws 
	ServletException{
		super.init(config);
	}
	public void doPost(HttpServletRequest request ,
			HttpServletResponse response) throws ServletException,
			IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		registerBean reg=new registerBean();
		request.setAttribute("register", reg);
		String examID=request.getParameter("examID").trim(),
		examName=request.getParameter("examName").trim(),
 		sex=request.getParameter("sex").trim(),
		company=request.getParameter("company").trim(),
		address=request.getParameter("address").trim(),
        phone=request.getParameter("phone").trim(),
		email=request.getParameter("email").trim(),
		examType=request.getParameter("examType").trim(),
		memo=request.getParameter("memo").trim(),
		password=request.getParameter("password"),
		pic="",
		backMessage="";
		int result=0;
		try{
			examineeBll exambll=new examineeBll();
		
   		    result=exambll.CreateExaminee(examID, examName, sex, company,
		    address, phone, email, password, examType, memo, pic);
			if (result==0){
			backMessage="身份证号或密码不符合要求！请重新报考！";
			reg.setBackMessage(backMessage);
			}
			if(result==-1){
				backMessage="数据库访问发生错误！";
				reg.setBackMessage(backMessage);
			}
			if(result==-2){
				backMessage="身份证号码已存在！";
				reg.setBackMessage(backMessage);
			}
			if(result==1){
				backMessage="报名成功！";
				reg.setAddress(address);
				reg.setBackMessage(backMessage);
				reg.setCompany(company);
				reg.setEmail(email);
				reg.setExamName(examName);
				reg.setExamID(examID);
				reg.setExamType(examType);
				reg.setMemo(memo);
				reg.setPassword(password);
				reg.setPhone(phone);
				reg.setPic(pic);
				reg.setSex(sex);
			
			}			
		}
		catch(Exception ex){
			backMessage="发生错误"+ex.toString();
			reg.setBackMessage(backMessage);
		}
		RequestDispatcher dispatcher=
				request.getRequestDispatcher("showRegisterMess.jsp");
			dispatcher.forward(request, response);
	
	}
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException
	    {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		doPost(request,response);
		}

}

