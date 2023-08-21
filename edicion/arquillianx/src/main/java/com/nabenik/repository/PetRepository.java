package com.nabenik.repository;

import com.nabenik.model.Pet;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

/**
 * JPA repository for the Pet entity.
 */
@RequestScoped
@Transactional(Transactional.TxType.REQUIRES_NEW)
public class PetRepository {

    @Inject
    EntityManager entityManager;

    public void create(Pet pet) {
        entityManager.persist(pet);
    }

    public Pet findById(Long id) {
        return entityManager.find(Pet.class, id);
    }

    public void update(Pet pet) {
        entityManager.merge(pet);
    }

    public void delete(Pet pet) {
        entityManager.remove(pet);
    }

    public List<Pet> findAll() {
        return entityManager.createQuery("SELECT p FROM Pet p", Pet.class).getResultList();
    }

}
