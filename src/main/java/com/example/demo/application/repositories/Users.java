package com.example.demo.application.repositories;

import java.util.List;
import com.example.demo.application.entities.Charity;
import com.example.demo.application.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class Users {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(User user) {
        try {
            sessionFactory.getCurrentSession().save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> getUsers() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> query=currentSession.createQuery("from users", User.class);
        List<User> list=query.getResultList();
        return list;
    }

    public void deleteUser(User user) {
        try {
            sessionFactory.getCurrentSession().delete(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editUser(User user) {
        try {
            sessionFactory.getCurrentSession().update(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}