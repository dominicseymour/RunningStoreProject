package com.runningstore.controller.admin.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.runningstore.controller.BaseServlet;
import com.runningstore.service.UserServices;

@WebServlet("/admin/edit_user")
public class EditUserServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;
       
    public EditUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserServices userService = new UserServices(entityManager, request, response);
		userService.editUser();
	}
}
