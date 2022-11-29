/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo13.repository;

import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.jmoordb.core.annotation.repository.Find;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.model.Pagination;
import com.jmoordb.core.model.Sorted;
import com.jmoordb.core.repository.CrudRepository;
import com.jmoordbcore.capitulo13.model.Persona;
import java.util.List;

/**
 *
 * @author avbravo
 */
@Repository(entity = Persona.class, jakartaSource = JakartaSource.JAKARTA)
public interface PersonaRepository extends CrudRepository<Persona, Long>{
    @Find
    public List<Persona> findByNombre(String nombre);
    
    @Find
    public List<Persona> findByIdpersonaGreaterThanPaginationSorted(Long idpais, Pagination pagination, Sorted sorted);
}
