/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.repository;

import com.jmoordb.core.annotation.repository.Query;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.annotation.RepositoryMongoDB;
import com.avbravo.mongodbatlasdriver.model.Pais;
import com.jmoordb.core.annotation.enumerations.JakartaSource;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author avbravo
 */
@RepositoryMongoDB(entity = Pais.class, jakartaSource = JakartaSource.JAVAEE_LEGACY)
public interface PaisRepository {
    @Query()
    public List<Pais> findAll();
    @Query(where = "idoais = :id")
    public Optional<Pais> findById(String id);
    @Query(where = "pais = :pais")
    public List<Pais> findByPais(String pais);
    public Pais save(Pais pais);
    public void deleteById(String id);
}
