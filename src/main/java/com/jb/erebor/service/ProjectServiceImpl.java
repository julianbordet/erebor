package com.jb.erebor.service;

import com.jb.erebor.dao.ProjectDAO;
import com.jb.erebor.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

    private ProjectDAO projectDAO;

    @Autowired
    public ProjectServiceImpl(ProjectDAO theProjectDAO){
        projectDAO = theProjectDAO;
    }

    @Override
    public List<Project> findAll() {

        List<Project> projectList = projectDAO.findAll();

        return projectList;
    }

    @Override
    public Project findByProjectId(int projectId) {
        return projectDAO.findByProjectId(projectId);
    }

    @Override
    public List<Project> findProjectsByDeveloper(String developerUsername) {
        return null;
    }

    @Override
    @Transactional
    public void save(Project theProject) {

        projectDAO.save(theProject);

    }

    @Override
    @Transactional
    public void deleteById(int theId) {

        projectDAO.deleteById(theId);

    }
}
