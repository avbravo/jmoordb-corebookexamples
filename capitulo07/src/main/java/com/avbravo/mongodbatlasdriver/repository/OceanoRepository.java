/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.repository;

import com.avbravo.mongodbatlasdriver.model.Oceano;
import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.jmoordb.core.annotation.repository.Find;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.repository.CrudRepository;
import java.util.Optional;
 
/**
 *
 * @author avbravo
 */
@Repository(entity = Oceano.class,jakartaSource = JakartaSource.JAKARTA)
public interface OceanoRepository extends CrudRepository<Oceano, String> {
    
    @Find
    public Optional<Oceano> findByIdoceano(String idoceano);
}
