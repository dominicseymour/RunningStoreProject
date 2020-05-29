package com.runningstore.dao;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import com.runningstore.entity.Trainer;

public class TrainerDAO extends JpaDAO<Trainer> implements GenericDAO<Trainer> {

	public TrainerDAO(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Trainer create(Trainer trainer) {
		trainer.setLastUpdatedOn(new Date());
		return super.create(trainer);
	}

	@Override
	public Trainer update(Trainer trainer) {
		trainer.setLastUpdatedOn(new Date());
		return super.update(trainer);
	}

	@Override
	public Trainer get(Object trainerId) {		
		return super.find(Trainer.class, trainerId);
	}

	@Override
	public void delete(Object trainerId) {
		super.delete(Trainer.class, trainerId);		
	}

	@Override
	public List<Trainer> listAll() {
		return super.findWithNamedQuery("Trainer.findAll");
	}
	
	public Trainer findByModel(String model) {
		
		List<Trainer> trainers = super.findWithNamedQuery("Trainer.findByModel", "model", model);
		if (trainers != null && trainers.size() > 0) {
    		return trainers.get(0);
    	}
    	
    	return null;
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Trainer.countAll");
	}

	
}
