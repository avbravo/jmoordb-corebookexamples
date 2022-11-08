/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.repository;

import com.avbravo.mongodbatlasdriver.model.Planeta;
import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.repository.CrudRepository;
 
/**
 *
 * @author avbravo
 */
@Repository(entity = Planeta.class,jakartaSource = JakartaSource.JAKARTA)
public interface PlanetaRepository extends CrudRepository<Planeta, Long> {
    

}
