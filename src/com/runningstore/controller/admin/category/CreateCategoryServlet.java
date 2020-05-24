package com.runningstore.controller.admin.category;

import com.runningstore.controller.admin.BaseServlet;
import com.runningstore.service.CategoryServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/create_category")
public class CreateCategoryServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategoryServices categoryServices = new CategoryServices(entityManager, request, response);
		categoryServices.createCategory();
	}

}
