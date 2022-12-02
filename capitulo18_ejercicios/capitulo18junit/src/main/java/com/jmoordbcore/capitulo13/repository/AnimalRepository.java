/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jmoordbcore.capitulo13.repository;

import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.repository.CrudRepository;
import com.jmoordbcore.capitulo13.model.Animal;

/**
 *
 * @author avbravo
 */
@Repository(entity =Animal.class,jakartaSource = JakartaSource.JAKARTA) 
public interface AnimalRepository extends CrudRepository<Animal,Long>{
    
}
