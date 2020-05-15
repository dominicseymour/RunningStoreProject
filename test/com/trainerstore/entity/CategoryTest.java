package com.trainerstore.entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.runningstore.entity.Category;
import com.runningstore.entity.Users;

public class CategoryTest {

	public static void main(String[] args) {
		
        Category category = new Category("Track");

        // Create EntityManagerFactory
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("RunningStoreWebsite");

        // Create EntityManager from EntityManagerFactory
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // Begin a transaction
        entityManager.getTransaction().begin();

        entityManager.persist(category);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        System.out.println("A category object was persisted");
	}

}
