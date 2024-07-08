/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.capitulo19.repository;

import com.capitulo19.model.Venta;
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

/**
 *
 * @author avbravo
 */
@Repository(database = "{mongodb.database1}", entity = Venta.class)
public interface VentaRepository extends CrudRepository<Venta, Long> {

    @Lookup
    public List<Venta> lookup(Search search);

    @Count()
    public Long count(Search... search);
    
    @CountLikeBy(caseSensitive = CaseSensitive.NO, likeByType = LikeByType.ANYWHERE)
    public Long countLikeByVenta(String venta);
       
    @CountLikeBy(caseSensitive = CaseSensitive.NO, likeByType = LikeByType.ANYWHERE)
    public Long countLikeByDescripcion(String descripcion);

    @SearchCountLikeBy(caseSensitive = CaseSensitive.NO, likeByType = LikeByType.ANYWHERE)
    public Long searchCountLikeByVenta(String venta, Search search);
    
    @SearchCountLikeBy(caseSensitive = CaseSensitive.NO, likeByType = LikeByType.ANYWHERE)
    public Long searchCountLikeByDescripcion(String descripcion, Search search);
    
    @LikeBy(caseSensitive = CaseSensitive.NO, typeOrder = TypeOrder.ASC, likeByType = LikeByType.ANYWHERE)
    public List<Venta> likeByVenta(String venta);
    
    @LikeBy(caseSensitive = CaseSensitive.NO, typeOrder = TypeOrder.ASC, likeByType = LikeByType.ANYWHERE)
    public List<Venta> likeByVentaPagination(String venta, Pagination pagination);
    
   
    
    @LikeBy(caseSensitive = CaseSensitive.NO, typeOrder = TypeOrder.ASC, likeByType = LikeByType.ANYWHERE)
    public List<Venta> likeByDescripcion(String descripcion);


   @SearchLikeBy(caseSensitive = CaseSensitive.NO, typeOrder = TypeOrder.ASC, likeByType = LikeByType.ANYWHERE)
    public List<Venta> searchLikeByVenta(String venta, Search search);

    @SearchLikeBy(caseSensitive = CaseSensitive.NO, typeOrder = TypeOrder.ASC, likeByType = LikeByType.ANYWHERE)
    public List<Venta> searchLikeByDescripcion(String descripcion, Search search);

    @Find
    public List<Venta> findByFechahoraGreaterThanEqualAndFechahoraLessThanEqual(@ExcludeTime Date start, @ExcludeTime Date end);


}
