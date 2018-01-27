package myservlet.controls;
import java.io.*;
import mybean.data.loginBean;
import mybean.data.showExamineeByPage;
import myclass.bol.*;
import myclass.bll.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class HandleShowExamineeByPage extends HttpServlet{
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
	}
	public String handleString(String s){
		try{byte bb[]=s.getBytes("utf-8");
		    s=new String(bb);
		}
		catch(Exception ee){}
		return s;
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
	        showExamineeByPage(request,response);
      }
	}
	public void showExamineeByPage(HttpServletRequest request,HttpServletResponse
			response) throws ServletException,IOException{
		HttpSession session=request.getSession(true);
		StringBuffer presentPageResult=new StringBuffer();
		showExamineeByPage showBean=null;

		try{ showBean=(showExamineeByPage)session.getAttribute("examineebypage");
		    if(showBean==null){
		    	showBean=new showExamineeByPage();
		    	session.setAttribute("examineebypage", showBean);
		    }
		}
		catch(Exception exp){
			showBean=new showExamineeByPage();
			session.setAttribute("examineebypage", showBean);
		}

		showBean.setPageSize(3);
	
		String strShowPage=request.getParameter("showPage");
		for(int i=0;i<strShowPage.length();i++){
			char c=strShowPage.charAt(i);
			if(!(c>='0' && c<='9'))
			{
				strShowPage="1";
				break;
			}
		}
		if(strShowPage==""){
			strShowPage="1";
		}
		int showPage=Integer.parseInt(strShowPage);
		int pageSize=showBean.getPageSize();
		try{
			examineeBll exambll=new examineeBll();
			showBean.setList(exambll.getExamineeAll());
			int m=showBean.getList().size();
			int n=pageSize;
			int pageAllCount=((m%n)==0)?(m/n):(m/n+1);
			showBean.setPageAllCount(pageAllCount);		
			if(showPage>showBean.getPageAllCount()){
				showPage=1;
			}
			if(showPage<=0){
				showPage=showBean.getPageAllCount();
			}
			showBean.setShowPage(showPage);
			presentPageResult=show(showPage,pageSize,showBean);
			showBean.setPresentPageResult(presentPageResult);
		}
		catch(Exception exp){
			System.out.println(exp.toString());
		}
		RequestDispatcher dispatcher=
			request.getRequestDispatcher("showExamineeAll.jsp");
		dispatcher.forward(request, response);
	}

	public StringBuffer show(int page,int pageSize,showExamineeByPage showBean){
		StringBuffer str=new StringBuffer();
		try {
		     for(int i=(page-1)*pageSize;i<=page*pageSize-1;i++){
		    	 str.append("<tr>");
		    	 str.append("<td>"+handleString(showBean.getList().get(i).getExamName())+"</td>");
		    	 str.append("<td>"+handleString(showBean.getList().get(i).getExamType())+"</td>");
		    	 str.append("<td>"+handleString(showBean.getList().get(i).getSex())+"</td>");
		    	 str.append("<td>"+handleString(showBean.getList().get(i).getCompany())+"</td>");
		    	 str.append("</tr>");
		    
		     }
	
		}
		catch(Exception exp){System.out.println("执行到这里page="+page);
		      return str;
		}		
		return str;
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse
			response) throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		doPost(request,response);
	}
}
