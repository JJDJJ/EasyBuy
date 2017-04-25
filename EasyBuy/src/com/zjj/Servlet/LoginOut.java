package com.zjj.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginOut extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5283925340292787556L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("username");
		if(uname !=null){
			HttpSession session = request.getSession();
			if(session.getAttribute("username")!=null){	
				session.removeAttribute("username");
			}		
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
