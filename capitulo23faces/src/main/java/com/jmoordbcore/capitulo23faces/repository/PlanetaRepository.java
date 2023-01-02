/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jmoordbcore.capitulo23faces.repository;

import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.jmoordb.core.annotation.repository.Find;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.repository.CrudRepository;
import com.jmoordbcore.capitulo23faces.model.Planeta;
import java.util.Optional;
 
/**
 *
 * @author avbravo
 */
@Repository(entity = Planeta.class,jakartaSource = JakartaSource.JAKARTA)
public interface PlanetaRepository extends CrudRepository<Planeta, String> {
    
    @Find
    public Optional<Planeta> findByIdplaneta(String idplaneta);
}
