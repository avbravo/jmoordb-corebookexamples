/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.repository;

import com.jmoordb.core.annotation.date.ExcludeTime;
import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.jmoordb.core.annotation.repository.Find;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.repository.CrudRepository;
import com.jmoordbcore.model.Pais;
import java.util.Date;
import java.util.List;

/**
 *
 * @author avbravo
 */
@Repository(entity = Pais.class)
public interface PaisRepository extends CrudRepository<Pais, Long> {    
      
    @Find
    public List<Pais> findByFechaGreaterThanEqualAndFechaLessThanEqualAndPais(@ExcludeTime Date start, @ExcludeTime Date end, String pais);

    
}
