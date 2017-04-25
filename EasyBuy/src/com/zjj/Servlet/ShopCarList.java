package com.zjj.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.net.aso.s;

import com.zjj.Serviceimpl.ShoppingCarImpl;
import com.zjj.entity.ShoppingCar;

public class ShopCarList extends HttpServlet {

	private static final long serialVersionUID = 6752053547813339310L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ShoppingCarImpl shoImpl = new ShoppingCarImpl();
		
		String username = request.getParameter("username");   //获取用户名
		int goodsid =Integer.parseInt( request.getParameter("goodsid")); //获取商品ID
		int num =Integer.parseInt(request.getParameter("num"));    //获取加入购物车的数量
		double goods_subtotal =Double.parseDouble(request.getParameter("goods_subtotal"));  //获取小计
		int insertrow = -1;   //初始化插入是否成功的值为-1
		int rows = shoImpl.CheckGoodsById(goodsid, username);   //0：购物车内无该商品 /1：购物车内有此商品
		if(rows!=0){  //购物车内已有该商品
			int goodsnumbers =shoImpl.GetGoodsNum(goodsid, username) ; //获取已有商品个数		
			double goodsprice = shoImpl.GetShopCarGoodsPrice(goodsid, username); //获取已存小计 
			double sumprice = goods_subtotal + goodsprice;
			int result = -1;			//初始化update是否成功的值为-1
			int sum = num + goodsnumbers;		 //加入购物车的数量 + 已有商品个数		
			ShoppingCar shoppingCar = new ShoppingCar(username, goodsid, sum,sumprice);
			result =  shoImpl.update(shoppingCar);
			if(result != -1){
				out.println(1);
			}else{
				out.println(0);		
			}		
		}else { 
			ShoppingCar shoppingCar = new ShoppingCar(username, goodsid, num,goods_subtotal);
			insertrow = shoImpl.insert(shoppingCar);		 //插入新的商品
			if(insertrow != -1){
				out.println(1);
			}else{
				out.println(0);		
			}	
		}		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
