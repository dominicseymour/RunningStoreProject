package com.runningstore.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.runningstore.dao.UserDAO;
import com.runningstore.entity.Users;

public class UserServices {
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private UserDAO userDAO;
	
	public UserServices() {
		
		entityManagerFactory = Persistence.createEntityManagerFactory("RunningStoreWebsite");
		entityManager = entityManagerFactory.createEntityManager();
		
		userDAO = new UserDAO(entityManager);
	}

	public List<Users> listUsers() {
		
		return userDAO.listAll();
	}

}
