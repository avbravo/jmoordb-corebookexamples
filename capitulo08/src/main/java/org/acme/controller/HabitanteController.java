/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.acme.controller;

import com.jmoordb.core.util.JmoordbCoreUtil;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.acme.model.Habitante;
import org.acme.model.Pais;
import org.acme.repository.HabitanteRepository;
import org.acme.repository.PaisRepository;

/**
 *
 * @author avbravo
 */
@Path("habitante")
public class HabitanteController {
    @Inject
    HabitanteRepository habitanteRepository;
    
    @Inject
    PaisRepository paisRepository;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Habitante> findAll(){
     //  Habitante ha = habitanteRepository.findAll().get(0);
//       ha.setIdhabitante("2-");
//       habitanteRepository.save(ha);
//       Pais pais = ha.getPais();
//       pais.setIdpais(JmoordbCoreUtil.integerToLong(4));
//       System.out.println("Pais == "+pais.toString());
//       paisRepository.save(pais);
       return habitanteRepository.findAll();
    }
}
