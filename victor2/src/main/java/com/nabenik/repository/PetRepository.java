/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nabenik.repository;

import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.repository.CrudRepository;
import com.nabenik.model.Pet;

/**
 *
 * @author avbravo
 */
//@RequestScoped
@Repository(entity = Pet.class)
public interface PetRepository extends CrudRepository<Pet, Long> {
    
}
