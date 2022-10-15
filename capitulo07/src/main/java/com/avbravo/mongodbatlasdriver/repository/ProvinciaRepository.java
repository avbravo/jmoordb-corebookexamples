/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.repository;

import com.jmoordb.core.annotation.repository.Query;
import com.jmoordb.core.annotation.RepositoryMongoDB;
import com.avbravo.mongodbatlasdriver.model.Provincia;
import com.jmoordb.core.annotation.enumerations.JakartaSource;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author avbravo
 */
@RepositoryMongoDB(entity = Provincia.class, jakartaSource = JakartaSource.JAVAEE_LEGACY)
public interface ProvinciaRepository {
    @Query()
    public List<Provincia> findAll();
    @Query(where ="idoais = :id")
    public Optional<Provincia> findById(String id);
    @Query(where = "provincia = :provincia")
    public List<Provincia> findByProvincia(String provincia);
    public Provincia save(Provincia provincia);
    public void deleteById(String id);
}
