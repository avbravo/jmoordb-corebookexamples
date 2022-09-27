/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo02.controller;

import com.jmoordb.core.annotation.date.DateFormat;
import com.jmoordb.core.annotation.date.DateTimeFormat;
import com.jmoordb.core.util.JmoordbCoreDateUtil;
import com.jmoordb.core.util.MessagesUtil;
import com.jmoordbcore.capitulo02.model.Pais;
import com.jmoordbcore.capitulo02.repository.PaisRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.inject.Inject;
import javax.ws.rs.BeanParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 *
 * @author avbravo
 */
@Path("pais")
@Tag(name = "Información del pais", description = "End-point para entidad Pais")
public class PaisController {

    @Inject
    MongoClient mongoClient;
/**
* Microprofile Config
*/
    @Inject
    Config config;
    @Inject
    @ConfigProperty(name = "mongodb.database")
    String mongodbDatabase;

    String mongodbCollection = "pais";
    // <editor-fold defaultstate="collapsed" desc="Inject">
    @Inject
    PaisRepository paisRepository;
// </editor-fold>

    @Path("fechagreaterthan")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Operation(summary = "Obtiene los paises con fecha mayor", description = "Retorna todos los paises con fechas mayor")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @APIResponse(responseCode = "200", description = "Los paises")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    @APIResponse(description = "Los paises", responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Collection.class, readOnly = true, description = "los paises", required = true, name = "paises")))
    public List<Pais> findByFechaGreaterThan(@QueryParam("fecha")  @DateFormat("dd-MM-yyyy") final Date fecha) {
        return paisRepository.findByFechaGreaterThan(fecha);
    }
    
    @Path("dategreaterthanandfechalessthanwithouthours")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Operation(summary = "Obtiene los paises con fecha ", description = "Retorna todos los paises con fechas mayor")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @APIResponse(responseCode = "200", description = "Los paises")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    @APIResponse(description = "Los paises", responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Collection.class, readOnly = true, description = "los paises", required = true, name = "paises")))
    public List<Pais> findByFechaGreaterThanAndFechaLessThanWithoutHours(@QueryParam("fecha")  @DateFormat final Date fecha) {
        
       Date dateStart = JmoordbCoreDateUtil.setHourToDate(fecha, 0, 0);
            Date dateEnd = JmoordbCoreDateUtil.setHourToDate(fecha, 23, 59);
            
            System.out.println("fecha[" + fecha +"]  start [ "+dateStart + "] en dateEnd ["+dateEnd+"]");
        return paisRepository.findByFechaGreaterThanAndFechaLessThan(dateStart, dateEnd);

    }
    @Path("dategreaterthanandfechalessthanwithouthourstwodates")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Operation(summary = "Obtiene los paises con fecha ", description = "Retorna todos los paises con fechas mayor")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @APIResponse(responseCode = "200", description = "Los paises")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    @APIResponse(description = "Los paises", responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Collection.class, readOnly = true, description = "los paises", required = true, name = "paises")))
    public List<Pais> findByFechaGreaterThanAndFechaLessThanWithoutHours(@QueryParam("fecha")  @DateFormat final Date fecha, @QueryParam("fechafinal")  @DateFormat final Date fechafinal) {
        
       Date dateStart = JmoordbCoreDateUtil.setHourToDate(fecha, 0, 0);
            Date dateEnd = JmoordbCoreDateUtil.setHourToDate(fechafinal, 23, 59);
            
            System.out.println("fecha[" + fecha +"]  start [ "+dateStart + "] en dateEnd ["+dateEnd+"]");
        return paisRepository.findByFechaGreaterThanAndFechaLessThan(dateStart, dateEnd);

    }
    
    @Path("fechagreaterthanequalsandfechalesthanequalswithouthours")
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Operation(summary = "Obtiene los paises con fecha igual mayor o igual y menor o igual sin horas", description = "Retorna todos los paises con fechas mayor")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @APIResponse(responseCode = "200", description = "Los paises")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    @APIResponse(description = "Los paises", responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Collection.class, readOnly = true, description = "los paises", required = true, name = "paises")))
    public List<Pais> findByFechaGreaterThanEqualsThanAndFechaLessEqualsThanWithoutHours(@QueryParam("fecha")  @DateFormat final Date fecha) {
/**
 * Cuando es rango de fecha asignar hora =0, minuto=0 a la fecha inicial
 * Asignar un dia mas y hora 0 y minuto 0 a la fecha final
 * https://www.mongodb.com/community/forums/t/i-want-data-between-two-dates-how-can-i-achieve-this/148777
 * 
 */

//                    Date startIsoDate = JmoordbCoreDateUtil.stringToISODate( JmoordbCoreDateUtil.isoDateToString(fecha));//dateString is query param.
//            Date endIsoDate = JmoordbCoreDateUtil.stringToISODate(JmoordbCoreDateUtil.isoDateToString(fecha));//dateString is query param.
//            
         

//Date dateStartOne = getCurrentUtcTime(fecha);
          Date     dateStartOne =  JmoordbCoreDateUtil.restarDiaaFecha(fecha,1);
    Date     dateEndOne =  JmoordbCoreDateUtil.sumarDiaaFecha(fecha,1);
//        Date dateEndOne =getCurrentUtcTime(fecha);;
            
//               dateStartOne = JmoordbCoreDateUtil.setHourToDate(dateStartOne, 0, 0);
             //  dateStartOne = JmoordbCoreDateUtil.setHourToDate(dateStartOne, 23, 59,59);
              
         // dateEndOne = JmoordbCoreDateUtil.setHourToDate(dateEndOne, 23, 59);
        System.out.println("______________________________________________");
    //    System.out.println("stringToISodate startIsoDat "+startIsoDate + "   endIsoDate "+endIsoDate);
        System.out.println("[dateStartOne "+dateStartOne+ "] [dateEndOne "+dateEndOne+"]");
        
        System.out.println("______________________________________________");
    
        System.out.println("***********************************");
            System.out.println("Incovcando findBy");
            findBy(dateStartOne, dateEndOne );
            System.out.println("***********************************");
        return paisRepository.findByFechaGreaterThanEqualAndFechaLessThanEqual(dateStartOne, dateEndOne);

          
//
//               Date dateStart = JmoordbCoreDateUtil.setHourToDate(fecha, 0, 0);
//            Date dateEnd = JmoordbCoreDateUtil.sumarDiaaFecha(fecha,1);
//            dateEnd = JmoordbCoreDateUtil.setHourToDate(dateEnd, 0, 0);
//            System.out.println("fecha[" + fecha +"]  start [ "+dateStart + "] en dateEnd ["+dateEnd+"]");
//
//        return paisRepository.findByFechaGreaterThanEqualAndFechaLessThanEqual(dateStart, dateEnd);
    }
    
