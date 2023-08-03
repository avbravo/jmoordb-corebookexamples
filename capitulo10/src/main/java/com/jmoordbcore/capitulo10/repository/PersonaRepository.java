/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jmoordbcore.capitulo10.repository;

import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.repository.CrudRepository;
import com.jmoordbcore.capitulo10.model.Persona;

/**
 *
 * @author avbravo
 */
@Repository(entity=Persona.class)
public interface PersonaRepository extends CrudRepository<Persona, String>{
    
}
