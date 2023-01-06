/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jmoordbcore.capitulo23faces.repository;

import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.jmoordb.core.annotation.repository.Find;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.repository.CrudRepository;
import com.jmoordbcore.capitulo23faces.model.Grupo;
import java.util.List;

/**
 *
 * @author avbravo
 */
@Repository(entity = Grupo.class, jakartaSource = JakartaSource.JAKARTA)
public interface GrupoRepository extends CrudRepository<Grupo,String>{

}
