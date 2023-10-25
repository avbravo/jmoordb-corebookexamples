/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jmoordbcore.capitulo16.repository;

import com.jmoordb.core.annotation.autosecuence.Autogenerated;
import com.jmoordb.core.annotation.autosecuence.AutosecuenceRepository;
import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.jmoordb.core.model.Autosequence;

/**
 *
 * @author avbravo
 */

@AutosecuenceRepository(entity = Autosequence.class, jakartaSource = JakartaSource.JAKARTA)
public interface AutogeneratedRepository {

    @Autogenerated()
    public Long generate(String database, String collection);

}