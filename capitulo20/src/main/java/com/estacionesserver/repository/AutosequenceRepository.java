/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.estacionesserver.repository;

import com.jmoordb.core.annotation.date.ExcludeTime;
import com.jmoordb.core.annotation.repository.Count;
import com.jmoordb.core.annotation.repository.Find;
import com.jmoordb.core.annotation.repository.Lookup;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.model.Autosequence;
import com.jmoordb.core.model.Search;
import com.jmoordb.core.repository.CrudRepository;
import java.util.Date;
import java.util.List;

/**
 *
 * @author avbravo
 */
@Repository(database = "{mongodb.jmoordb}", entity = Autosequence.class)
public interface AutosequenceRepository extends CrudRepository<Autosequence, Long> {

      
    @Find
    public List<Autosequence> findByFechaGreaterThanEqualAndFechaLessThanEqual(@ExcludeTime Date start, @ExcludeTime Date end);

    @Find
    public List<Autosequence> findByAutosequence(String proyecto);

    @Lookup
    public List<Autosequence> lookup(Search search);

    @Count()
    public Long count(Search... search);
    
  
}
