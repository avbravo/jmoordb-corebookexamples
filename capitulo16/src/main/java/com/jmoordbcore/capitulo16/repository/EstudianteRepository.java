/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jmoordbcore.capitulo16.repository;

import com.jmoordb.core.annotation.repository.Find;
import com.jmoordb.core.annotation.repository.Ping;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.model.Pagination;
import com.jmoordb.core.repository.CrudRepository;
import com.jmoordbcore.capitulo16.model.Estudiante;
import java.util.List;

/**
 *
 * @author avbravo
 */
@Repository(entity=Estudiante.class)
public interface EstudianteRepository extends CrudRepository<Estudiante, String>{
      @Ping
    public Boolean ping();
    @Find
    public List<Estudiante> findByNombre(String nombre);
    @Find
    public List<Estudiante> findByEdadGreaterThanPagination(Integer edad, Pagination pagination);
}
