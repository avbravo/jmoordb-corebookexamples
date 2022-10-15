/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.repository;

import com.jmoordb.core.annotation.repository.Query;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.annotation.RepositoryMongoDB;
import com.avbravo.mongodbatlasdriver.model.Planeta;
import com.jmoordb.core.annotation.enumerations.JakartaSource;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author avbravo
 */
@RepositoryMongoDB(entity = Planeta.class,jakartaSource = JakartaSource.JAVAEE_LEGACY)
public interface PlanetaRepository {            
    @Query()
    public List<Planeta> findAll();    
    @Query(where = "idplaneta = :id")
    public Optional<Planeta> findById(String id);    
    @Query(where="planeta = :planeta")
    public List<Planeta> findByPlaneta(String planeta);
    public Planeta save(Planeta planeta);
    public void deleteById(String id);
}
