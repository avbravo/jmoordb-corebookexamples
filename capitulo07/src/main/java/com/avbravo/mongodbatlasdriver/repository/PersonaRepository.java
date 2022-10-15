/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.repository;

import com.jmoordb.core.annotation.repository.Query;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.annotation.RepositoryMongoDB;
import com.avbravo.mongodbatlasdriver.model.Persona;
import com.jmoordb.core.annotation.enumerations.JakartaSource;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author avbravo
 */
@RepositoryMongoDB(entity = Persona.class,jakartaSource = JakartaSource.JAVAEE_LEGACY)
public interface PersonaRepository {
    @Query()
    public List<Persona> findAll();
    @Query(where= "idoais = :id")
    public Optional<Persona> findById(String id);
    @Query(where ="persona = :persona")
    public List<Persona> findByPersona(String persona);
    public Persona save(Persona persona);
    public void deleteById(String id);
}
