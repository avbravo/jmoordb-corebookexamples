/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.capitulo20.repository;

import com.estacionesserver.model.Persona;
import com.jmoordb.core.annotation.repository.Count;
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
@Repository(database = "{mongodb.database}", entity = Persona.class)
//public interface MedicionRepository extends CrudRepository<Medicion, Long> {
public interface PersonaRepository extends CrudRepository<Persona, ObjectId> {

    @Lookup
    public List<Persona> lookup(Search search);

    @Count()
    public Long count(Search... search);
    
    
}
