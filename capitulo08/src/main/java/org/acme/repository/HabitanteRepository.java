/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.acme.repository;

import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.repository.CrudRepository;
import org.acme.model.Habitante;

/**
 *
 * @author avbravo
 */
@Repository(entity = Habitante.class, jakartaSource = JakartaSource.JAVAEE_LEGACY)
public interface HabitanteRepository extends CrudRepository<Habitante,String>{
  
}
