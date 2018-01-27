package myservlet.controls;

import java.io.*;

import mybean.data.loginBean;
import mybean.data.uploadFileBean;
import myclass.bll.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HandleUploadFile extends HttpServlet{
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
    	    String loginName=log.getLoginName();    	    
	        uploadFileMethod(request,response,loginName);
      }
	}
	public void  uploadFileMethod(HttpServletRequest request,HttpServletResponse
			response,String loginName) throws ServletException,IOException{
		uploadFileBean upFile=new uploadFileBean();
		String backMessage="";
		try{
			HttpSession session=request.getSession(true);
			request.setAttribute("upFile", upFile);
			String tempFileName=(String)session.getId();
			InputStream in=request.getInputStream();
			String saveFileName=loginName,
		
			driverPath=request.getRealPath("image");
			uploadFileBll upbll=new uploadFileBll();
			boolean flag=upbll.uploadFileMethod(driverPath, tempFileName, 
					saveFileName, in);
		 
			if(flag){
				examineeBll exambll=new examineeBll();
				int n=exambll.setExamineePic(loginName, upbll.getSavedFileName());
				if(n==1){
					backMessage="文件上传成功！";
					upFile.setBackMessage(backMessage);
					upFile.setFileName(upbll.getUploadFileName());
					upFile.setSavedFileName(upbll.getSavedFileName());
				}
				else{
					backMessage="文件上传失败！";
				}
			}
			else{
				backMessage="文件上传失败！";
				upFile.setBackMessage(backMessage);
			}			
		}
		catch(Exception exp){
			backMessage=""+exp;
			upFile.setBackMessage(backMessage);
		}
		RequestDispatcher dispatcher=
			request.getRequestDispatcher("showUploadMess.jsp");
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