//    @Path("fechahora")
//    @GET
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    @Operation(summary = "Obtiene los paises con fecha igual", description = "Retorna todos los paises con fechas mayor")
//    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
//    @APIResponse(responseCode = "200", description = "Los paises")
//    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
//    @APIResponse(description = "Los paises", responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Collection.class, readOnly = true, description = "los paises", required = true, name = "paises")))
//    public List<Pais> findByFecha(@QueryParam("fecha")  @DateTimeFormat final Date fecha) {
//        return paisRepository.findByFecha(fecha);
//    }

    
    
    
 
    @Path("test3")
    @GET
    public Date test3(@QueryParam("myDate")
            @DateTimeFormat final Date myDate) {
        return myDate;
    }

    @Path("test4")
    @GET
    public Date test4(@QueryParam("myDate")
            @DateTimeFormat("yyyy/MM/dd HH:mm") final Date myDate) {
        return myDate;
    }

    @Path("test5")
    @GET
    public MyDateTest test5(@BeanParam final MyDateTest myDateTeste) {
        return myDateTeste;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Operation(summary = "Obtiene todos los paises", description = "Retorna todos los paises disponibles")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @APIResponse(responseCode = "200", description = "Los paises")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    @APIResponse(description = "Los paises", responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Collection.class, readOnly = true, description = "los paises", required = true, name = "paises")))
    public List<Pais> findAll() {
        return paisRepository.findAll();
    }

    @GET
    @Path("{idpais}")
    @Operation(summary = "Busca un pais por el idpais", description = "Busqueda de pais por idpais")
    @APIResponse(responseCode = "200", description = "El pais")
    @APIResponse(responseCode = "404", description = "Cuando no existe el idpais")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    @APIResponse(description = "El pais", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = Pais.class)))
    public Pais findByIdpais(
            @Parameter(description = "El idpais", required = true, example = "1", schema = @Schema(type = SchemaType.NUMBER)) @PathParam("idpais") Long idpais) {
        return paisRepository.findByPk(idpais).orElseThrow(
                () -> new WebApplicationException("No hay pais con idpais " + idpais, Response.Status.NOT_FOUND));

    }

    @POST
    @Operation(summary = "Inserta un nuevo pais", description = "Inserta un nuevo pais")
    @APIResponse(responseCode = "201", description = "Cuanoo se crea un  pais")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    public Response save(
            @RequestBody(description = "Crea un nuevo pais.", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pais.class))) Pais pais) {
        pais.setFecha(new Date());
        return Response.status(Response.Status.CREATED).entity(paisRepository.save(pais)).build();
    }

    @DELETE
    @Path("{idpais}")
    @Operation(summary = "Elimina un pais por  idpais", description = "Elimina un pais por su idpais")
    @APIResponse(responseCode = "200", description = "Cuando elimina el pais")
    @APIResponse(responseCode = "500", description = "Servidor inalcanzable")
    @Tag(name = "BETA", description = "Esta api esta en desarrollo")
    public Response delete(
            @Parameter(description = "El elemento idpais", required = true, example = "1", schema = @Schema(type = SchemaType.NUMBER)) @PathParam("idpais") Long idpais) {
        paisRepository.deleteByPk(idpais);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    public static class MyDateTest {

        @QueryParam("myDate")
        @DateTimeFormat("dd-MM-yyyy HH:mm")
        private Date myDate;

        public Date getMyDate() {
            return myDate;
        }

        public void setMyDate(Date myDate) {
            this.myDate = myDate;
        }
    }
    
     public java.util.List<com.jmoordbcore.capitulo02.model.Pais> findBy(java.util.Date start,java.util.Date end) {
        List<Pais> list = new ArrayList<>();
        try {
               MongoDatabase database = mongoClient.getDatabase(mongodbDatabase);
               MongoCollection<Document> collection = database.getCollection(mongodbCollection);
               MongoCursor<Document> cursor;
               Bson filter =Filters.and(
			Filters.gte("fecha",start)
			,Filters.lte("fecha",end)
		);
            System.out.println("[filter ] "+filter);
		cursor = collection.find( filter )
					.iterator();

               try{
                  while (cursor.hasNext()) {
                      System.out.println("cursor.[ next ]"+cursor.next());
                       //list.add(paisSupplier.get(Pais::new, cursor.next()));
                  }
                   System.out.println("[[[[ end ]]]]]");
               } finally {
                     cursor.close();
               } 
         } catch (Exception e) {
              MessagesUtil.error(MessagesUtil.nameOfClassAndMethod() + " " + e.getLocalizedMessage());
         }
         return list;

     }
     
       // create getCurrentUtcTime() method to get the current UTC time  
    public static Date getCurrentUtcTime(Date date) {  // handling ParseException  
            Date d1 = date;  
         // create an instance of the SimpleDateFormat class  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");  
        // set UTC time zone by using SimpleDateFormat class  
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));  
        //create another instance of the SimpleDateFormat class for local date format  
        SimpleDateFormat ldf = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");  
        // declare and initialize a date variable which we return to the main method  
    
        // use try catch block to parse date in UTC time zone  
        try {  
            // parsing date using SimpleDateFormat class  
            d1 = ldf.parse( sdf.format(new Date()) );  
        }   
        // catch block for handling ParseException  
        catch (java.text.ParseException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
            System.out.println(e.getMessage());  
        }  
       
        // pass UTC date to main method.  
        return d1;  
    }  

}
