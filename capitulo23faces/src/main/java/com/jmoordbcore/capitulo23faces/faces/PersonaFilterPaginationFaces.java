/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.jmoordbcore.capitulo23faces.faces;

import com.avbravo.jmoordbutils.paginator.IPaginator;
import com.avbravo.jmoordbutils.paginator.Paginator;
import com.jmoordb.core.model.Pagination;
import com.jmoordb.core.util.DocumentUtil;
import com.avbravo.jmoordbutils.FacesUtil;
import com.jmoordb.core.model.Search;
import com.jmoordb.core.model.Sorted;
import com.jmoordbcore.capitulo23faces.model.Persona;
import com.jmoordbcore.capitulo23faces.repository.PersonaRepository;
import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
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
import org.primefaces.component.datatable.DataTable;
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
public class PersonaFilterPaginationFaces implements Serializable, IPaginator {
private DataTable dataTable;

    private static final long serialVersionUID = 1L;

    // <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
    PersonaRepository personaRepository;
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Fields">
    List<Persona> personaList = new ArrayList<>();

    private String nombre;

//    private Deporte deporte;
    private String nombreDeporte = "";

    Search search = new Search();

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
    public PersonaFilterPaginationFaces() {

    }

    // <editor-fold defaultstate="collapsed" desc=" init">
    @PostConstruct
    public void init() {

      //  findAllPagination();
       findAllPaginationSorted();

        this.personaLazyDataModel = new LazyDataModel<Persona>() {
            @Override
            public List<Persona> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
                System.out.println("[...........................Load().....]");
                Integer totalRecords = 0;

                switch (paginator.getName()) {

                    case "findAllPagination":

                        totalRecords = personaRepository.count().intValue();
                        System.out.println("\t(*)----->count...findAllPagination totalRecords " + totalRecords);
                        break;
                    case "findAllPaginationSorted":

                        totalRecords = personaRepository.count().intValue();
                        System.out.println("\t(*)----->count...findAllPaginationSorted totalRecords " + totalRecords);
                        break;
                    case "findByNombrePagination":
                        /**
                         * Cuando es una atributo normela
                         */

                        totalRecords = personaRepository.countByNombre(nombre).intValue();
                        System.out.println("\t(*)----->count...findByNombrePagination totalRecords " + totalRecords);
                        break;
                    case "findByNombrePaginationSorted":
                        /**
                         * Cuando es una atributo normela
                         */

                        totalRecords = personaRepository.countByNombre(nombre).intValue();
                        System.out.println("\t(*)----->count...findByNombrePagination totalRecords " + totalRecords);
                        break;
                    case "findByDeportePaginacion":

                        totalRecords = personaRepository.count(search).intValue();
                        System.out.println("\t(*)----->count...findByDeportePaginacion totalRecords " + totalRecords);
                        break;
                }

                System.out.println("  \t[-----]totalRecords  [" + totalRecords + "]");

                List<Paginator> list = processLazyDataModel(paginator, paginatorOld, offset, rowPage.get(), totalRecords, sortBy);
                System.out.println("__________________________________________________");
                System.out.println("[]-->() from load processLazyDataMode ");
                System.out.println("--{paginator}   :-->>  " + paginator.toString());
                System.out.println("--{paginatorOld}:-->> " + paginatorOld.toString());
                System.out.println("__________________________________________________");
                paginator = list.get(0);
                paginatorOld = list.get(1);

                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("[]-->() step new change load processLazyDataMode ");
                System.out.println("--{paginator}   :-->>  " + paginator.toString());
                System.out.println("--{paginatorOld}:-->> " + paginatorOld.toString());
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                paginator.setNumberOfPage(numberOfPages(totalRecords, rowPage.get()));
                System.out.println(" [] new NumberOfPage paginator.getNumberOfPage() " + paginator.getNumberOfPage());

                Pagination pagination = new Pagination(paginator.getPage(), rowPage.get());
                System.out.println(" [] set to Pagination " + pagination.toString());
//                System.out.println("-->Pagintation  paginator.getPage() ["+paginator.getPage()+"]  [paginator.getNumberOfPage()] " + paginator.getNumberOfPage());
                System.out.println("-->Pagintation  paginator.getPage() [" + paginator.getPage() + "]  [paginator.getNumberOfPage()] " + paginator.getNumberOfPage());

                List<Persona> result = new ArrayList<>();
                switch ((paginator.getName())) {

                    case "findAllPagination":

                        result = personaRepository.findAllPagination(pagination);
                        System.out.println("\t#############################################################");
                        System.out.println("  case \"findAllPagination\" result.size "+result.size());
                        System.out.println("\t#############################################################");

                        break;
                    case "findAllPaginationSorted":

                        result = personaRepository.findAllPaginationSorted(pagination,paginator.getSorted());
                        System.out.println("\t??????????????????????????????????????????????????????????????");
                        System.out.println("  case \"findAllPaginatioSorterdn\" result.size "+result.size());
                        System.out.println(">>> paginator.getSorted() "+paginator.getSorted());
                        System.out.println("\t??????????????????????????????????????????????????????????????");

                        break;
                    case "findByNombrePagination":
                        result = personaRepository.findByNombrePagination(nombre, pagination);
                        System.out.println("\t#############################################################");
                        System.out.println("  case \"\"findByNombrePagination\"\" result.size "+result.size());
                        System.out.println("\t#############################################################");

                        break;
                
                    case "findByDeportePaginacion":
                        search.setPagination(pagination);
                        search.setSorted(paginator.getSorted());
                        
                        result = personaRepository.lookup(search);
                        System.out.println("\t#############################################################");
                        System.out.println("  case \"\"findByDeportePaginacion\"\" result.size "+result.size());
                        System.out.println("\t#############################################################");

                        break;
                }

                personaLazyDataModel.setRowCount(totalRecords);
                System.out.println(" \t[] personaLazyDataModel.getRowCount() RowCount " + personaLazyDataModel.getRowCount());
                PrimeFaces.current().executeScript("setDataTableWithPageStart()");

//      final DataTable d = (DataTable) FacesContext.getCurrentInstance().getViewRoot()
//            .findComponent("detailsTable:webTemplateUpdateTable");
//      pageTableField = (d.getPageCount() - 1);
                return result;
            }

            @Override
            public int count(Map<String, FilterMeta> map) {
                System.out.println("----------------------Metodo count");
                Integer totalRecords2 = personaRepository.count().intValue();
                System.out.println("----------------Total records 2 = " + totalRecords2);
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

            paginator
                    = new Paginator.Builder()
                            .page(1)
                            .sorted(new Sorted(new Document("idpersona",1)))
                            .title("Todos")
                            .name("findAllPagination")
                            .build();

        /**
         * Limpiar los elementos
         */
        nombre="";
        nombreDeporte="";
            setFirstPageDataTable();
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfMethod() + "() : " + e.getLocalizedMessage());
        }

