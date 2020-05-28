package com.runningstore.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.runningstore.entity.Category;
import com.runningstore.entity.Trainer;

public class TrainerDAOTest extends BaseDAOTest {
	
	private static TrainerDAO trainerDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		BaseDAOTest.setupClass();
        trainerDAO = new TrainerDAO(entityManager);
	}

	@Test
	public void testCreateTrainer() throws ParseException, IOException {

		Trainer newTrainer = new Trainer();
		
		Category category = new Category("Road");
		category.setCategoryId(1);
		newTrainer.setCategory(category);
		
		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		Date releaseDate = dateFormat.parse("29/04/2019");
		newTrainer.setReleaseDate(releaseDate);
		
		newTrainer.setBrand("nike");
		newTrainer.setModel("Vaporfly Next%");
		newTrainer.setDescription("Carbon plate racing shoe");
		newTrainer.setPrice(219.99f);
		
		String imagePath = "/Users/dom/Desktop/images/trainers/vaporfly_next%.jpg"; 
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		newTrainer.setImage(imageBytes);
		
		Trainer createdTrainer = trainerDAO.create(newTrainer);
		
		assertTrue(createdTrainer.getTrainerId() > 0);
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BaseDAOTest.tearDownAfterClass();
	}

}
