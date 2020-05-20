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
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private UserDAO userDAO;
	
	public UserServices(HttpServletRequest request, HttpServletResponse response) {
		
		this.request = request;
		this.response = response;
		
		entityManagerFactory = Persistence.createEntityManagerFactory("RunningStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		userDAO = new UserDAO(entityManager);
	}

	public void listUsers(String message) throws ServletException, IOException {
		
		List<Users> usersList = userDAO.listAll();
		request.setAttribute("UsersList", usersList);
		
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
		
		Users newUser = userDAO.create(new Users(email, fullName, password));
		userDAO.create(newUser);
	}

}
