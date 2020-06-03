package com.example.demo.application.repositories;

import java.util.List;
import com.example.demo.application.entities.Charity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CharityRepository{

    @Autowired
    private SessionFactory sessionFactory;

    public boolean save(Charity charity) {
        boolean status=false;
        try {
            sessionFactory.getCurrentSession().save(charity);
            status=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public List<Charity> getCharities() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Charity> query=currentSession.createQuery("Select* from charities", Charity.class);
        List<Charity> list=query.getResultList();
        return list;
    }

    public void deleteCharity(Charity charity) {
        try {
            sessionFactory.getCurrentSession().delete(charity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Charity> getCharityByName(String name) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Charity> query=currentSession.createQuery("Select* from charities where name=:name", Charity.class);
        //query.setParameter("name", query.getName());
        List<Charity> list=query.getResultList();
        return list;
    }

    public void editCharity(Charity charity) {
        try {
            sessionFactory.getCurrentSession().update(charity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}