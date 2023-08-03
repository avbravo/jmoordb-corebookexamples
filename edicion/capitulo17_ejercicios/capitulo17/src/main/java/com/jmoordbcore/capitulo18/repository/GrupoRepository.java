/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jmoordbcore.capitulo18.repository;

import com.jmoordb.core.annotation.repository.Find;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.repository.CrudRepository;
import com.jmoordbcore.capitulo18.model.Grupo;
import java.util.stream.Stream;

/**
 *
 * @author avbravo
 */
@Repository(entity = Grupo.class)
public interface GrupoRepository extends CrudRepository<Grupo, String> {

    @Find
    public Stream<Grupo> findByGrupo(String grupo);
}
