/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.repository;

import com.jmoordb.core.annotation.repository.Query;
import com.jmoordb.core.annotation.RepositoryMongoDB;
import com.avbravo.mongodbatlasdriver.model.Corregimiento;
import com.jmoordb.core.annotation.enumerations.JakartaSource;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author avbravo
 */
@RepositoryMongoDB(entity = Corregimiento.class,jakartaSource = JakartaSource.JAVAEE_LEGACY)
public interface CorregimientoRepository {
    @Query()
    public List<Corregimiento> findAll();
    @Query(where="idoais = :id")
    public Optional<Corregimiento> findById(String id);
    @Query(where="corregimiento = :corregimiento")
    public List<Corregimiento> findByCorregimiento(String corregimiento);
    public Corregimiento save(Corregimiento corregimiento);
    public Boolean deleteById(String id);
}
