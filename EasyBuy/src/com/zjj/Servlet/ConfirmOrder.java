package com.zjj.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zjj.Serviceimpl.ShoppingCarImpl;
import com.zjj.entity.ShoppingCar;

public class ConfirmOrder extends HttpServlet {


	private static final long serialVersionUID = 2189487447813086247L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String name = session.getAttribute("username").toString();	
		ShoppingCarImpl shoImpl = new ShoppingCarImpl();
		List<ShoppingCar> CarList = shoImpl.GetGoodsByUser(name);
		List<ShoppingCar> list = new ArrayList<ShoppingCar>();
		String allprice = request.getParameter("allprice"); //总计
		for(int i = 0;i<CarList.size();i++){
			ShoppingCar shoppingCar = new ShoppingCar();
			shoppingCar.setGoodsname(CarList.get(i).getGoodsname());		
			shoppingCar.setGoods_img(CarList.get(i).getGoods_img());
			shoppingCar.setGoods_introduce(CarList.get(i).getGoods_introduce());
			shoppingCar.setGoods_money(CarList.get(i).getGoods_money());
			shoppingCar.setGoods_num(CarList.get(i).getGoods_num());
			shoppingCar.setGoods_subtotal(CarList.get(i).getGoods_subtotal());
			list.add(shoppingCar);
		}
		session.setAttribute("carlist", list);
		
		out.println(1);  //全部执行完后返回1
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
