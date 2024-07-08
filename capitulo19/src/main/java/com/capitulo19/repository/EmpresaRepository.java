/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.capitulo19.repository;

import com.capitulo19.model.Empresa;
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
@Repository(database = "{mongodb.database1}", entity = Empresa.class)
public interface EmpresaRepository extends CrudRepository<Empresa, Long> {

    @Lookup
    public List<Empresa> lookup(Search search);

    @Find
    public List<Empresa> findByEmpresa(String empresa);
    
    @Count()
    public Long count(Search... search);
    
    @CountLikeBy(caseSensitive = CaseSensitive.NO, likeByType = LikeByType.ANYWHERE)
    public Long countLikeByEmpresa(String empresa);
       
    @CountLikeBy(caseSensitive = CaseSensitive.NO, likeByType = LikeByType.ANYWHERE)
    public Long countLikeByDescripcion(String descripcion);

    @SearchCountLikeBy(caseSensitive = CaseSensitive.NO, likeByType = LikeByType.ANYWHERE)
    public Long searchCountLikeByEmpresa(String empresa, Search search);
    
    @SearchCountLikeBy(caseSensitive = CaseSensitive.NO, likeByType = LikeByType.ANYWHERE)
    public Long searchCountLikeByDescripcion(String descripcion, Search search);
    
    @LikeBy(caseSensitive = CaseSensitive.NO, typeOrder = TypeOrder.ASC, likeByType = LikeByType.ANYWHERE)
    public List<Empresa> likeByEmpresa(String empresa);
    
    @LikeBy(caseSensitive = CaseSensitive.NO, typeOrder = TypeOrder.ASC, likeByType = LikeByType.ANYWHERE)
    public List<Empresa> likeByEmpresaPagination(String empresa, Pagination pagination);
    
   
    
    @LikeBy(caseSensitive = CaseSensitive.NO, typeOrder = TypeOrder.ASC, likeByType = LikeByType.ANYWHERE)
    public List<Empresa> likeByDescripcion(String descripcion);


   @SearchLikeBy(caseSensitive = CaseSensitive.NO, typeOrder = TypeOrder.ASC, likeByType = LikeByType.ANYWHERE)
    public List<Empresa> searchLikeByEmpresa(String empresa, Search search);

    @SearchLikeBy(caseSensitive = CaseSensitive.NO, typeOrder = TypeOrder.ASC, likeByType = LikeByType.ANYWHERE)
    public List<Empresa> searchLikeByDescripcion(String descripcion, Search search);

   
}
