/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.repository;

import com.avbravo.mongodbatlasdriver.model.Oceano;
import com.jmoordb.core.annotation.repository.Query;
import com.jmoordb.core.annotation.RepositoryMongoDB;
import com.avbravo.mongodbatlasdriver.model.Profesion;
import com.jmoordb.core.annotation.enumerations.JakartaSource;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author avbravo
 */
@RepositoryMongoDB(entity = Profesion.class, jakartaSource = JakartaSource.JAVAEE_LEGACY)
public interface ProfesionRepository {
    @Query()
    public List<Profesion> findAll();
    @Query(where ="idoais = :id")
    public Optional<Profesion> findById(String id);
    @Query(where = "profesion = :profesion")
    public List<Profesion> findByProfesion(String profesion);
   public Optional<Profesion> save(Profesion profesion);
    
    public Boolean saveProfesion(Profesion profesion);
    public Boolean deleteById(String id);
}
