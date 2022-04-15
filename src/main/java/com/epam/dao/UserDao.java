package com.epam.dao;

import com.epam.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class UserDao implements JpaDao<User> {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-local-mysql");


    @Override
    public void create(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        
    }

    @Override
    public void update(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public User get(String id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User user=entityManager.find(User.class,id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return user;
    }

    @Override
    public void delete(String id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User user=entityManager.find(User.class,id);
        entityManager.remove(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
