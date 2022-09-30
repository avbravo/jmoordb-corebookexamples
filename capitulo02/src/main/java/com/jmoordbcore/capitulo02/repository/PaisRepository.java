/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo02.repository;

import com.jmoordb.core.annotation.date.ExcludeTime;
import com.jmoordb.core.annotation.date.IncludeTime;
import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.jmoordb.core.annotation.repository.CountBy;
import com.jmoordb.core.annotation.repository.Find;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.repository.CrudRepository;
import com.jmoordbcore.capitulo02.model.Pais;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 *
 * @author avbravo
 */
@Repository(entity = Pais.class, jakartaSource = JakartaSource.JAVAEE_LEGACY)
public interface PaisRepository extends CrudRepository<Pais, Long>{     
    @Find
    public List<Pais> findByFechaGreaterThan(Date fecha);
    
    @Find
    public List<Pais> findByFecha(@IncludeTime Date fecha);    
    @Find
    public List<Pais> findByLocal(@ExcludeTime LocalDateTime local);
    
    @CountBy
    public Long countByLocal(LocalDateTime local);
    
    @Find
    public List<Pais> findByFechaGreaterThanAndFechaLessThan(@IncludeTime Date start, Date end);

    @Find
    public List<Pais> findByFechaGreaterThanEqualAndFechaLessThanEqual(Date start, Date end);
   
//    public List<Pais> findByFechaGreaterExcludeHourThanEqualAndFechaLessExcludeHourThanEqual(Date start, Date end);
//    
//    public List<Pais> findByFechaGreaterIncludeHourThanEqualAndFechaLessIncludeHourThanEqual(Date start, Date end);
//    
    
    

    
    
    
}
