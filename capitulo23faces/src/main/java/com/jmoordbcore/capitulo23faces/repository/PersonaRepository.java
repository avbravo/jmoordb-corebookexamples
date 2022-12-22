/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo23faces.repository;

import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.jmoordb.core.annotation.repository.Count;
import com.jmoordb.core.annotation.repository.CountBy;
import com.jmoordb.core.annotation.repository.Find;
import com.jmoordb.core.annotation.repository.Lookup;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.model.Pagination;
import com.jmoordb.core.model.Search;
import com.jmoordb.core.model.Sorted;
import com.jmoordb.core.repository.CrudRepository;
import com.jmoordbcore.capitulo23faces.model.Persona;
import java.util.List;

/**
 *
 * @author avbravo
 */
@Repository(entity = Persona.class, jakartaSource = JakartaSource.JAKARTA)
public interface PersonaRepository extends CrudRepository<Persona, Long> {


    @Find
    public List<Persona> findByNombre(String nombre);

    @Find
    public List<Persona> findByNombrePagination(String nombre, Pagination pagination);
    
    @Find
    public List<Persona> findByNombrePaginationSorted(String nombre, Pagination pagination, Sorted sorted);

    /*
    Para consultas complejas
    */
    @Lookup
    public List<Persona> lookup(Search search);

    @Find
    public List<Persona> findByIdpersonaGreaterThanPaginationSorted(Long idpais, Pagination pagination, Sorted sorted);
    
    
 
    @Count
    Long count(Search... search);

    @CountBy
    public Long countByNombre(String nombre);
}
