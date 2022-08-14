package com.jb.erebor.dao;

import com.jb.erebor.entity.Project;
import org.hibernate.Session;
import org.hibernate.TypeHelper;
import org.hibernate.query.Query;
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

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Project> theQuery = currentSession.createQuery("from Project", Project.class);

        List<Project> projectList = theQuery.getResultList();

        return projectList;
    }

    @Override
    public Project findByProjectId(int projectId) {

        Session currentSession = entityManager.unwrap(Session.class);

        Project theProject = currentSession.get(Project.class, projectId);

        return theProject;

    }

    @Override
    public List<Project> findProjectsByDeveloper(String developerUsername) {



        return null;
    }

    @Override
    public void save(Project theProject) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(theProject);

    }

    @Override
    public void deleteById(int theId) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery = currentSession.createQuery("delete from Project where projectId=:theId");

        theQuery.setParameter("theId", theId);

        theQuery.executeUpdate();

    }
}
