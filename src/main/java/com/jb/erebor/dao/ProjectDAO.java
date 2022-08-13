package com.jb.erebor.dao;


import com.jb.erebor.entity.Bug;
import com.jb.erebor.entity.BugTransaction;
import com.jb.erebor.entity.Project;

import java.util.List;

public interface ProjectDAO {

    public List<Project> findAll();

    public Project findByProjectId(int projectId);

    public List<Project> findProjectsByDeveloper(String developerUsername);

    public void save (Project theProject);

    public void deleteById(int theId);
}
