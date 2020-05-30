package com.runningstore.controller.admin.trainer;

import com.runningstore.controller.BaseServlet;
import com.runningstore.service.TrainerServices;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/list_trainers")
public class ListTrainerServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;

    public ListTrainerServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		TrainerServices trainerServices = new TrainerServices(entityManager, request, response);
		trainerServices.listTrainers();
	}

}
