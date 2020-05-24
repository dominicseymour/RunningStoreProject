package com.runningstore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.runningstore.entity.Category;

public class CategoryDAO extends JpaDAO<Category> implements GenericDAO<Category> {

	public CategoryDAO(EntityManager entityManager) {
		super(entityManager);
	}
	
	@Override
	public Category create(Category category) {
		return super.create(category);
	}
	
	@Override
	public Category update(Category category) {
		return super.update(category);
	}

	@Override
	public Category get(Object categoryId) {
		return super.find(Category.class, categoryId);
	}

	@Override
	public void delete(Object categoryId) {
		super.delete(Category.class, categoryId);
	}

	@Override
	public List<Category> listAll() {
		return super.findWithNamedQuery("Category.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Category.countAll");
	}
	
	public Category findByName(String name) {
		
		List<Category> categoryList = super.findWithNamedQuery("Category.findByName", "name", name);
		
		if (categoryList != null && categoryList.size() > 0) {
    		return categoryList.get(0);
    	}
		
		return null;
		
	}

	
}
