package myservlet.controls;
import mybean.data.*;
import java.io.*;
import myclass.bll.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HandleLogin extends HttpServlet{
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
	}
/*	public String handleString(String s){
		try{ byte bb[]=s.getBytes("utf-8");
		     s=new String(bb);
		}
		catch(Exception ee){}
		return s;
	}*/
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	       throws  ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		loginBean log=null;
		String backMessage="";
		HttpSession session=request.getSession(true);
		try{ log=(loginBean)session.getAttribute("login");
		     if(log==null)
		     {  log=new loginBean();
		        session.setAttribute("login", log);
		     }
		}
		catch(Exception ee){
			log=new loginBean();
			session.setAttribute("login", log);
		}
		String loginName=request.getParameter("loginName").trim(),
		       password=request.getParameter("password").trim();
		loginName=loginName;
		boolean ok=log.isSuccess();
		if(ok==true && loginName.equals(log.getLoginName())){
			backMessage="已经登录了";
			log.setBackMessage(backMessage);
		}
		else{
			examineeBll exambll=new examineeBll();
			int result=exambll.examineeLogin(loginName, password);
			if(result==1){
				backMessage="登录成功";
				log.setBackMessage(backMessage);
				log.setSuccess(true);
				log.setLoginName(loginName);			
			}
			else if(result==0){
				backMessage="您输入的身份证号或密码不符合要求！";
				log.setBackMessage(backMessage);
				log.setSuccess(false);
				log.setLoginName(loginName);
				log.setPassword(password);
			}
			else{
				backMessage="您输入的身份证号不存在或密码不正确！";
				log.setBackMessage(backMessage);
				log.setSuccess(false);
				log.setLoginName(loginName);
				log.setPassword(password);
			}
		}
		RequestDispatcher dispatcher=
			request.getRequestDispatcher("showLoginMess.jsp");
		dispatcher.forward(request, response);
	}

}
