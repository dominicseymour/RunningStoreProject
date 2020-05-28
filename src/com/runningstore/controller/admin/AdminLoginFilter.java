package com.runningstore.controller.admin;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter("/admin/*")
public class AdminLoginFilter implements Filter {

    public AdminLoginFilter() {
    }
    
    public void init(FilterConfig fConfig) throws ServletException {
		
	}
	
    public void destroy() {
	
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession httpSession = httpRequest.getSession(false);
		
		boolean loggedIn = (httpSession != null) && (httpSession.getAttribute("user_email") != null);
		String loginURI = httpRequest.getContextPath() + "/admin/login"; 
		boolean loginRequest = httpRequest.getRequestURI().equals(loginURI);
		boolean loginPageRequested = httpRequest.getRequestURI().endsWith("login.jsp");
		
		/* Check to see if login page has been requested when user is logged in */
		if (loggedIn && (loginPageRequested || loginRequest)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/");
			dispatcher.forward(request, response);
		}
		
		/* Check to see if the request is a login request */
		if (loggedIn || loginRequest) {
			chain.doFilter(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}

	}
}
