/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.repository;

import com.avbravo.mongodbatlasdriver.model.Oceano;
import com.jmoordb.core.annotation.date.IncludeTime;
import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.jmoordb.core.annotation.repository.Find;
import com.jmoordb.core.annotation.repository.Query;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.repository.CrudRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
 
/**
 *
 * @author avbravo
 */
@Repository(entity = Oceano.class,jakartaSource = JakartaSource.JAKARTA)
public interface OceanoRepository extends CrudRepository<Oceano, String> {
    
    @Find
    public Optional<Oceano> findByIdoceano(String idoceano);
    
    @Find()
public List<Oceano> findByIdOceanoAndOceanoNotFecha(String idoceano, String oceano, Date fecha);

@Query(where = "idoceano .eq. @idoceano .and. oceano .eq. @oceano .not. fecha .gt. @fecha")
public List<Oceano> queryByIdOceanoAndOceanoNotFecha(String idoceano, String oceano, @IncludeTime Date fecha);
}
