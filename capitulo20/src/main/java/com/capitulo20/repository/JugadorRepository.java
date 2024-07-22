/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.capitulo20.repository;

import com.capitulo20.model.Jugador;
import com.jmoordb.core.annotation.repository.Count;
import com.jmoordb.core.annotation.repository.Lookup;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.annotation.repository.Save;
import com.jmoordb.core.model.Search;
import com.jmoordb.core.repository.CrudRepository;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author avbravo
 */
@Repository(database = "{mongodb.database}", entity = Jugador.class)
public interface JugadorRepository extends CrudRepository<Jugador, Long> {

    @Lookup
    public List<Jugador> lookup(Search search);

    @Count()
    public Long count(Search... search);
    
  
    
    
}
