package com.jb.erebor.service;

import com.jb.erebor.dao.BugDAO;
import com.jb.erebor.entity.Bug;
import com.jb.erebor.entity.BugTransaction;
import com.jb.erebor.helper.BugTransactionsContainer;
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
    public Bug findBugById(int theId) {
        return bugDAO.findByBugId(theId);
    }

    @Override
    @Transactional
    public List<Bug> findBugsByDeveloper(String developerUsername) {
        return bugDAO.findBugsByDeveloper(developerUsername);
    }

    public BugTransactionsContainer findTransactionsForBug(int bugId){

        BugTransactionsContainer theBugTransactionContainer = new BugTransactionsContainer(bugDAO.findByBugId(bugId),
                bugDAO.findTransactionsForBug(bugId));

        return theBugTransactionContainer;
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
