package com.epam.dao;

import com.epam.entity.Admin;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class AdminDao implements AdminJpaDao<Admin>{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-local-mysql");


    @Override
    public Admin get(String id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Admin admin=entityManager.find(Admin.class,id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return admin;
    }


}
