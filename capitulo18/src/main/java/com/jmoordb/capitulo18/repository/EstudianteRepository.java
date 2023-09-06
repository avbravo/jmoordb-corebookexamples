/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordb.capitulo18.repository;

import com.jmoordb.capitulo18.model.Estudiante;
import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.OrderBy;
import jakarta.data.repository.Repository;
import java.util.List;


/**
 *
 * @author avbravo
 */
@Repository
public interface EstudianteRepository extends CrudRepository<Estudiante, String>{
List<Estudiante> findByNombre(String nombre);

  @OrderBy("edad")
  List<Estudiante> findByNombreLike(String nombrePattern);

  
}
