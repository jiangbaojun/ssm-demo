package com.ssm.block.other.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws java.io.IOException, ServletException {

		//come
//		System.out.println(request.getAttribute("user"));

		// 把请求传回过滤链
		chain.doFilter(request, response);
		
		//go
//		System.out.println(request.getAttribute("user"));
		
		
	}

	public void destroy() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
}