package com.zjj.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zjj.Serviceimpl.OrderServiceImpl;

public class OrderDetailsFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String orderid = request.getParameter("orderid");
		if(orderid == null){
			response.sendRedirect("/EasyBuy/PersonCenter.jsp");
		}else{	
			OrderServiceImpl orImpl = new OrderServiceImpl();
			int rows = orImpl.CheckOrder(orderid);
			if(rows ==0){
					response.sendRedirect("/EasyBuy/PersonCenter.jsp");
			}else {
				  chain.doFilter(request, response);
			}
		  
		}
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}




}
