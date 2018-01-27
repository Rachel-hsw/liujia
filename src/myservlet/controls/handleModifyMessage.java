package myservlet.controls;

import java.io.*;
import mybean.data.loginBean;
import mybean.data.modifyMessageBean;
import myclass.bol.*;
import myclass.bll.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class handleModifyMessage extends HttpServlet{
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
	}

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
	        modifyExamMessage(request,response);
       }
	}
	
	public void modifyExamMessage(HttpServletRequest request,HttpServletResponse response)
	     throws ServletException,IOException{
		HttpSession session=request.getSession(true);
		loginBean log=(loginBean)session.getAttribute("login");
		String loginName=log.getLoginName();
		modifyMessageBean modify=new modifyMessageBean();
		request.setAttribute("modify", modify);
		String examName=request.getParameter("examName").trim(),
		       examType=request.getParameter("examType").trim(),
		       address=request.getParameter("address").trim(),
		       company=request.getParameter("company").trim(),
		       email=request.getParameter("email").trim(),
		       memo=request.getParameter("memo").trim(),
		       phone=request.getParameter("phone").trim(),
		       sex=request.getParameter("sex").trim();
		examineeBll exambll=new examineeBll();
		int result=exambll.updateExaminByID(loginName, examName, sex,
			   company, address, phone, email, examType, memo);
		if(result==1){
			modify.setAddress(address);
			modify.setBackMessage("修改报名信息成功！");
			modify.setCompany(company);
			modify.setEmail(email);
			modify.setExamID(loginName);
			modify.setExamName(examName);
			modify.setExamType(examType);
			modify.setMemo(memo);
			modify.setPhone(phone);
			modify.setSex(sex);			
		}
		else if(result==-1){
			modify.setBackMessage("考生姓名有错误！信息未修改！");
		}
		else {
			modify.setBackMessage("信息修改失败！");
		}
		RequestDispatcher dispatcher=
			request.getRequestDispatcher("showModifyMessage.jsp");
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
