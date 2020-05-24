package com.runningstore.controller.admin.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.runningstore.controller.admin.BaseServlet;
import com.runningstore.service.UserServices;

@WebServlet("/admin/create_user")
public class CreateUserServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserServices userServices = new UserServices(entityManager, request, response);
		userServices.createUser();
	}

}
