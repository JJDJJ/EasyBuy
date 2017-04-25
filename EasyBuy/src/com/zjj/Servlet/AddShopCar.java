package com.zjj.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjj.Serviceimpl.ShoppingCarImpl;
import com.zjj.entity.ShoppingCar;

public class AddShopCar extends HttpServlet {

	private static final long serialVersionUID = -3595767939447082403L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ShoppingCarImpl shoImpl = new ShoppingCarImpl();
			String username = request.getParameter("username");   //获取用户名
			int goodsid =Integer.parseInt( request.getParameter("goodsid")); //获取商品ID
			int num =Integer.parseInt(request.getParameter("num"));    //获取加入购物车的数量
			System.out.println("商品ID" + goodsid);
			System.out.println("加入购物车数量" +num );
			double goods_subtotal =Double.parseDouble(request.getParameter("goods_subtotal"));  //获取小计
			System.out.println("商品" + goodsid + "小计" + goods_subtotal);
			int result = -1;			//初始化update是否成功的值为-1	
			ShoppingCar shoppingCar = new ShoppingCar(username, goodsid, num,goods_subtotal); //覆盖数量
			System.out.println(shoppingCar.toString());
			result =  shoImpl.update(shoppingCar);
			if(result != -1){
				out.println(1);
			}else{
				out.println(0);		
			}			
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
