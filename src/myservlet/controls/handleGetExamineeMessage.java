package myservlet.controls;

import mybean.data.*;
import java.io.*;
import myclass.bol.*;
import myclass.bll.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class handleGetExamineeMessage extends HttpServlet{
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}
	/*public String handleString(String s){
		try{byte bb[]=s.getBytes("utf-8");
		    s=new String(bb);
		}
		catch(Exception ee){}
		return s;
	}*/
	public void doPost(HttpServletRequest request ,HttpServletResponse
	         response) throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
        HttpSession session=request.getSession(true);
        loginBean log=(loginBean)session.getAttribute("login");
        if(log==null){
	        response.sendRedirect("login.jsp");
        }
        else{
	        getExamMessage(request,response);
        }
	}
	
	public void getExamMessage(HttpServletRequest request,HttpServletResponse 
			response) throws ServletException,IOException{
		HttpSession session=request.getSession(true);
		loginBean log=(loginBean)session.getAttribute("login");
		String loginName=log.getLoginName();
		registerBean reg =new registerBean();
		request.setAttribute("register", reg);
		examineeBll exambll=new examineeBll();
		examinee exam=new examinee();
		exam=exambll.getExamineeByID(loginName);
		if(exam!=null)
		{
			reg.setAddress(exam.getAddress());
		
			reg.setBackMessage("您原来的报名信息：");
			reg.setCompany(exam.getCompany());
			reg.setEmail(exam.getEmail());
			reg.setExamID(exam.getExamID());
			reg.setExamName(exam.getExamName());
			reg.setExamType(exam.getExamType());
			reg.setMemo(exam.getMemo());
			reg.setPhone(exam.getPhone());
			reg.setSex(exam.getSex());
			reg.setPassword(exam.getPassword());
			reg.setPic(exam.getPic());
		}
		else{
			reg.setBackMessage("获取用户信息发生错误！");
		}
		RequestDispatcher dispatcher
		     =request.getRequestDispatcher("modifymessage.jsp");
		dispatcher.forward(request, response);	
	}
	public void doGet(HttpServletRequest request,HttpServletResponse
			response) throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		doPost(request,response);
	}
}