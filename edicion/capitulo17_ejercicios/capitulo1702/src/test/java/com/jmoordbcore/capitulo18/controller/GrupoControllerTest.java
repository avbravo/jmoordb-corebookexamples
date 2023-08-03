/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.jmoordbcore.capitulo18.controller;

import com.jmoordbcore.capitulo18.model.Grupo;
import java.util.Collection;
import org.junit.jupiter.api.Test;
import org.microshed.testing.jaxrs.RESTClient;
import org.microshed.testing.jupiter.MicroShedTest;
import org.microshed.testing.testcontainers.ApplicationContainer;
import org.testcontainers.junit.jupiter.Container;
import static org.junit.jupiter.api.Assertions.assertTrue;
/**
 *
 * @author avbravo
 */

@MicroShedTest
public class GrupoControllerTest {
    
    
    @Container
    public static MicroProfileApplication app = new MicroProfileApplication();
        
    
     @Container
    public static ApplicationContainer app = new ApplicationContainer()
                    .withAppContextRoot("/capitulo18")
                    .withReadinessPath("/capitulo18/api/grupo");
     
     
     
 @RESTClient
    public static GrupoController grupoController;   
 
     @Test
    public void testGetAllPeople() {
      String grupo1Id = grupoController.createGrupo("grupo1", "Grupo 1");
        String grupo2Id = grupoController.createGrupo("grupo2", "Grupo 2");

        Grupo expected1 = new Grupo(grupo1Id,"Grupo 1" );
        Grupo expected2 = new Grupo(grupo2Id,"Grupo 1" );
        

        Collection<Grupo> allGrupo = grupoController.findAll();
        
        assertTrue(allGrupo.size() >= 2, "Expected at least 2 people to be registered, but there were only: " + allGrupo);
        assertTrue(allGrupo.contains(expected1), "Did not find grupo " + expected1 + " in all people: " + allGrupo);
        assertTrue(allGrupo.contains(expected2), "Did not find grupo " + expected2 + " in all people: " + allGrupo);
    }
}
