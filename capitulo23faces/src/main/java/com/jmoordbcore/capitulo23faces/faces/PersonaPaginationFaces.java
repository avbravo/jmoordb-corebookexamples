/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.jmoordbcore.capitulo23faces.faces;

import com.avbravo.jmoordbutils.paginator.IPaginator;
import com.avbravo.jmoordbutils.paginator.Paginator;
import com.jmoordb.core.model.Pagination;
import com.jmoordb.core.util.DocumentUtil;
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
import static java.util.Locale.filter;
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
public class PersonaPaginationFaces implements Serializable, IPaginator {

    private static final long serialVersionUID = 1L;
    @Inject
    PersonaRepository personaRepository;

    List<Persona> personaList = new ArrayList<>();

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
    public PersonaPaginationFaces() {

    }

    // <editor-fold defaultstate="collapsed" desc=" init">
    @PostConstruct
    public void init() {

        findAllPagination();

        this.personaLazyDataModel = new LazyDataModel<Persona>() {
            @Override
            public List<Persona> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
                System.out.println("Load.....");
                Integer totalRecords = personaRepository.count().intValue();
                System.out.println(" [] load 1 " + totalRecords);

                List<Paginator> list = processLazyDataModel(paginator, paginatorOld, offset, rowPage.get(), totalRecords, sortBy);
                System.out.println(" [] load 2 ");
                paginator = list.get(0);
                paginatorOld = list.get(1);
                paginator.setNumberOfPage(numberOfPages(totalRecords, rowPage.get()));
                System.out.println(" [] load 3 ");

                Pagination pagination = new Pagination(paginator.getPage(), rowPage.get());
                System.out.println(" [] load 4 ");
//                System.out.println("-->Pagintation  paginator.getPage() ["+paginator.getPage()+"]  [paginator.getNumberOfPage()] " + paginator.getNumberOfPage());
                System.out.println("-->Pagintation  paginator.getPage() ["+paginator.getPage()+"]  [paginator.getNumberOfPage()] " + paginator.getNumberOfPage());
                
                
                
                List<Persona> result = personaRepository.findAllPagination(pagination);
                System.out.println(" [] load 5 ");
                personaLazyDataModel.setRowCount(totalRecords);
                System.out.println(" [] load 6 ");
                PrimeFaces.current().executeScript("setDataTableWithPageStart()");
                System.out.println(" [] load 7 ");
                return result;
            }

            @Override
            public int count(Map<String, FilterMeta> map) {
                System.out.println("----------------------Metodo count");
                Integer totalRecords2 = personaRepository.count().intValue();
                System.out.println("----------------Total records 2 " + totalRecords2);
                return totalRecords2;
            }

        };

        //  Long count = personaRepository.count();
//            Integer numberOfPage = JmoordbCorePageUtil.numberOfPages(JmoordbCoreUtil.longToInteger(count), 25);
//
//            System.out.println("Number OfPage  " + numberOfPage);
//
//            Pagination pagination = new Pagination(1, 25);
//            pagination = JmoordbCorePageUtil.first(pagination);
//            pagination = JmoordbCorePageUtil.last(pagination);
//            pagination = JmoordbCorePageUtil.next(pagination);
//            pagination = JmoordbCorePageUtil.back(pagination);
//            personaList = personaRepository.findAll();
//            move(pagination);
    }
// </editor-fold>

    public String findAllPagination() {
        try {
            System.out.println(">>>>>>>>>>>>>>>>>>><<<< paso 0");
            
//                Bson filter
//                    = DocumentUtil.createBsonBetweenDateWithoutHours(
//                            "fechahora", startDate, "fechahora", endDate);
//                
              Bson filter = new Document();
                
            Document sort = new Document("idpersona", -1);
            paginator
                    = new Paginator.Builder()
                            .page(1)
                            .query(DocumentUtil.jsonToDocument(DocumentUtil.bsonToJson(filter)))
                            .query(new Document())
                            .sort(new Document())
                            .title("Filtro basico")
                            .build();

        } catch (Exception e) {
            System.out.println("findAll() " + e.getLocalizedMessage());
        }

        return "";
    }

}
