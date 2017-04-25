package com.zjj.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjj.Serviceimpl.ShoppingCarImpl;

public class DeleteGoods extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3009271674930282405L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("username");
		int goodsid =Integer.parseInt( request.getParameter("goodsid"));
		ShoppingCarImpl sImpl = new ShoppingCarImpl();
		int rows = sImpl.DeleteGoodsByID(goodsid, uname);		
		if(rows ==1){  //删除成功返回影响行数
			out.println(1);
		}else{
			out.println(rows);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
