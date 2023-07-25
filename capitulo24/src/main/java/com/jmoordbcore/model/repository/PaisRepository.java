/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.model.repository;

import com.jmoordb.core.annotation.date.ExcludeTime;
import com.jmoordb.core.annotation.date.IncludeTime;
import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.jmoordb.core.annotation.repository.CountBy;
import com.jmoordb.core.annotation.repository.DeleteBy;
import com.jmoordb.core.annotation.repository.Find;
import com.jmoordb.core.annotation.repository.Ping;
import com.jmoordb.core.annotation.repository.Query;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.model.Pagination;
import com.jmoordb.core.repository.CrudRepository;
import com.jmoordbcore.model.Pais;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 *
 * @author avbravo
 */
@Repository(entity = Pais.class, jakartaSource = JakartaSource.JAVAEE_LEGACY)
public interface PaisRepository extends CrudRepository<Pais, Long> {
    
      
    @Find
    public List<Pais> findByFechaGreaterThanEqualAndFechaLessThanEqualAndPais(@ExcludeTime Date start, @ExcludeTime Date end, String pais);

    
}