        return "";
    }
    public String findAllPaginationSorted() {
        try {

            paginator
                    = new Paginator.Builder()
                            .page(1)
                            .sorted(new Sorted(new Document("idpersona",1)))
                            .title("Todos")
                            .name("findAllPaginationSorted")
                            .build();

        /**
         * Limpiar los elementos
         */
        nombre="";
        nombreDeporte="";
            setFirstPageDataTable();
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfMethod() + "() : " + e.getLocalizedMessage());
        }

        return "";
    }

    // <editor-fold defaultstate="collapsed" desc="String  findByNombrePaginacion()">
    public String findByNombrePaginacion() {
        try {
            paginator
                    = new Paginator.Builder()
                            .page(1)
                          //  .query(DocumentUtil.jsonToDocument(DocumentUtil.bsonToJson(filter)))
                            //.sort(new Document())
                        .sorted(new Sorted(new Document("idpersona",1)))
                            .name("findByNombrePagination")
                            .title("Nombre")
                            .build();

                 /**
         * Limpiar los elementos
         */
       // nombre="";
        nombreDeporte="";
          setFirstPageDataTable();
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfMethod() + "() : " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="String  findByNombrePaginacionSorted()">
    public String findByNombrePaginacionSorted() {
        try {
            paginator
                    = new Paginator.Builder()
                            .page(1)
                          //  .query(DocumentUtil.jsonToDocument(DocumentUtil.bsonToJson(filter)))
                            //.sort(new Document())
                        .sorted(new Sorted(new Document("nombre",1)))
                            .name("findByNombrePaginationSorted")
                            .title("Nombre con Sorted")
                            .build();

                 /**
         * Limpiar los elementos
         */
       // nombre="";
        nombreDeporte="";
          setFirstPageDataTable();
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfMethod() + "() : " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="findByDeportePaginacion">

    public String findByDeportePaginacion() {
        try {

            
/**
 * Como se usa una busqueda en un documento embebido se usa el search..
*/
            Bson filter = new Document("deporte.deporte", nombreDeporte);

            Document sort = new Document("idpersona", 1);

            search.setFilter(DocumentUtil.jsonToDocument(DocumentUtil.bsonToJson(filter)));
            search.setPagination(new Pagination(1, rowPage.get()));
            search.setSorted(new Sorted(sort));
            paginator
                    = new Paginator.Builder()
                            .page(1)
                             .sorted(new Sorted(new Document("idpersona",1)))
                            .name("findByDeportePaginacion")
                            .title("Deporte")
                            .build();

                 /**
         * Limpiar los elementos
         */
        nombre="";
             setFirstPageDataTable();
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfMethod() + "() : " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>
    
    
    
   // <editor-fold defaultstate="collapsed" desc="setFirstPageDataTable()">
    public void setFirstPageDataTable() {
    
    dataTable.setFirst(1);
}
    // </editor-fold>
}
