package com.zjj.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zjj.Serviceimpl.AddressServiceImpl;
import com.zjj.entity.Address;

public class ChooseAddress extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8829641798211536731L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String adressid = request.getParameter("addressid");
		HttpSession session = request.getSession();
		session.getAttribute("username");
		session.setAttribute("address", adressid);	
		AddressServiceImpl addressServiceImpl = new AddressServiceImpl();
		List<Address> addresslist = addressServiceImpl.GetAllAddress(session.getAttribute("username").toString());
		session.setAttribute("defautaddress", addresslist.get(0).getId());
		int defautaddress = Integer.parseInt(session.getAttribute("defautaddress").toString());
		int addressid =Integer.parseInt(session.getAttribute("address").toString());
		if(addressid !=0){
			out.println(1);
		}else if(defautaddress!=0){			
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
