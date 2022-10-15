/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.repository;

import com.jmoordb.core.annotation.repository.Count;
import com.jmoordb.core.annotation.repository.Ping;
import com.jmoordb.core.annotation.repository.Query;
import com.jmoordb.core.model.Pagination;
import com.avbravo.mongodbatlasdriver.model.Oceano;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import com.jmoordb.core.annotation.RepositoryMongoDB;
import com.jmoordb.core.annotation.enumerations.CaseSensitive;
import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.jmoordb.core.annotation.enumerations.TypeOrder;
import com.jmoordb.core.model.Search;
import com.jmoordb.core.model.Sorted;
import com.jmoordb.core.annotation.repository.Lookup;
import com.jmoordb.core.annotation.repository.Regex;
import com.jmoordb.core.annotation.repository.RegexCount;
import java.util.Set;

/**
 *
 * @author avbravo
 */
@RepositoryMongoDB(entity = Oceano.class, jakartaSource = JakartaSource.JAVAEE_LEGACY)
public interface OceanoRepository {
//      @Mandatory
//    String getFirstName();

    @Query()
    public List<Oceano> findAll();

    @Query(where = "idoceano = @id")
    public Optional<Oceano> findById(String id);

    @Query(where = "oceano = @oceano")
    public List<Oceano> findByOceano(String oceano);

    @Query(where = "idoceano = @idoceano and oceano = @oceano")
    public List<Oceano> findByIdoceanoAndOceano(String idoceano, String oceano);

    @Query(where = "oceano = @oceano .limit. pagination .skip. @pagination .order. sorted .by. @sorted")
    public List<Oceano> findByOceanoPagination(String oceano, Pagination pagination, Sorted sorted);

    @Lookup()
    public List<Oceano> queryJSON(Search search, Pagination pagination, Sorted... sorted);

     
    
    @Regex(where = "oceano .like. @oceano  ", caseSensitive = CaseSensitive.NO, typeOrder = TypeOrder.ASC)
    public List<Oceano> regex(String oceano);

    @Regex(where = "oceano .like. @oceano ", caseSensitive = CaseSensitive.YES, typeOrder = TypeOrder.DESC)
    public Set<Oceano> regexOceano(String oceano);

    @Regex(where = "oceano .like. @oceano .limit. pagination .skip. @pagination", caseSensitive = CaseSensitive.YES, typeOrder = TypeOrder.ASC)
    public List<Oceano> regexPagintarion(String oceano, Pagination pagination);
//    public List<Oceano> regexPagintarion(String oceano, Pagination pagination);
    

    @Count()
    public Long count(Search... search);

    @RegexCount(where = "oceano .like. @oceano", caseSensitive = CaseSensitive.NO)
    public Long countRegex(String value);

    public Optional<Oceano> save(Oceano oceano);

    public Boolean update(Oceano oceano);

    public Long delete(String id);

    @Ping
    public Boolean ping();
}
