package com.runningstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.runningstore.dao.CategoryDAO;
import com.runningstore.dao.UserDAO;
import com.runningstore.entity.Category;

public class CategoryServices {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private EntityManager entityManager;
	private CategoryDAO categoryDAO;

	public CategoryServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {

		this.request = request;
		this.response = response;
		this.entityManager = entityManager;
		categoryDAO = new CategoryDAO(entityManager);
	}

	public void listCategory(String message) throws ServletException, IOException {

		List<Category> categoryList = categoryDAO.listAll();
		request.setAttribute("categoryList", categoryList);
		
		if (message != null) {
			request.setAttribute("message", message);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("category_list.jsp");
		dispatcher.forward(request, response);
	}
	
	public void listCategory() throws ServletException, IOException {
		listCategory(null);
	}

}
