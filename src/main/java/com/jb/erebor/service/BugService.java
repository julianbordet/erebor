package com.jb.erebor.service;

import com.jb.erebor.entity.Bug;

import java.util.List;

public interface BugService {

    public List<Bug> findAll();

    public Bug findById(int theId);

    public void save(Bug theBug);

    public void deleteById(int theId);

}
