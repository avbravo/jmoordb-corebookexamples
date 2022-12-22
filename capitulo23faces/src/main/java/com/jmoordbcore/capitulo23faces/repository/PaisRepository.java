/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo23faces.repository;

import com.jmoordb.core.annotation.date.ExcludeTime;
import com.jmoordb.core.annotation.date.IncludeTime;
import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.jmoordb.core.annotation.repository.Count;
import com.jmoordb.core.annotation.repository.CountBy;
import com.jmoordb.core.annotation.repository.DeleteBy;
import com.jmoordb.core.annotation.repository.Find;
import com.jmoordb.core.annotation.repository.Ping;
import com.jmoordb.core.annotation.repository.Query;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.model.Pagination;
import com.jmoordb.core.model.Search;
import com.jmoordb.core.repository.CrudRepository;
import com.jmoordbcore.capitulo23faces.model.Pais;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author avbravo
 */
@Repository(entity = Pais.class, jakartaSource = JakartaSource.JAKARTA)
public interface PaisRepository extends CrudRepository<Pais, Long> {

    @Find
    public List<Pais> findByPaisPagination(String pais, Pagination pagination);
    
      @Count
    Long count(Search... search);

    @CountBy
    public Long countByPais(String pais);
    
    
    
    @Query(where = "fecha .eq. @fecha")
    public List<Pais> queryByFecha(@IncludeTime Date fecha);

    @Find
    public List<Pais> findByIdpaisGreaterThanPagination(Long idpais, Pagination pagination);

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

    @Find
    public List<Pais> findByFechaGreaterThanEqualsAndFechaLessThanEquals(@IncludeTime Date start, Date end);

    @Find
    public List<Pais> findByFechaGreaterThanEqualAndFechaLessThanEqual(@ExcludeTime Date start, @ExcludeTime Date end);

    @Find
    public List<Pais> findByFechaGreaterThanEqualAndFechaLessThanEqualAndPais(@ExcludeTime Date start, @ExcludeTime Date end, String pais);

    @DeleteBy
    public Long deleteByFechaGreaterThan(Date fecha);

    @Ping
    public Boolean ping();
}
