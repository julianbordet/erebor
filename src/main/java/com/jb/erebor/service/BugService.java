package com.jb.erebor.service;

import com.jb.erebor.entity.Bug;
import com.jb.erebor.entity.BugTransaction;
import com.jb.erebor.helper.BugTransactionsContainer;

import java.util.List;

public interface BugService {

    public List<Bug> findAll();

    public Bug findBugById(int theId);

    public List<Bug> findBugsByDeveloper(String developerUsername);

    public BugTransactionsContainer findTransactionsForBug(int bugId);

    public void save(Bug theBug);

    public void merge(Bug theBug);

    public void deleteById(int theId);

    void compareBugsAndCreateTransaction(Bug updatedBug, Bug originalBug);

    void deleteTransactions(Bug theBug);

}
