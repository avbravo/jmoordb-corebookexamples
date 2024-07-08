/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capitulo19.controller;

import com.capitulo19.repository.EmpresaRepository;
import com.jmoordb.core.model.Search;
import com.jmoordb.core.util.DocumentUtil;
import com.jmoordb.core.util.MessagesUtil;
import com.jmoordb.core.annotation.date.DateFormat;
import com.jmoordb.core.util.JmoordbCoreDateUtil;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import com.capitulo19.model.Venta;
import com.capitulo19.repository.VentaRepository;

/**
 *
 * @author avbravo
 */
@Path("venta")
@RequestScoped
public class VentaController implements Serializable {

    private String nameOfCollection = "venta_";
    // <editor-fold defaultstate="collapsed" desc="Inject">
    @Inject
    VentaRepository ventaRepository;
    @Inject
    EmpresaRepository empresaRepository;

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Venta findByIdventaIdproyecto(@QueryParam("idventa") Long idventa,       @QueryParam("anio") Long anio  ) ">
    @GET
    @RolesAllowed({"admin"})
    @Path("idventaanio")
    
    public Venta findByIdventa(@QueryParam("idventa") Long idventa, @QueryParam("anio") Long anio) {

        ventaRepository.setDynamicCollection(nameOfCollection + anio);
        return ventaRepository.findByPk(idventa).orElseThrow(
                () -> new WebApplicationException("No hay venta con idventa " + idventa, Response.Status.NOT_FOUND));

    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Response save">
    @POST
    public Response save(
            @RequestBody(description = "Crea un nuevo venta.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Venta.class))) Venta venta) {

        Boolean conIsoDate = Boolean.TRUE;
        if (conIsoDate) {

            Date dateconverter = JmoordbCoreDateUtil.dateToiSODateToDate(venta.getFechaHora());

            ventaRepository.setDynamicDatabase("lecturas_" + JmoordbCoreDateUtil.anioDeUnaFecha(dateconverter).toString().trim() + "db");
            Integer numeroMes = JmoordbCoreDateUtil.mesDeUnaFechaStartEneroWith0(dateconverter);
            ventaRepository.setDynamicCollection(nameOfCollection + venta.getIdempresa().toString().trim() + "_" + JmoordbCoreDateUtil.getNombreMes(numeroMes).toLowerCase());

        } else {

            ventaRepository.setDynamicDatabase("lecturas_" + JmoordbCoreDateUtil.anioDeUnaFecha(venta.getFechaHora()).toString().trim() + "db");
            Integer numeroMes = JmoordbCoreDateUtil.mesDeUnaFechaStartEneroWith0(venta.getFechaHora());
            ventaRepository.setDynamicCollection(nameOfCollection + venta.getIdempresa().toString().trim() + "_" + JmoordbCoreDateUtil.getNombreMes(numeroMes).toLowerCase());

        }

        Optional<Venta> ventaOptional = ventaRepository.save(venta);
        if (ventaOptional.isPresent()) {

            return Response.status(201).entity(ventaOptional.get()).build();
        } else {
            return Response.status(400).entity("Error " + ventaRepository.getJmoordbException().getLocalizedMessage()).build();
        }

    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Response update">
    @PUT
    public Response update(
            @RequestBody(description = "Crea un nuevo venta.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Venta.class))) Venta venta) {
        Boolean conIsoDate = Boolean.TRUE;
        if (conIsoDate) {
            Date dateconverter = JmoordbCoreDateUtil.dateToiSODateToDate(venta.getFechaHora());

            ventaRepository.setDynamicDatabase("lecturas_" + JmoordbCoreDateUtil.anioDeUnaFecha(dateconverter).toString().trim() + "db");
            Integer numeroMes = JmoordbCoreDateUtil.mesDeUnaFechaStartEneroWith0(dateconverter);
            ventaRepository.setDynamicCollection(nameOfCollection + venta.getIdempresa().toString().trim() + "_" + JmoordbCoreDateUtil.getNombreMes(numeroMes).toLowerCase());

        } else {

            ventaRepository.setDynamicDatabase("lecturas_" + JmoordbCoreDateUtil.anioDeUnaFecha(venta.getFechaHora()).toString().trim() + "db");
            Integer numeroMes = JmoordbCoreDateUtil.mesDeUnaFechaStartEneroWith0(venta.getFechaHora());
            ventaRepository.setDynamicCollection(nameOfCollection + venta.getIdempresa().toString().trim() + "_" + JmoordbCoreDateUtil.getNombreMes(numeroMes).toLowerCase());

        }

        if (ventaRepository.update(venta)) {

            return Response.status(201).entity(venta).build();
        } else {
            System.out.println("\t>>>>>>>> [error]" + MessagesUtil.nameOfClassAndMethod());
            System.out.println("\t>>>>>>>> [error]" + MessagesUtil.nameOfClassAndMethod() + " [error] " + ventaRepository.getJmoordbException().getLocalizedMessage());
            return Response.status(400).entity("Error " + ventaRepository.getJmoordbException().getLocalizedMessage()).build();
        }
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Response delete(@QueryParam("idventa") Long idventa, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes) ">
    @DELETE
    @Path("idventaanio")
    public Response delete(@QueryParam("idventa") Long idventa, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes) {

        ventaRepository.setDynamicDatabase("lecturas_" + anio.toString().trim() + "db");
        Integer numeroMes = mes;
        ventaRepository.setDynamicCollection(nameOfCollection + idventa.toString().trim() + "_" + JmoordbCoreDateUtil.getNombreMes(numeroMes).toLowerCase());

        if (ventaRepository.deleteByPk(idventa) == 0L) {
            return Response.status(201).entity(Boolean.TRUE).build();
        } else {
            return Response.status(400).entity("Error " + ventaRepository.getJmoordbException().getLocalizedMessage()).build();
        }
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Response deleteMany(@QueryParam("filter") String filter @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes)">
    @DELETE
    @Path("deletemany")
    public Response deleteMany(@QueryParam("filter") String filter, @QueryParam("idempresa") Long idempresa, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes) {
        ventaRepository.setDynamicDatabase("lecturas_" + anio.toString().trim() + "db");
        Integer numeroMes = mes;
        ventaRepository.setDynamicCollection(nameOfCollection + idempresa.toString().trim() + "_" + JmoordbCoreDateUtil.getNombreMes(numeroMes).toLowerCase());

        Search search = DocumentUtil.convertForLookup(filter, "", 0, 0);
        if (ventaRepository.deleteMany(search) == 0L) {
            return Response.status(201).entity(Boolean.TRUE).build();
        } else {
            return Response.status(400).entity("Error " + ventaRepository.getJmoordbException().getLocalizedMessage()).build();
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="List<Venta> lookup(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size,@QueryParam("idempresa") Long idempresa, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes)">
    @GET
    @Path("lookup")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Venta> lookup(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size, @QueryParam("idempresa") Long idempresa, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes) {
        List<Venta> suggestions = new ArrayList<>();
        try {

            ventaRepository.setDynamicDatabase("lecturas_" + anio.toString().trim() + "db");
            Integer numeroMes = mes;
            ventaRepository.setDynamicCollection(nameOfCollection + idempresa.toString().trim() + "_" + JmoordbCoreDateUtil.getNombreMes(numeroMes).toLowerCase());

            Search search = DocumentUtil.convertForLookup(filter, sort, page, size);

            suggestions = ventaRepository.lookup(search);

        } catch (Exception e) {

            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + "error: " + e.getLocalizedMessage());
        }
        System.out.println("Resultado: " + suggestions);
        return suggestions;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Long count(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size, @QueryParam("anio") Long anio)">
    @GET
    @Path("count")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Long count(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("page") Integer page, @QueryParam("size") Integer size, @QueryParam("idempresa") Long idempresa, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes) {
        Long result = 0L;
        try {
            ventaRepository.setDynamicDatabase("lecturas_" + anio.toString().trim() + "db");
            Integer numeroMes = mes;
            ventaRepository.setDynamicCollection(nameOfCollection + idempresa.toString().trim() + "_" + JmoordbCoreDateUtil.getNombreMes(numeroMes).toLowerCase());

            Search search = DocumentUtil.convertForLookup(filter, sort, page, size);
            result = ventaRepository.count(search);

        } catch (Exception e) {

            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + "error: " + e.getLocalizedMessage());
        }

        return result;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Venta> findLastVenta @QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes">
    @GET
    @Path("findlastventa")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Venta> findLastVenta(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("idempresa") Long idempresa, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes) {
        List<Venta> suggestions = new ArrayList<>();
        try {
            Integer numeroMes = mes;

            ventaRepository.setDynamicDatabase("lecturas_" + anio.toString().trim() + "db");
            ventaRepository.setDynamicCollection(nameOfCollection + idempresa.toString().trim() + "_" + JmoordbCoreDateUtil.getNombreMes(numeroMes).toLowerCase());
            Search search = DocumentUtil.convertForLookup(filter, sort, 1, 1);

            suggestions = ventaRepository.lookup(search);

        } catch (Exception e) {

            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + "error: " + e.getLocalizedMessage());
        }

        return suggestions;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="List<Venta> findAllLastVenta @QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes">
    @GET
    @Path("findalllastventa")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})

    public List<Venta> findAllLastVenta(@QueryParam("filter") String filter, @QueryParam("sort") String sort, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes) {
        List<Venta> suggestions = new ArrayList<>();
        List<Venta> resultSearch = new ArrayList<>();
        try {
            Integer numeroMes = mes;
            Long countEstaciones = empresaRepository.count();

            for (int index = 1; index <= countEstaciones; index++) {

                ventaRepository.setDynamicDatabase("lecturas_" + anio.toString().trim() + "db");
                ventaRepository.setDynamicCollection(nameOfCollection + String.valueOf(index) + "_" + JmoordbCoreDateUtil.getNombreMes(numeroMes).toLowerCase());
                Search search = DocumentUtil.convertForLookup(filter, sort, 1, 1);

                resultSearch = ventaRepository.lookup(search);
                suggestions.addAll(resultSearch);
            }

        } catch (Exception e) {

            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + "error: " + e.getLocalizedMessage());
        }

        return suggestions;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" List<Venta> betweenDate(@QueryParam("fechainicial") Date fechainicial, @QueryParam("fechafinal") Date fechafinal, @QueryParam("anio") Long anio)">
    @GET
    @Path("betweendate")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Venta> betweenDate(@QueryParam("fechainicial") @DateFormat("dd-MM-yyyy") final Date fechainicial, @QueryParam("fechafinal") @DateFormat("dd-MM-yyyy") final Date fechafinal, @QueryParam("idempresa") Long idempresa, @QueryParam("anio") Integer anio, @QueryParam("mes") Integer mes) {

        List<Venta> suggestions = new ArrayList<>();
        try {
            ventaRepository.setDynamicDatabase("lecturas_" + anio.toString().trim() + "db");
            Integer numeroMes = mes;
            ventaRepository.setDynamicCollection(nameOfCollection + idempresa.toString().trim() + "_" + JmoordbCoreDateUtil.getNombreMes(numeroMes).toLowerCase());

            suggestions = ventaRepository.findByFechahoraGreaterThanEqualAndFechahoraLessThanEqual(fechainicial, fechafinal);

        } catch (Exception e) {

            MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + "error: " + e.getLocalizedMessage());
        }
        System.out.println("Resultado: " + suggestions);

        return suggestions;
    }

    // </editor-fold>
}
