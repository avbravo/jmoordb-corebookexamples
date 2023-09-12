/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capitulo01.repository;

import com.capitulo01.model.Persona;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class PersonaRepositoryImpl implements PersonaRepository{

    @Override
    public List<Persona> findAll() {
       List<Persona> result = Arrays.asList(new Persona("7", "Aristides"), new Persona("8", "Maria"));
       return result;
    }
    
}
