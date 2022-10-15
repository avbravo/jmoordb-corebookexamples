/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.acme.repository;

import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.jmoordb.core.annotation.repository.CountBy;
import com.jmoordb.core.annotation.repository.Find;
import com.jmoordb.core.annotation.repository.Ping;
import com.jmoordb.core.annotation.repository.Query;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.repository.CrudRepository;
import java.util.List;
import java.util.Optional;
import org.acme.model.Persona;

/**
 *
 * @author avbravo
 */
@Repository(entity = Persona.class, jakartaSource = JakartaSource.JAVAEE_LEGACY)
public interface PersonaRepository extends CrudRepository<Persona, String>{
   
    @Find
    public Optional<Persona> findByNombre(String nombre);
    
    @Query(where ="nombre .eq. @nombre")
    public Optional<Persona> queryByNombre(String nombre);
    
    @CountBy
    public Long countByIdpersonaAndNombre(String idpersona, String nombre);
    
    @Ping
    public Boolean ping();
    
    @Find
    public List<Persona> findByIdpersonaAndNombreAndEdadAndSexo(String idpersona, String nombre, Integer edad, String sexo);
}
