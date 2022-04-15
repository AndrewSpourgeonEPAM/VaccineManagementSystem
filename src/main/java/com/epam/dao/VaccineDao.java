package com.epam.dao;

import com.epam.entity.Vaccine;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

@Repository
public class VaccineDao implements VaccineJpaDao<Vaccine>{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-local-mysql");


    @Override
    public List getLocations(){
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        Query query=entityManager.createQuery("select vaccine.location from Vaccine vaccine");
        return  query.getResultList();
    }
    @Override
    public Vaccine get(String id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Vaccine vaccine=entityManager.find(Vaccine.class,id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return vaccine;
    }

    @Override
    public void update(Vaccine vaccine){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(vaccine);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    @Override
    public List getVaccineData(){
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        Query query=entityManager.createQuery("select vaccine from Vaccine vaccine");
        return  query.getResultList();
    }


}
