/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.estacionesserver.repository;

import com.estacionesserver.model.Persona;
import com.jmoordb.core.annotation.date.ExcludeTime;
import com.jmoordb.core.annotation.enumerations.CaseSensitive;
import com.jmoordb.core.annotation.enumerations.LikeByType;
import com.jmoordb.core.annotation.enumerations.TypeOrder;
import com.jmoordb.core.annotation.repository.Count;
import com.jmoordb.core.annotation.repository.CountLikeBy;
import com.jmoordb.core.annotation.repository.Find;
import com.jmoordb.core.annotation.repository.LikeBy;
import com.jmoordb.core.annotation.repository.Lookup;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.annotation.repository.SearchCountLikeBy;
import com.jmoordb.core.annotation.repository.SearchLikeBy;
import com.jmoordb.core.model.Pagination;
import com.jmoordb.core.model.Search;
import com.jmoordb.core.repository.CrudRepository;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author avbravo
 */
@Repository(database = "{mongodb.database1}", entity = Persona.class)
//public interface MedicionRepository extends CrudRepository<Medicion, Long> {
public interface PersonaRepository extends CrudRepository<Persona, ObjectId> {

    @Lookup
    public List<Persona> lookup(Search search);

    @Count()
    public Long count(Search... search);
    
    @CountLikeBy(caseSensitive = CaseSensitive.NO, likeByType = LikeByType.ANYWHERE)
    public Long countLikeByMedicion(String medicion);
       
    @CountLikeBy(caseSensitive = CaseSensitive.NO, likeByType = LikeByType.ANYWHERE)
    public Long countLikeByDescripcion(String descripcion);

    @SearchCountLikeBy(caseSensitive = CaseSensitive.NO, likeByType = LikeByType.ANYWHERE)
    public Long searchCountLikeByMedicion(String medicion, Search search);
    
    @SearchCountLikeBy(caseSensitive = CaseSensitive.NO, likeByType = LikeByType.ANYWHERE)
    public Long searchCountLikeByDescripcion(String descripcion, Search search);
    
    @LikeBy(caseSensitive = CaseSensitive.NO, typeOrder = TypeOrder.ASC, likeByType = LikeByType.ANYWHERE)
    public List<Persona> likeByMedicion(String medicion);
    
    @LikeBy(caseSensitive = CaseSensitive.NO, typeOrder = TypeOrder.ASC, likeByType = LikeByType.ANYWHERE)
    public List<Persona> likeByMedicionPagination(String medicion, Pagination pagination);
    
   
    
    @LikeBy(caseSensitive = CaseSensitive.NO, typeOrder = TypeOrder.ASC, likeByType = LikeByType.ANYWHERE)
    public List<Persona> likeByDescripcion(String descripcion);


   @SearchLikeBy(caseSensitive = CaseSensitive.NO, typeOrder = TypeOrder.ASC, likeByType = LikeByType.ANYWHERE)
    public List<Persona> searchLikeByMedicion(String medicion, Search search);

    @SearchLikeBy(caseSensitive = CaseSensitive.NO, typeOrder = TypeOrder.ASC, likeByType = LikeByType.ANYWHERE)
    public List<Persona> searchLikeByDescripcion(String descripcion, Search search);

    @Find
    public List<Persona> findByFechahoraGreaterThanEqualAndFechahoraLessThanEqual(@ExcludeTime Date start, @ExcludeTime Date end);


}
