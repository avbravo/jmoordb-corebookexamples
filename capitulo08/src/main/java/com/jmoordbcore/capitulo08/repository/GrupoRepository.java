/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jmoordbcore.capitulo08.repository;

import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.repository.CrudRepository;
import com.jmoordbcore.capitulo08.model.Grupo;

/**
 *
 * @author avbravo
 */
@Repository(entity = Grupo.class, jakartaSource = JakartaSource.JAKARTA)
public interface GrupoRepository extends CrudRepository<Grupo,String>{
    
}
