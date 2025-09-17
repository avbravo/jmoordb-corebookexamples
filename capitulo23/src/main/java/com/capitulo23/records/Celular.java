/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capitulo23.records;

import com.jmoordb.core.annotation.ViewModel;
import com.jmoordb.core.annotation.builder.CoreBuilder;
import com.jmoordb.core.annotation.builder.ViewModelBuilder;

/**
 *
 * @author avbravo
 */
@CoreBuilder
@ViewModel
@ViewModelBuilder
public record Celular(Long id, String name) {
    
    
}
