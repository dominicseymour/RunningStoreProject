package com.runningstore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.runningstore.dao.TrainerDAO;
import com.runningstore.entity.Trainer;

public class TrainerServices {
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private TrainerDAO trainerDAO;
	
	public TrainerServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {

		this.request = request;
		this.response = response;
		trainerDAO = new TrainerDAO(entityManager);
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
	

}
