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

import com.zjj.IService.ServiceFactory;
import com.zjj.entity.Goods;

public class GoodsInfoFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub 
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String goodsid =request.getParameter("goodsid");
		Goods goods = null;
		try {
			 goods = ServiceFactory.getService("Goods").findByID(Integer.parseInt(goodsid));
			 if(goods == null){
				 response.sendRedirect("/EasyBuy/Home.jsp");
			 }else{
				 if(goods.getGoodsid() == 0){
					 response.sendRedirect("/EasyBuy/Home.jsp");
				 }else{
					 chain.doFilter(request, response);
				 }			
			 }
		} catch (Exception e) {
			 response.sendRedirect("/EasyBuy/Home.jsp");
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
