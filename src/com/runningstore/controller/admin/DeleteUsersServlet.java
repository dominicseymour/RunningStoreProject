package com.runningstore.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.runningstore.service.UserServices;

@WebServlet("/admin/delete_user")
public class DeleteUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteUsersServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserServices userServices = new UserServices(request, response);
		userServices.deleteUser();
	}

}
