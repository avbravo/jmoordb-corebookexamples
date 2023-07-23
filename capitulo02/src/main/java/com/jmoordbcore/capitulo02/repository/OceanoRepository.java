/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jmoordbcore.capitulo02.repository;

import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.repository.CrudRepository;
import com.jmoordbcore.capitulo02.model.Oceano;
 
/**
 *
 * @author avbravo
 */
@Repository(entity = Oceano.class,jakartaSource = JakartaSource.JAKARTA)
public interface OceanoRepository extends CrudRepository<Oceano, String> {
    
}
