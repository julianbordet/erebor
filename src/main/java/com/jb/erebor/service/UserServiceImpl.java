package com.jb.erebor.service;

import com.jb.erebor.dao.UserDAO;
import com.jb.erebor.dao.UserDAOHibernateImpl;
import com.jb.erebor.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO theUserDAO){
        userDAO = theUserDAO;
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }
}
