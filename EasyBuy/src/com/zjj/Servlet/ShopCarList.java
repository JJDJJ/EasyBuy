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
		
		String username = request.getParameter("username");   //��ȡ�û���
		int goodsid =Integer.parseInt( request.getParameter("goodsid")); //��ȡ��ƷID
		int num =Integer.parseInt(request.getParameter("num"));    //��ȡ���빺�ﳵ������
		double goods_subtotal =Double.parseDouble(request.getParameter("goods_subtotal"));  //��ȡС��
		int insertrow = -1;   //��ʼ�������Ƿ�ɹ���ֵΪ-1
		int rows = shoImpl.CheckGoodsById(goodsid, username);   //0�����ﳵ���޸���Ʒ /1�����ﳵ���д���Ʒ
		if(rows!=0){  //���ﳵ�����и���Ʒ
			int goodsnumbers =shoImpl.GetGoodsNum(goodsid, username) ; //��ȡ������Ʒ����		
			double goodsprice = shoImpl.GetShopCarGoodsPrice(goodsid, username); //��ȡ�Ѵ�С�� 
			double sumprice = goods_subtotal + goodsprice;
			int result = -1;			//��ʼ��update�Ƿ�ɹ���ֵΪ-1
			int sum = num + goodsnumbers;		 //���빺�ﳵ������ + ������Ʒ����		
			ShoppingCar shoppingCar = new ShoppingCar(username, goodsid, sum,sumprice);
			result =  shoImpl.update(shoppingCar);
			if(result != -1){
				out.println(1);
			}else{
				out.println(0);		
			}		
		}else { 
			ShoppingCar shoppingCar = new ShoppingCar(username, goodsid, num,goods_subtotal);
			insertrow = shoImpl.insert(shoppingCar);		 //�����µ���Ʒ
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
