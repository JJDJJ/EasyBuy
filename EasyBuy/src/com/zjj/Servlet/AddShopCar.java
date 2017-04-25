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
			String username = request.getParameter("username");   //��ȡ�û���
			int goodsid =Integer.parseInt( request.getParameter("goodsid")); //��ȡ��ƷID
			int num =Integer.parseInt(request.getParameter("num"));    //��ȡ���빺�ﳵ������
			System.out.println("��ƷID" + goodsid);
			System.out.println("���빺�ﳵ����" +num );
			double goods_subtotal =Double.parseDouble(request.getParameter("goods_subtotal"));  //��ȡС��
			System.out.println("��Ʒ" + goodsid + "С��" + goods_subtotal);
			int result = -1;			//��ʼ��update�Ƿ�ɹ���ֵΪ-1	
			ShoppingCar shoppingCar = new ShoppingCar(username, goodsid, num,goods_subtotal); //��������
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
