package com.jb.erebor.service;

import com.jb.erebor.entity.Bug;

import java.util.List;

public interface BugService {

    public List<Bug> findAll();

    public Bug findBugById(int theId);

    public List<Bug> findBugsByDeveloper(String developerUsername);

    public void save(Bug theBug);

    public void deleteById(int theId);

}
