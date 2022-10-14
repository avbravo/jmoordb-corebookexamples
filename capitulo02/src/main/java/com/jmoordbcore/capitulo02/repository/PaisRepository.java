/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo02.repository;

import com.jmoordb.core.annotation.date.ExcludeTime;
import com.jmoordb.core.annotation.date.IncludeTime;
import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.jmoordb.core.annotation.repository.CountBy;
import com.jmoordb.core.annotation.repository.DeleteBy;
import com.jmoordb.core.annotation.repository.Find;
import com.jmoordb.core.annotation.repository.Query;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.repository.CrudRepository;
import com.jmoordbcore.capitulo02.model.Pais;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author avbravo
 */
@Repository(entity = Pais.class, jakartaSource = JakartaSource.JAVAEE_LEGACY)
public interface PaisRepository extends CrudRepository<Pais, Long> {

    @Query(where = "fecha .eq. @fecha")
    public List<Pais> queryByFecha(@IncludeTime Date fecha);

    @Find
    public List<Pais> findByFecha(@IncludeTime Date fecha);

    @Find
    public List<Pais> findByFecha(@ExcludeTime LocalDateTime fecha);
    
    
    @Find
    public List<Pais> findByFechaGreaterThan(Date fecha);

    @Find
    public List<Pais> findByFechaGreaterThanEquals(@ExcludeTime Date fecha);

    @Find
    public List<Pais> findByFechaLessThan(@ExcludeTime Date fecha);

    @Find
    public List<Pais> findByFechaLessThanEquals(@ExcludeTime Date fecha);
    

    @Find
    public Optional<Pais> findByFechaAndPais(@ExcludeTime Date fecha, String pais);
    
    @Find    
    public List<Pais> findByFechaLessThanAndPais(@ExcludeTime Date fecha, String pais);

    @Find
    public List<Pais> findByPaisAndFechaLessThan(@ExcludeTime Date fecha, String pais);

    
////    
//    

    @Find
    public List<Pais> findByLocal(@ExcludeTime LocalDateTime local);
//    

    @CountBy
    public Long countByLocal(LocalDateTime local);

//    
    @Find
    public List<Pais> findByFechaGreaterThanAndFechaLessThan(@IncludeTime Date start, Date end);

    @Find
    public List<Pais> findByFechaGreaterThanEqualAndFechaLessThanEqual(@IncludeTime Date start, @ExcludeTime Date end);

    @Find
    public List<Pais> findByFechaGreaterThanEqualAndFechaLessThanEqualAndPais(@ExcludeTime Date start, @ExcludeTime Date end, String pais);

    @DeleteBy
    public Long deleteByFechaGreaterThan(Date fecha);

}
