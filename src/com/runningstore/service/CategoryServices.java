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
import com.runningstore.entity.Users;

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

	public void createCategory() throws ServletException, IOException {

		String name = request.getParameter("name");

		if (categoryDAO.findByName(name) != null) {
			String errorMessage = "Could not create category. A category with name " + name + " already exists";
			request.setAttribute("message", errorMessage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
		}

		Category newCategory = new Category(name);
		categoryDAO.create(newCategory);
		listCategory("New category successfully created");
	}

	public void editCategory() throws ServletException, IOException {

		int categoryId = Integer.parseInt(request.getParameter("id"));
		Category category = categoryDAO.get(categoryId);
		String destinationPage = "category_form.jsp";

		if (category == null) {

			destinationPage = "message.jsp";
			request.setAttribute("message", "Could not find category with id " + categoryId);

		} else {

			request.setAttribute("category", category);

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(destinationPage);
		dispatcher.forward(request, response);
	}

	public void updateCategory() throws ServletException, IOException {

		/*
		 * Get the id and name of the category to be edited from the request parameters
		 */
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		String name = request.getParameter("name");
		
		/* Get the category by it's id and by it's name */
		Category categoryById = categoryDAO.get(categoryId);
		Category categoryByName = categoryDAO.findByName(name);

		/*
		 * If the name exists and it does not belong to the category being edited then
		 * show error
		 */
		if (categoryByName != null && categoryByName.getCategoryId() != categoryById.getCategoryId()) {
			request.setAttribute("message",
					"Could not update category. Category with name " + name + " already exists");
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
		} else {

			Category category = new Category(categoryId, name);
			categoryDAO.update(category);
			listCategory("Category has been updated successfully");
		}

	}

	public void deleteCategory() throws ServletException, IOException {

		int categoryId = Integer.parseInt(request.getParameter("id"));
		String message;
		Category category = categoryDAO.get(categoryId);
		
		if (category == null) {
			message = "Could not find category with ID " + categoryId + ", or it might have been deleted by another admin.";
			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
			return;
		} 
		
		/*
		 * TrainerDAO trainerDAO = new TrainerDAO(); long numberOfTrainers =
		 * trainerDAO.countByCategory(categoryId);
		 * 
		 * if (numberOfTrainers > 0) { message = "Could not delete the category (ID: " +
		 * categoryId + ") because it currently contains some trainers."; } else {
		 * categoryDAO.delete(categoryId); message =
		 * "Category has been deleted successfully"; }
		 */

		categoryDAO.delete(categoryId);
		message = "Category has been deleted successfully";
		listCategory(message);
	}

}
