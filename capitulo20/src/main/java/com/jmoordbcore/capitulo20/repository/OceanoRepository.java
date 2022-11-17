/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jmoordbcore.capitulo20.repository;

import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.repository.CrudRepository;
import com.jmoordbcore.capitulo20.model.Oceano;

/**
 *
 * @author avbravo
 */
@Repository(entity = Oceano.class)
public interface OceanoRepository extends CrudRepository<Oceano, String> {
    
    
}
