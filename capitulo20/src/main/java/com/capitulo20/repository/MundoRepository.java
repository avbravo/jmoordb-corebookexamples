/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capitulo20.repository;

import com.capitulo20.model.MundoView;
import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.repository.CrudRepository;

/**
 *
 * @author avbravo
 */
@Repository(entity = MundoView.class, jakartaSource = JakartaSource.JAKARTA)
public interface MundoRepository extends CrudRepository<MundoView, Long> {

  
}
