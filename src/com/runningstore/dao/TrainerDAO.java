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
	public Trainer get(Object id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Object trainerId) {
		super.delete(Trainer.class, trainerId);		
	}

	@Override
	public List<Trainer> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
