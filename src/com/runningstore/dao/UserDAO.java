package com.runningstore.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import com.runningstore.entity.Users;

public class UserDAO extends JpaDAO<Users> implements GenericDAO<Users>  {

    public UserDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Users create(Users user) {
    	String encryptedPassword = HashGenerator.generateMD5(user.getPassword());
		user.setPassword(encryptedPassword);
        return super.create(user);
    }

    @Override
    public Users update(Users users) {
        return super.update(users);
    }

    @Override
    public Users get(Object userId) {
        return super.find(Users.class, userId);
    }

    @Override
    public void delete(Object id) {
    	super.delete(Users.class, id);
    }

    @Override
    public List<Users> listAll() {
        return super.findWithNamedQuery("Users.findAll");
    }

    @Override
    public long count() {
        return super.countWithNamedQuery("Users.countAll");
    }
    
    public Users findByEmail(String email) {
    	
    	List<Users> userList = super.findWithNamedQuery("Users.findByEmail", "email", email);
    	if (userList != null && userList.size() > 0) {
    		return userList.get(0);
    	}
    	
    	return null;
    }
    
    public boolean checkLogin(String email, String password) {
    	
    	Map<String, Object> parameters = new HashMap<>();
    	String encryptedPassword = HashGenerator.generateMD5(password);
    	parameters.put("email", email);
    	parameters.put("password", password);
    	
    	List<Users> userList = super.findWithNamedQuery("Users.checkLogin", parameters);
    	if (userList.size() == 1) {
    		return true;
    	}
    	
    	return false;
    }
}