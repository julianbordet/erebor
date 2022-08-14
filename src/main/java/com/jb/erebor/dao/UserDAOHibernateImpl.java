package com.jb.erebor.dao;

import com.jb.erebor.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.List;

@Repository
public class UserDAOHibernateImpl implements UserDAO {

    private EntityManager entityManager;

    @Autowired
    public UserDAOHibernateImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<User> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<User> theQuery = currentSession.createQuery("from User", User.class);

        List<User> userList = theQuery.getResultList();

        return userList;

    }
}
