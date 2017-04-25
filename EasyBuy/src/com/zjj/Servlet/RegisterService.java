package com.zjj.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjj.IService.IUserService;
import com.zjj.Serviceimpl.UserServiceImpl;
import com.zjj.entity.User;

public class RegisterService extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uname = URLDecoder.decode(URLDecoder.decode(request.getParameter("username"),"utf-8"),"utf-8"); 
		String upwd =  URLDecoder.decode(URLDecoder.decode(request.getParameter("userpwd"),"utf-8"),"utf-8") ; 
		User user = new User();
		user.setEmail(" ");
		user.setHeadpic("Aetly.jpg");
		user.setIdentity(" ");
		user.setPhone("");
		user.setSex(1);
		user.setUsername(uname);
		user.setUserpwd(upwd);
		IUserService iUserService = new UserServiceImpl(); 
		 int checkUname = iUserService.CheckUname(uname);
		 if(checkUname !=-1){
			 out.println(2);
		 }else {
			  int insert = iUserService.insert(user);
			  int insert2 = iUserService.insertuserinfo(user);
			  if(insert == 1 && insert2 == 1){
				  out.println(1);
			  }else {
				out.println(3);
			}
		 }
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
