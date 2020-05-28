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

import com.runningstore.dao.UserDAO;
import com.runningstore.entity.Users;

public class UserServices {

	private HttpServletRequest request;
	private HttpServletResponse response;
	private UserDAO userDAO;

	public UserServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {

		this.request = request;
		this.response = response;
		userDAO = new UserDAO(entityManager);
	}

	public void listUsers(String message) throws ServletException, IOException {

		List<Users> usersList = userDAO.listAll();
		request.setAttribute("usersList", usersList);

		if (message != null) {

			request.setAttribute("message", message);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("user_list.jsp");
		dispatcher.forward(request, response);
	}

	public void listUsers() throws ServletException, IOException {

		listUsers(null);
	}

	public void createUser() throws ServletException, IOException {

		String email = request.getParameter("email");
		String fullName = request.getParameter("fullname");
		String password = request.getParameter("password");

		if (userDAO.findByEmail(email) != null) {

			String errorMessage = "Could not create user. A user with email address " + email + " already exists";
			request.setAttribute("message", errorMessage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);

		} else {

			Users newUser = new Users(email, fullName, password);
			userDAO.create(newUser);
			listUsers("New user successfully created");
		}
	}

	public void editUser() throws ServletException, IOException {

		int userId = Integer.parseInt(request.getParameter("id"));
		Users user = userDAO.get(userId);
		String destinationPage = "user_form.jsp";

		if (user == null) {

			destinationPage = "message.jsp";
			request.setAttribute("message", "Could not find user with id " + userId);

		} else {
			
			user.setPassword(null);
			request.setAttribute("user", user);

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(destinationPage);
		dispatcher.forward(request, response);
	}

	public void updateUser() throws ServletException, IOException {

		int userId = Integer.parseInt(request.getParameter("userId"));
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullname");
		String password = request.getParameter("password");

		Users userById = userDAO.get(userId);
		Users userByEmail = userDAO.findByEmail(email);

		if (userByEmail != null && userByEmail.getUserId() != userById.getUserId()) {
			request.setAttribute("message", "Could not update user. User with email " + email + " already exists");
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
		} else {

			Users user = new Users(userId, email, fullName, password);
			userDAO.update(user);
			listUsers("User has been updated successfully");
		}

	}

	public void deleteUser() throws ServletException, IOException {

		int userId = Integer.parseInt(request.getParameter("id"));
		
		if (userId == 1) {
			request.setAttribute("message", "The default admin user account cannot be deleted.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
		} else if (userDAO.get(userId) == null) {
			request.setAttribute("message", "Could not find user with ID  " + userId + ", or it might have been deleted by another admin.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);
		} else {
			userDAO.delete(userId);
			listUsers("User successfully deleted");
		}
	}
	
	public void login() throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if (!userDAO.checkLogin(email, password)) {
			request.setAttribute("message", "Login failed.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		} else {
			request.getSession().setAttribute("user_email", email);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/");
			dispatcher.forward(request, response);
		}
	}

}
