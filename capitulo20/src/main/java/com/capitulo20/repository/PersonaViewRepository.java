/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.capitulo20.repository;

import com.capitulo20.model.PersonaView;
import com.jmoordb.core.annotation.repository.Count;
import com.jmoordb.core.annotation.repository.Find;
import com.jmoordb.core.annotation.repository.Lookup;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.model.Search;
import com.jmoordb.core.repository.CrudRepository;
import java.util.List;
import org.bson.types.ObjectId;


/**
 *
 * @author avbravo
 */
@Repository(database = "{mongodb.database1}", entity = PersonaView.class,collection = "persona")
public interface PersonaViewRepository extends CrudRepository<PersonaView, ObjectId>{
    
      @Find
    public List<PersonaView> findByPersona(String proyecto);
       @Lookup
public List<PersonaView> lookup(Search search);
  @Count()
    public Long count(Search... search);
}
