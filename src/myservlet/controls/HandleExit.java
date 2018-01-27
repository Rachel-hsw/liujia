package myservlet.controls;

import mybean.data.*;

import java.io.*;


import myclass.bol.*;
import myclass.bll.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HandleExit extends HttpServlet{
	
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}
/*	public String handleString(String s){
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
	        logoutExam(request,response);
       }
	}
	
	public void logoutExam(HttpServletRequest request,HttpServletResponse 
			response) throws ServletException,IOException{
		HttpSession session=request.getSession(true);
		session.invalidate();
		response.sendRedirect("index.jsp");
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse
			response) throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		doPost(request,response);
	}

}
