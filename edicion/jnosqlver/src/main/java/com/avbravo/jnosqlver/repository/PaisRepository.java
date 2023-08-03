/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.avbravo.jnosqlver.repository;

import com.avbravo.jnosqlver.model.Pais;
import jakarta.data.repository.CrudRepository;
import jakarta.data.repository.Repository;
import java.util.List;


/**
 *
 * @author avbravo
 */
@Repository
public interface PaisRepository extends CrudRepository<Pais, Long>{
      List<Pais> findByPais(String pais);
}
