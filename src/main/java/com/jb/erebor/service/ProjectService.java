package com.jb.erebor.service;

import com.jb.erebor.entity.Project;

import java.util.List;

public interface ProjectService {

    public List<Project> findAll();

    public Project findByProjectId(int projectId);

    public List<Project> findProjectsByDeveloper(String developerUsername);

    public void save (Project theProject);

    public void deleteById(int theId);

}
