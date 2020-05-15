package com.trainerstore.entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.runningstore.entity.Users;

public class UsersTest {

	public static void main(String[] args) {
		
		Users user1 = new Users();
		user1.setEmail("test123@test.com");
		user1.setPassword("password");
		user1.setFullName("Test Test123");
		
		// Create EntityManagerFactory
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("RunningStoreWebsite");

		// Create EntityManager from EntityManagerFactory
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		// Begin a transaction
		entityManager.getTransaction().begin();
		
		entityManager.persist(user1);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println("A users object was persistent");
	}

}
