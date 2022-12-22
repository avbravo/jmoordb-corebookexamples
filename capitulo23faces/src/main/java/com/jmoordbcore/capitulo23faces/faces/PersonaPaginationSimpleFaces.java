/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.jmoordbcore.capitulo23faces.faces;

import com.avbravo.jmoordbutils.paginator.IPaginator;
import com.avbravo.jmoordbutils.paginator.Paginator;
import com.jmoordb.core.model.Pagination;
import com.jmoordb.core.model.Sorted;
import com.jmoordb.core.util.DocumentUtil;
import com.jmoordb.core.util.MessagesUtil;
import com.jmoordbcore.capitulo23faces.model.Deporte;
import com.jmoordbcore.capitulo23faces.model.Persona;
import com.jmoordbcore.capitulo23faces.repository.PersonaRepository;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Provider;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.Data;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.primefaces.PrimeFaces;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

/**
 *
 * @author avbravo
 */
@Named()
@ViewScoped
@Data
public class PersonaPaginationSimpleFaces implements Serializable, IPaginator {

    private static final long serialVersionUID = 1L;

    // <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
    PersonaRepository personaRepository;
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Fields">
    List<Persona> personaList = new ArrayList<>();
    
   
        
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="LazyDataModel>
    private LazyDataModel<Persona> personaLazyDataModel;
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="paginator ">
    Paginator paginator = new Paginator();
    Paginator paginatorOld = new Paginator();

    public Paginator getPaginator() {
        return paginator;
    }

    public void setPaginator(Paginator paginator) {
        this.paginator = paginator;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Microprofile Config">
    @Inject
    private Config config;

    // Row
    @Inject
    @ConfigProperty(name = "rowPage", defaultValue = "0")
    private Provider<Integer> rowPage;

    // </editor-fold>
    /**
     * Creates a new instance of PersonaFaces
     */
    public PersonaPaginationSimpleFaces() {

    }

    // <editor-fold defaultstate="collapsed" desc=" init">
    @PostConstruct
    public void init() {

        findAllPagination();

        this.personaLazyDataModel = new LazyDataModel<Persona>() {
            @Override
            public List<Persona> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
               
                Integer totalRecords = personaRepository.count().intValue();
               

                List<Paginator> list = processLazyDataModel(paginator, paginatorOld, offset, rowPage.get(), totalRecords, sortBy);
               
                paginator = list.get(0);
                paginatorOld = list.get(1);
                paginator.setNumberOfPage(numberOfPages(totalRecords, rowPage.get()));
               

                Pagination pagination = new Pagination(paginator.getPage(), rowPage.get());
               
                List<Persona> result = personaRepository.findAllPagination(pagination);
               
                personaLazyDataModel.setRowCount(totalRecords);
              
                PrimeFaces.current().executeScript("setDataTableWithPageStart()");

                return result;
            }

            @Override
            public int count(Map<String, FilterMeta> map) {
              
                Integer totalRecords2 = personaRepository.count().intValue();
              
                return totalRecords2;
            }

        };


    }
// </editor-fold>

    public String findAllPagination() {
        try {


//                Bson filter
//                    = DocumentUtil.createBsonBetweenDateWithoutHours(
//                            "fechahora", startDate, "fechahora", endDate);
//                
            Bson filter = new Document();

            Document sort = new Document("idpersona", -1);
            paginator
                    = new Paginator.Builder()
                            .page(1)
                               .sorted(new Sorted(new Document("idpersona",1)))
                            .title("Filtro basico")
                            .build();

        } catch (Exception e) {
            System.out.println("findAll() " + e.getLocalizedMessage());
        }

        return "";
    }

  
}
