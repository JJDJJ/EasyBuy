package com.zjj.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zjj.Serviceimpl.ShoppingCarImpl;
import com.zjj.entity.ShoppingCar;

public class ShopCarFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession();
		String name = session.getAttribute("username").toString();	
		ShoppingCarImpl shoImpl = new ShoppingCarImpl();
		List<ShoppingCar> CarList = shoImpl.GetGoodsByUser(name);
		if(CarList.size() == 0){
			response.sendRedirect("/EasyBuy/Emptyshopcar.jsp");
		}else{
			chain.doFilter(request, response);
		}
	}

	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	

}
