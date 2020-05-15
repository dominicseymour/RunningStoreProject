package com.runningstore.dao;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.runningstore.entity.Users;

public class UserDAOTest {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static UserDAO userDAO;

    @BeforeClass
    public static void setupClass() {

        entityManagerFactory = Persistence.createEntityManagerFactory("RunningStoreWebsite");
        entityManager = entityManagerFactory.createEntityManager();
        userDAO = new UserDAO(entityManager);
    }

    @Test
    public void testCreateUser() {

        Users user1 = new Users();
        user1.setEmail("testuser002@test.com");
        user1.setPassword("password");
        user1.setFullName("Test User002");
        userDAO.create(user1);

        assertTrue(user1.getUserId() > 0);
    }

    @Test(expected = PersistenceException.class)
    public void testCreateUserFieldsNotSet() {

        Users user1 = new Users();
        userDAO.create(user1);
    }

    @Test
    public void testUpdateUser() {

        Users user = new Users();
        user.setUserId(13);
        user.setEmail("testuser001@test.com");
        user.setPassword("Updated_Password");
        user.setFullName("Test User001");

        user = userDAO.update(user);
        String expected = "Updated_Password";
        String actual = user.getPassword();

        assertEquals(expected, actual);

    }

    @AfterClass
    public static void teardownClass() {
        entityManager.close();
        entityManagerFactory.close();
    }

}
