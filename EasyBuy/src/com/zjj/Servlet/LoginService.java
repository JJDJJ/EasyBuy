package com.zjj.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zjj.IService.IUserService;
import com.zjj.Serviceimpl.UserServiceImpl;
import com.zjj.entity.User;

public class LoginService extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("null")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uname = URLDecoder.decode(URLDecoder.decode(request.getParameter("username"),"utf-8"),"utf-8"); 
		String upwd =  URLDecoder.decode(URLDecoder.decode(request.getParameter("upwd"),"utf-8"),"utf-8")  ; 
		User users = new User(uname, upwd);
		IUserService userService = new  UserServiceImpl();		
		User user = userService.Login(users);
		int result  = userService.CheckUname(uname);
		//判断账户密码是否正确
		if(user.getUsername()!=null && user.getUserpwd()!=null){
			HttpSession session = request.getSession();
			session.setAttribute("username",uname);
			out.println(1);	 //登录成功返回1
		
		}
		else if(result == -1) {
			out.println(2); 	//帐号不存在返回2
		}else {
			out.println(3); 	//帐号或密码错误返回3
		}	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
