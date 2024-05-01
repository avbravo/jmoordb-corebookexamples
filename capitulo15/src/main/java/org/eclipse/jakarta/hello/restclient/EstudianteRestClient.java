/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.eclipse.jakarta.hello.restclient;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import org.eclipse.jakarta.hello.model.Estudiante;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 *
 * @author avbravo
 */
/*
@RegisterRestClient(baseUri ="http://localhost:8080/api/estudiante" )
*/    
@RegisterRestClient()
@Path("/estudiante")
public interface EstudianteRestClient {

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Estudiante> findAll();

    @GET
    @Path("{idestudiante}")
    public Estudiante findByIdestudiante(@PathParam("idestudiante") String idestudiante);

    @POST
    public Response save(@RequestBody(content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Estudiante.class))) Estudiante estudiante);

    @PUT
    public Response update(@RequestBody(content = @Content(mediaType = "application/json", 
            schema = @Schema(implementation = Estudiante.class))) Estudiante estudiante);

    @DELETE
    @Path("{idestudiante}")
    public Response delete(@Parameter(required = true, example = "1",
            schema = @Schema(type = SchemaType.STRING))
            @PathParam("idestudiante") String idestudiante);

    @GET
    @Path("findbynombre")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Estudiante> findByNombre(@QueryParam("nombre") String nombre);

}
