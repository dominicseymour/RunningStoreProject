package com.runningstore.controller.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.runningstore.controller.BaseServlet;
import com.runningstore.dao.CategoryDAO;
import com.runningstore.entity.Category;

@WebServlet("")
public class HomeServlet extends BaseServlet { 

	private static final long serialVersionUID = 1L;
       
    public HomeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CategoryDAO categoryDAO = new CategoryDAO(entityManager);
		List<Category> categoryList = categoryDAO.listAll();
		request.setAttribute("categoryList", categoryList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("frontend/index.jsp");
		dispatcher.forward(request, response);
	}

}
