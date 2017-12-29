package com.springboots.courseAPI.config;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

@Component
public class CustomFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("destroy called");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("doFilter called");
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		Principal userPrincipal = request.getUserPrincipal();
		System.out.println("userPrincipal:: "+userPrincipal);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("App called");
	}

}
