package com.jb.erebor.dao;

import com.jb.erebor.entity.Bug;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.List;

@Repository
public class BugDAOHibernateImpl implements BugDAO {

    private EntityManager entityManager;

    @Autowired
    public BugDAOHibernateImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }


    @Override
    public List<Bug> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Bug> theQuery = currentSession.createQuery("from Bug", Bug.class);

        List<Bug> bugs = theQuery.getResultList();

        return bugs;

    }

    @Override
    public Bug findById(int theId) {

        Session currentSession = entityManager.unwrap(Session.class);

        Bug theBug = currentSession.get(Bug.class, theId);

        return theBug;

    }

    @Override
    public void save(Bug theBug) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(theBug);


    }

    @Override
    public void deleteById(int theId) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery = currentSession.createQuery("delete from Bug where bugId=:theBugId");

        theQuery.setParameter("theBugId", theId);

        theQuery.executeUpdate();

    }
}
