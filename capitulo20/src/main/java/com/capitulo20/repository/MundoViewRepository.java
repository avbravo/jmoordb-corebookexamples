/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capitulo20.repository;

import com.capitulo20.model.Mundo;
import com.capitulo20.model.PersonaView;
import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.repository.CrudRepository;

/**
 *
 * @author avbravo
 */
@Repository(database = "{mongodb.database1}", entity = Mundo.class,collection = "mundo")
public interface MundoViewRepository extends CrudRepository<Mundo, Long> {

  
}
