package com.jb.erebor.dao;

import com.jb.erebor.entity.Bug;

import java.util.List;

public interface BugDAO {

    public List<Bug> findAll();

    public Bug findByBugId(int bugId);

    public List<Bug> findBugsByDeveloper(String developerUsername);

    public void save (Bug theBug);

    public void deleteById(int theId);

}
