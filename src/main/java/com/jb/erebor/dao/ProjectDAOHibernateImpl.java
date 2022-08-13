package com.jb.erebor.dao;

import com.jb.erebor.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProjectDAOHibernateImpl implements ProjectDAO{

    private EntityManager entityManager;

    @Autowired
    public ProjectDAOHibernateImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Project> findAll() {
        return null;
    }

    @Override
    public Project findByProjectId(int projectId) {
        return null;
    }

    @Override
    public List<Project> findProjectsByDeveloper(String developerUsername) {
        return null;
    }

    @Override
    public void save(Project theProject) {

    }

    @Override
    public void deleteById(int theId) {

    }
}
