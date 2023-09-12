/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.capitulo01.repository;

import com.capitulo01.model.Persona;
import java.util.List;

/**
 *
 * @author avbravo
 */
public interface PersonaRepository {
    List<Persona> findAll();
}
