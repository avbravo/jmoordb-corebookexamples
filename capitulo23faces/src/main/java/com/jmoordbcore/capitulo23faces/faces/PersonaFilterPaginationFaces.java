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

    private static final long serialVersionUID = 1L;

    // <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
    PersonaRepository personaRepository;
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Fields">
    private DataTable dataTable;
    Integer totalRecords = 0;
    List<Persona> personaList = new ArrayList<>();

    private String nombre;

    private String nombreDeporte = "";
    private String nombrePais = "";

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

                switch (paginator.getName()) {

                    case "findAllPagination":

                        totalRecords = personaRepository.count().intValue();

                        break;
                    case "findAllPaginationSorted":

                        totalRecords = personaRepository.count().intValue();

                        break;
                    case "findByNombrePagination":
                        /**
                         * Cuando es una atributo normela
                         */

                        totalRecords = personaRepository.countByNombre(nombre).intValue();

                        break;
                    case "findByNombrePaginationSorted":
                        /**
                         * Cuando es una atributo normela
                         */

                        totalRecords = personaRepository.countByNombre(nombre).intValue();

                        break;
                    case "findByDeportePaginacion":

                        totalRecords = personaRepository.count(search).intValue();

                        break;
                    case "findByPaisPaginacion":

                        totalRecords = personaRepository.count(search).intValue();

                        break;
                }

                List<Paginator> list = processLazyDataModel(paginator, paginatorOld, offset, rowPage.get(), totalRecords, sortBy);

                paginator = list.get(0);
                paginatorOld = list.get(1);

                paginator.setNumberOfPage(numberOfPages(totalRecords, rowPage.get()));

                Pagination pagination = new Pagination(paginator.getPage(), rowPage.get());

                List<Persona> result = new ArrayList<>();
                switch ((paginator.getName())) {

                    case "findAllPagination":

                        result = personaRepository.findAllPagination(pagination);

                        break;
                    case "findAllPaginationSorted":

                        result = personaRepository.findAllPaginationSorted(pagination, paginator.getSorted());

                        break;
                    case "findByNombrePagination":
                        result = personaRepository.findByNombrePagination(nombre, pagination);

                        break;

                    case "findByDeportePaginacion":
                        search.setPagination(pagination);
                        search.setSorted(paginator.getSorted());

                        result = personaRepository.lookup(search);

                        break;
                    case "findByPaisPaginacion":
                        search.setPagination(pagination);
                        search.setSorted(paginator.getSorted());

                        result = personaRepository.lookup(search);

                        break;
                }

                personaLazyDataModel.setRowCount(totalRecords);

                PrimeFaces.current().executeScript("setDataTableWithPageStart()");

                return result;
            }

            @Override
            public int count(Map<String, FilterMeta> map) {

                return totalRecords;
            }

        };

    }
// </editor-fold>

    public String findAllPagination() {
        try {

            paginator
                    = new Paginator.Builder()
                            .page(1)
                            .sorted(new Sorted(new Document("idpersona", 1)))
                            .title("Todos")
                            .name("findAllPagination")
                            .build();

            /**
             * Limpiar los elementos
             */
            nombre = "";
            nombreDeporte = "";
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
                            .sorted(new Sorted(new Document("idpersona", 1)))
                            .title("Todos")
                            .name("findAllPaginationSorted")
                            .build();

            /**
             * Limpiar los elementos
             */
            nombre = "";
            nombreDeporte = "";
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
                            .sorted(new Sorted(new Document("idpersona", 1)))
                            .name("findByNombrePagination")
                            .title("Nombre")
                            .build();

            nombreDeporte = "";
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
                            .sorted(new Sorted(new Document("nombre", 1)))
                            .name("findByNombrePaginationSorted")
                            .title("Nombre con Sorted")
                            .build();

            /**
             * Limpiar los elementos
             */
            // nombre="";
            nombreDeporte = "";
            nombrePais = "";
            setFirstPageDataTable();
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfMethod() + "() : " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="findByDeportePaginacion()">

    public String findByDeportePaginacion() {
        try {

            /**
             * Como se usa una busqueda en un documento embebido se usa el
             * search..
             */
            Bson filter = new Document("deporte.deporte", nombreDeporte);

            Document sort = new Document("idpersona", 1);

            search.setFilter(DocumentUtil.jsonToDocument(DocumentUtil.bsonToJson(filter)));
            search.setPagination(new Pagination(1, rowPage.get()));
            search.setSorted(new Sorted(sort));
            paginator
                    = new Paginator.Builder()
                            .page(1)
                            .sorted(new Sorted(new Document("idpersona", 1)))
                            .name("findByDeportePaginacion")
                            .title("Deporte")
                            .build();

            /**
             * Limpiar los elementos
             */
            nombre = "";
            nombrePais = "";
            setFirstPageDataTable();
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfMethod() + "() : " + e.getLocalizedMessage());
        }
        return "";
    }
// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="findByDeportePaginacion()">
    public String findByPaisPaginacion() {
        try {

            /**
             * Como se usa una busqueda en un documento embebido se usa el
             * search..
             */
            Bson filter = new Document("pais.pais", nombrePais);

            Document sort = new Document("idpersona", 1);

            search.setFilter(DocumentUtil.jsonToDocument(DocumentUtil.bsonToJson(filter)));
            search.setPagination(new Pagination(1, rowPage.get()));
            search.setSorted(new Sorted(sort));
            paginator
                    = new Paginator.Builder()
                            .page(1)
                            .sorted(new Sorted(sort))
                            .name("findByPaisPaginacion")
                            .title("Pais")
                            .build();

            /**
             * Limpiar los elementos
             */
            nombre = "";
            nombreDeporte = "";
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
