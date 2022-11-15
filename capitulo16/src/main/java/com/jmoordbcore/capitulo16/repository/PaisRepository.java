/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jmoordbcore.capitulo16.repository;

import com.jmoordb.core.annotation.repository.Find;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.repository.CrudRepository;
import com.jmoordbcore.capitulo16.model.Pais;
import java.util.List;

/**
 *
 * @author avbravo
 */
@Repository(entity = Pais.class)
public interface PaisRepository extends CrudRepository<Pais, Long> {
    
    @Find
    public List<Pais> findByPais(String pais);
}
