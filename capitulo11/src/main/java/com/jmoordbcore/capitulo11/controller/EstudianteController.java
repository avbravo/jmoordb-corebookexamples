/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo11.controller;

import com.jmoordb.core.model.Pagination;
import com.jmoordbcore.capitulo11.model.Estudiante;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Collection;
import java.util.List;
import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.Histogram;
import org.eclipse.microprofile.metrics.Metadata;
import org.eclipse.microprofile.metrics.MetricRegistry;
import org.eclipse.microprofile.metrics.MetricType;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.Metric;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import com.jmoordbcore.capitulo11.repository.EstudianteRepository;
import org.eclipse.microprofile.metrics.annotation.Counted;

/**
 *
 * @author avbravo
 */
@Path("estudiante")
@Tag(name = "Información del estudiante", description = "End-point para entidad Estudiante")
public class EstudianteController {

    // <editor-fold defaultstate="collapsed" desc="Inject">
    @Inject
    EstudianteRepository estudianteRepository;

    @Inject
    @Metric(name = "counter")
    private Counter counter;

    @Inject
    @Metric(name = "idestudiantehistrograma", description = "Ejemplo de histograma.",
            displayName = "Histogra de idestudiante con paginación")
    private Histogram histogram;

    

    @Inject
    private MetricRegistry registry;

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="findAll">
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Timed(name = "estudiantesFindAll",
            description = "Monitorea el tiempo en que obtiene la lista de todos los estudiantes",
            unit = MetricUnits.MILLISECONDS, absolute = true)
    @Operation(summary = "Obtiene todos los estudiantes", description = "Retorna todos los estudiantes disponibles")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @APIResponse(responseCode = "200", description = "Los estudiantes")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    @APIResponse(description = "Los estudiantes", responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Collection.class, readOnly = true, description = "los estudiantes", required = true, name = "estudiantes")))
    public List<Estudiante> findAll() {

        return estudianteRepository.findAll();
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Estudiante findByIdestudiante">
    @GET
    @Path("{idestudiante}")
    @Operation(summary = "Busca un estudiante por el idestudiante", description = "Busqueda de estudiante por idestudiante")
    @APIResponse(responseCode = "200", description = "El estudiante")
    @APIResponse(responseCode = "404", description = "Cuando no existe el idestudiante")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    @APIResponse(description = "El estudiante", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Estudiante.class)))
    public Estudiante findByIdestudiante(
            @Parameter(description = "El idestudiante", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @PathParam("idestudiante") String idestudiante) {

        counter.inc();

        return estudianteRepository.findByPk(idestudiante).orElseThrow(
                () -> new WebApplicationException("No hay estudiante con idestudiante " + idestudiante, Response.Status.NOT_FOUND));

    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Response save">
    @POST
    @Counted(name = "estudianteSave",
            absolute = true,
            displayName = "contador de estudiantes guardados",
            description = "Monitorea cuantas veces el método es invocado")
    @Operation(summary = "Inserta un nuevo estudiante", description = "Inserta un nuevo estudiante")
    @APIResponse(responseCode = "201", description = "Cuanoo se crea un  estudiante")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    public Response save(
            @RequestBody(description = "Crea un nuevo estudiante.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Estudiante.class))) Estudiante estudiante) {

        return Response.status(Response.Status.CREATED).entity(estudianteRepository.save(estudiante)).build();
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Response update">

    @PUT
    @Operation(summary = "Inserta un nuevo estudiante", description = "Inserta un nuevo estudiante")
    @APIResponse(responseCode = "201", description = "Cuanoo se crea un  estudiante")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    public Response update(
            @RequestBody(description = "Crea un nuevo estudiante.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Estudiante.class))) Estudiante estudiante) {

        return Response.status(Response.Status.CREATED).entity(estudianteRepository.update(estudiante)).build();
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Response delete">
    @DELETE
    @Path("{idestudiante}")
    @Operation(summary = "Elimina un estudiante por  idestudiante", description = "Elimina un estudiante por su idestudiante")
    @APIResponse(responseCode = "200", description = "Cuando elimina el estudiante")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    public Response delete(
            @Parameter(description = "El elemento idestudiante", required = true, example = "1", schema = @Schema(type = SchemaType.STRING)) @PathParam("idestudiante") String idestudiante) {
        estudianteRepository.deleteByPk(idestudiante);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    // </editor-fold>
    
    
    
    
    @GET
    @Path("findbynombre")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
        @Counted(unit = MetricUnits.NONE,
            name = "findByNombre",
            absolute = true,
            displayName = "obtiene la cantidad de veces que se ejecuto",
            description = "Monitorea cuantas veces el método es invocado")
    public List<Estudiante> findByNombre(@QueryParam("nombre") String nombre) {
        return estudianteRepository.findByNombre(nombre);

    }
    
    
    
    


    @Gauge(name = "estudianteCountFindByIdestudiante", absolute = true, unit = MetricUnits.NONE)
    private long count() {
        return counter.getCount();
    }


// <editor-fold defaultstate="collapsed" desc="@Path("/histogram")">
    @Path("/histogram")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Histogram histogramaEstudiante(@QueryParam("nombre") String nombre, @QueryParam("pagina") Integer pagina, @QueryParam("registrosporpagina") Integer registrosporpagina) {

        Metadata metadata = Metadata.builder()
                .withName("idestudiantehistrograma")
                .withDisplayName("Idestudiante ")
                .withType(MetricType.HISTOGRAM)
                .withDescription("Histograma de idestudiante con paginación")
                .build();

        Pagination pagination = new Pagination(pagina, registrosporpagina);

        List<Estudiante> estudianteStream = estudianteRepository.findByNombre(nombre);
        Histogram metric = registry.histogram(metadata);

        estudianteStream.forEach(p -> {
            histogram.update(p.getEdad());
        });
        return histogram;
    }

// </editor-fold>
 
    
}
