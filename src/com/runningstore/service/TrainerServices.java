package com.runningstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.runningstore.dao.CategoryDAO;
import com.runningstore.dao.TrainerDAO;
import com.runningstore.entity.Category;
import com.runningstore.entity.Trainer;

public class TrainerServices {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private TrainerDAO trainerDAO;
	private CategoryDAO categoryDAO;
	
	public TrainerServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {

		this.request = request;
		this.response = response;
		this.trainerDAO = new TrainerDAO(entityManager);
		this.categoryDAO = new CategoryDAO(entityManager);
	}
	
	public void listTrainers(String message) throws ServletException, IOException {
		
		List<Trainer> trainerList = trainerDAO.listAll();
		request.setAttribute("trainerList", trainerList);
		
		if (message != null) {

			request.setAttribute("message", message);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("trainer_list.jsp");
		dispatcher.forward(request, response);
	}
	
	public void listTrainers() throws ServletException, IOException {
		
		listTrainers(null);
	}
	
	public void showNewTrainerForm() throws ServletException, IOException {
		
		List<Category> categoryList = categoryDAO.listAll();
		request.setAttribute("categoryList", categoryList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("trainer_form.jsp");
		dispatcher.forward(request, response);
	}
	

}
