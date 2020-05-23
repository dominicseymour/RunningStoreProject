package com.runningstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.runningstore.entity.Category;
import com.runningstore.entity.Users;

public class CategoryDAOTest extends BaseDAOTest {
	
    private static CategoryDAO categoryDAO;
    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BaseDAOTest.setupClass();
		categoryDAO = new CategoryDAO(entityManager);
	}

	@Test
	public void testCreateCategory() {
		
		Category category = new Category("Test2");
		categoryDAO.create(category);	
        assertTrue(category.getCategoryId() > 0);
	}

	@Test
	public void testUpdateCategory() {

		Category category = new Category("New category");
		category.setCategoryId(8);
		
		Category updatedCategory = categoryDAO.update(category);
		
		assertEquals(category.getName(), updatedCategory.getName());
	}

	@Test
	public void testGeCategoryt() {
		
		Integer categoryId = 23;
		Category category = categoryDAO.get(categoryId);
		assertNotNull(category);
	}

	@Test
	public void testDeleteCategory() {
		
		Integer categoryId = 7;
		categoryDAO.delete(categoryId);
		
		Category category = categoryDAO.find(Category.class, categoryId);
		
		assertNull(category);
	}

	@Test
	public void testListAllCategories() {
		
		List<Category> categoryList = categoryDAO.listAll();
		assertTrue(categoryList.size() > 0);
	}

	@Test
	public void testCountCategories() {
		
		long count = categoryDAO.count();
		assertTrue(count == 4);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BaseDAOTest.tearDownAfterClass();
	}

}
