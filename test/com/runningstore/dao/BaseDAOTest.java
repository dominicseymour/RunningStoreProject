package com.runningstore.dao;

import static com.runningstore.dao.BaseDAOTest.entityManager;
import static com.runningstore.dao.BaseDAOTest.entityManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BaseDAOTest {

	protected static EntityManagerFactory entityManagerFactory;
    protected static EntityManager entityManager;
    
    public static void setupClass() {

        entityManagerFactory = Persistence.createEntityManagerFactory("RunningStoreWebsite");
        entityManager = entityManagerFactory.createEntityManager();
    }
    
    public static void tearDownAfterClass() throws Exception {
		
		entityManager.close();
        entityManagerFactory.close();
	}
}
