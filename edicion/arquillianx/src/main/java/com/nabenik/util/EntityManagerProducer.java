package com.nabenik.util;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceUnit;

@ApplicationScoped
public class EntityManagerProducer {

    @PersistenceUnit
    EntityManagerFactory emf;

    @PostConstruct
    public void init(){
        if(emf == null) {
            emf = Persistence.createEntityManagerFactory("default-pu");
        }
    }

    @Produces
    @Default
    public EntityManagerFactory createEntityManagerFactory() {
        return emf;
    }

    @Produces
    @Default
    @Dependent
    public EntityManager createEntityManager() {
        return this.emf.createEntityManager();
    }

    public void close(@Disposes EntityManager em) {
        if (em.isOpen()) {
            em.close();
        }
    }
}
