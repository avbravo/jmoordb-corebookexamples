package com.capitulo01.resources;

import com.capitulo01.model.Persona;
import com.capitulo01.repository.PersonaRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

/**
 *
 * @author
 */
@Path("persona")
public class JakartaEE10Resource {

    @Inject
    PersonaRepository personaRepository;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Persona> findAll() {
       return personaRepository.findAll();
    }
}
