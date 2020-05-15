package com.runningstore.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.runningstore.entity.Users;

public class UserDAO extends JpaDAO<Users> implements GenericDAO<Users>  {

    public UserDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Users create(Users user) {
        return super.create(user);
    }

    @Override
    public Users update(Users users) {
        return super.update(users);
    }

    @Override
    public Users get(Object id) {
        return null;
    }

    @Override
    public void delete(Object id) {

    }

    @Override
    public List<Users> listAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }
}