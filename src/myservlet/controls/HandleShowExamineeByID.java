package myservlet.controls;
import java.io.*;
import mybean.data.loginBean;
import mybean.data.showExamineeByIDBean;
import myclass.bol.*;
import myclass.bll.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class HandleShowExamineeByID extends HttpServlet{
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
	        showExamineeByID(request,response);
      }
	}
	public void showExamineeByID(HttpServletRequest request ,HttpServletResponse
			response) throws ServletException,IOException{
		showExamineeByIDBean examineeinfo=new  showExamineeByIDBean();
		request.setAttribute("examineeinfo", examineeinfo);
		String examID=request.getParameter("examID");
		examineeBll exambll=new examineeBll();
		examinee exam=new examinee();
		exam=exambll.getExamineeByID(examID);
		if(exam!=null){
			examineeinfo.setAddress(exam.getAddress());
			examineeinfo.setBackMessage("查询到的考生信息如下：");
			examineeinfo.setCompany(exam.getCompany());
			examineeinfo.setEmail(exam.getEmail());
			examineeinfo.setExamID(exam.getExamID());
			examineeinfo.setExamName(exam.getExamName());
			examineeinfo.setExamType(exam.getExamType());
			examineeinfo.setMemo(exam.getMemo());
			examineeinfo.setPhone(exam.getPhone());
			examineeinfo.setPic(exam.getPic());
			examineeinfo.setSex(exam.getSex());
		}
		else{
			examineeinfo.setBackMessage("未查询到该考生信息！");
		}
		RequestDispatcher dispatcher=
			request.getRequestDispatcher("showExamineeByID.jsp");
		dispatcher.forward(request, response);
	}
}
