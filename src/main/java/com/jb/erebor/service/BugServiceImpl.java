package com.jb.erebor.service;

import com.jb.erebor.dao.BugDAO;
import com.jb.erebor.entity.Bug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BugServiceImpl implements  BugService{

    private BugDAO bugDAO;

    @Autowired
    public BugServiceImpl(BugDAO theBugDAO){
        bugDAO = theBugDAO;
    }

    @Override
    @Transactional
    public List<Bug> findAll() {
        return bugDAO.findAll();
    }

    @Override
    @Transactional
    public Bug findById(int theId) {
        return bugDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Bug theBug) {
        bugDAO.save(theBug);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        bugDAO.deleteById(theId);
    }
}
