package com.runningstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
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
        user1.setEmail("testuser009@test.com");
        user1.setPassword("password9");
        user1.setFullName("Test User009");
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
        user.setPassword("Password_001");
        user.setFullName("Test User001");

        user = userDAO.update(user);
        String expected = "Password_001";
        String actual = user.getPassword();

        assertEquals(expected, actual);

    }
    
    @Test
    public void testGetUsers() {
    	
    	Integer userId = 13;
    	Users user = userDAO.get(userId);
    	
    	assertNotNull(user);	
    }
    
    @Test
    public void testGetUsersNotFound() {
    	
    	Integer userId = 1;
    	Users user = userDAO.get(userId);
    	
    	assertNull(user);
    }
    
    @Test
    public void testDeleteUsers() {
    	
    	Integer userId = 22;
    	userDAO.delete(userId);
    	
    	Users user = userDAO.find(Users.class, userId);
    	assertNull(user);
    }
    
    @Test(expected = EntityNotFoundException.class)
    public void testDeleteNonExistUser() {
    	
    	Integer userId = 1;
    	userDAO.delete(userId);
    	    	
    }
    
    @Test
    public void testListAllUsers() {
    	
    	List<Users> allUsers = userDAO.listAll();
    	assertTrue(allUsers.size() > 0);
    }
    
    @Test
    public void testCountAllUsers() {
    	
    	long count = userDAO.count();
    	assertTrue(count == 5);
    }
    
    @Test
    public void testFindByEmail() {
    	Users user = userDAO.findByEmail("bob@bob.com");
    	assertNotNull(user);
    	
    }

    @AfterClass
    public static void teardownClass() {
        entityManager.close();
        entityManagerFactory.close();
    }

}
