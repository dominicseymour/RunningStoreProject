package com.runningstore.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.runningstore.entity.Category;
import com.runningstore.entity.Trainer;
import com.runningstore.entity.Users;

import junit.framework.Assert;

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
		
		Category category = new Category("Track");
		category.setCategoryId(1);
		newTrainer.setCategory(category);
		
		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		Date releaseDate = dateFormat.parse("29/04/2019");
		newTrainer.setReleaseDate(releaseDate);
		
		newTrainer.setBrand("nike");
		newTrainer.setModel("Track spike");
		newTrainer.setDescription("Track racing shoe");
		newTrainer.setPrice(89.99f);
		
		String imagePath = "/Users/dom/Desktop/images/trainers/vaporfly_next%.jpg"; 
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		newTrainer.setImage(imageBytes);
		
		Trainer createdTrainer = trainerDAO.create(newTrainer);
		
		assertTrue(createdTrainer.getTrainerId() > 0);	
	}
	
	@Test
	public void testUpdateTrainer() throws ParseException, IOException {
		
		Trainer trainer = new Trainer();
		
		Category category = new Category("Track");
		category.setCategoryId(6);
		trainer.setCategory(category);
		
		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		Date releaseDate = dateFormat.parse("29/04/2019");
		trainer.setReleaseDate(releaseDate);
		
		trainer.setBrand("hoka");
		trainer.setModel("Carbon X");
		trainer.setDescription("Carbon plate racing shoe");
		trainer.setPrice(159.99f);
		
		String imagePath = "/Users/dom/Desktop/images/trainers/vaporfly_next%.jpg"; 
		byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
		trainer.setImage(imageBytes);
		trainer.setTrainerId(1);

		Trainer updatedTrainer = trainerDAO.update(trainer);
		
		assertEquals(trainer.getBrand(), updatedTrainer.getBrand());
	}
	
	@Test
	public void testDeleteTrainer() {
		
		Integer trainerId = 3;
    	trainerDAO.delete(trainerId);
    	
    	Trainer trainer = trainerDAO.find(Trainer.class, trainerId);
    	assertNull(trainer);
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void testDeleteTrainerFail() {
		
		Integer trainerId = 0;
    	trainerDAO.delete(trainerId);    	
	}
	
	@Test
	public void testGetTrainer() {
		
		Integer trainerId = 1;
		Trainer trainer = trainerDAO.get(trainerId);
		assertNotNull(trainer);
	}
	
	@Test()
	public void testGetTrainerNotFound() {
		
		Integer trainerId = 6;
		Trainer trainer = trainerDAO.get(trainerId);
		assertNull(trainer);
	}
	
	@Test
	public void testListAllTrainers() {
		
		List<Trainer> allTrainers = trainerDAO.listAll();
		assertTrue(allTrainers.size() > 0);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		BaseDAOTest.tearDownAfterClass();
	}

}
