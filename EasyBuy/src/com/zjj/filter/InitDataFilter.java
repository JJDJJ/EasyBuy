package com.zjj.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjj.DAOimpl.GoodsDaoImpl;
import com.zjj.IService.ServiceFactory;
import com.zjj.Serviceimpl.GoodsServiceImpl;
import com.zjj.entity.Goods;

public class InitDataFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
		FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		List<Goods> goodslist = ServiceFactory.getService("Goods").findAll();
		request.setAttribute("goodslist",goodslist);
		chain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {
		
	}



	

}
