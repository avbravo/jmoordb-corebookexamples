/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.repository;

import com.jmoordb.core.annotation.repository.Query;
import com.jmoordb.core.annotation.RepositoryMongoDB;
import com.avbravo.mongodbatlasdriver.model.Grupoprofesion;
import com.jmoordb.core.annotation.enumerations.JakartaSource;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author avbravo
 */
@RepositoryMongoDB(entity = Grupoprofesion.class,jakartaSource = JakartaSource.JAVAEE_LEGACY)
public interface GrupoprofesionRepository {            
    @Query()
    public List<Grupoprofesion> findAll();    
    @Query(where="idgrupoprofesion = :id")
    public Optional<Grupoprofesion> findById(String id);    
    @Query(where="grupoprofesion = :grupoprofesion")
    public List<Grupoprofesion> findByGrupoprofesion(String grupoprofesion);
    public Grupoprofesion save(Grupoprofesion grupoprofesion);
    public void deleteById(String id);
}
