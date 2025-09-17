/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.avbravo.capitulo23;

import com.avbravo.capitulo23.clases.*;
import com.avbravo.capitulo23.clases.Deporte;
import com.avbravo.capitulo23.clases.People;
import com.avbravo.capitulo23.records.Celular;
import com.avbravo.capitulo23.records.CelularBuilder;
import com.avbravo.capitulo23.records.CelularViewModel;
import com.avbravo.capitulo23.records.CelularViewModelBuilder;

/**
 *
 * @author avbravo
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Car car = new CarBuilder()
                .withName("Toyota")
                .build();

        People p = new PeopleBuilder()
                .withId(3L)
                .withName("Aristides")
                .build();

        Deporte d = new DeporteBuilder()
                .setIddeporte(6L)
                .build();

        // Builder
        Celular celular = new CelularBuilder()
                .id(7L)
                .name("Aristides")
                .build();

        /**
         * ViewModel Mediante atributos
         */
        CelularViewModel celularAttributes = new CelularViewModel();
        celularAttributes.setId(4L);
        celularAttributes.setName("Ana");

        // View Model usando Builder
        CelularViewModel cel2 = new CelularViewModelBuilder()
                .withId(4L)
                .withName("Dayana")
                .build();

        //ViewModel to Record de los datos creados 
        Celular c = celularAttributes.toRecord();
        System.out.println("ViewModel a Record" + c.toString());

        //ViewModel to Record pasando el Viewmodel
        Celular c2 = celularAttributes.toRecord(new CelularViewModel(8L, "Dianna"));
        System.out.println("ViewModel to Record how parameter " + c2.toString());

        // Record a ViewModel
        // Convierte un record a ViewModel
        CelularViewModel cvm = celularAttributes.toViewModel(new Celular(2L, "Maria"));

        System.out.println("Record to ViewModel " + cvm.toString());
        //  fALTA UN BUILDER APLICADO A ViewModel generado
        //       View Model debe llevar validaciones

    }
}
