/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jmoordbcore.capitulo08.repository;

import com.jmoordb.core.annotation.date.IncludeTime;
import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.jmoordb.core.annotation.repository.Find;
import com.jmoordb.core.annotation.repository.Ping;
import com.jmoordb.core.annotation.repository.Query;
import com.jmoordb.core.annotation.repository.Repository;
import com.jmoordb.core.model.Pagination;
import com.jmoordb.core.model.Sorted;
import com.jmoordb.core.repository.CrudRepository;
import com.jmoordbcore.capitulo08.model.Animal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author avbravo
 */
@Repository(entity = Animal.class, jakartaSource = JakartaSource.JAKARTA)
public interface AnimalRepository extends CrudRepository<Animal, Long> {

    @Query(where = "fechaalimentacion .eq. @fechaalimentacion")
    public List<Animal> queryByFecha(@IncludeTime Date fechaalimentacion);

    @Find
    public List<Animal> findByEdadGreaterThanPagination(Long edad, Pagination pagination);

    @Find
    public List<Animal> findByEdadGreaterThanPaginationSorted(Long edad, Pagination pagination, Sorted sorted);

    @Ping
    public Boolean ping();
}
