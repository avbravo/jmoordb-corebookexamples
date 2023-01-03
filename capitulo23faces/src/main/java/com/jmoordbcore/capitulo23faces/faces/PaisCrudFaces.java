/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.jmoordbcore.capitulo23faces.faces;

import com.avbravo.jmoordbutils.paginator.IPaginator;
import com.avbravo.jmoordbutils.paginator.Paginator;
import com.jmoordb.core.model.Pagination;
import com.avbravo.jmoordbutils.FacesUtil;
import com.jmoordb.core.model.Search;
import com.jmoordb.core.model.Sorted;
import com.jmoordbcore.capitulo23faces.model.Grupo;
import com.jmoordbcore.capitulo23faces.model.Musica;
import com.jmoordbcore.capitulo23faces.model.Pais;
import com.jmoordbcore.capitulo23faces.model.Persona;
import com.jmoordbcore.capitulo23faces.model.Planeta;
import com.jmoordbcore.capitulo23faces.repository.GrupoRepository;
import com.jmoordbcore.capitulo23faces.repository.PaisRepository;
import com.jmoordbcore.capitulo23faces.repository.PersonaRepository;
import com.jmoordbcore.capitulo23faces.repository.PlanetaRepository;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Provider;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.Data;
import org.bson.Document;
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
public class PaisCrudFaces implements Serializable, IPaginator {

    private DataTable dataTable;

    private static final long serialVersionUID = 1L;

    // <editor-fold defaultstate="collapsed" desc="@Inject">
    @Inject
    PaisRepository paisRepository;

    @Inject
    PersonaRepository personaRepository;

    @Inject
    PlanetaRepository planetaRepository;
    
    
    @Inject
    GrupoRepository grupoRepository;
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Fields">
    List<Pais> paisList = new ArrayList<>();

    private String nombrePais;

//    private Deporte deporte;
    Search search = new Search();

    /**
     * Para los datatable
     */
    private Pais selectedPais;
    private List<Pais> selectedPaises;

// </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="LazyDataModel>
    private LazyDataModel<Pais> paisLazyDataModel;
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
     * Creates a new instance of PaisFaces
     */
    public PaisCrudFaces() {

    }

    // <editor-fold defaultstate="collapsed" desc=" init">
    @PostConstruct
    public void init() {

        //  findAllPagination();
        findAllPaginationSorted();

        this.paisLazyDataModel = new LazyDataModel<Pais>() {
            @Override
            public List<Pais> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
                System.out.println("[...........................Load().....]");
                Integer totalRecords = 0;

                switch (paginator.getName()) {

                    case "findAllPagination":

                        totalRecords = paisRepository.count().intValue();

                        break;
                    case "findAllPaginationSorted":

                        totalRecords = paisRepository.count().intValue();

                        break;
                    case "findByNombrePaisPagination":
                        /**
                         * Cuando es una atributo normela
                         */

                        totalRecords = paisRepository.countByPais(nombrePais).intValue();

                        break;

                }

                List<Paginator> list = processLazyDataModel(paginator, paginatorOld, offset, rowPage.get(), totalRecords, sortBy);

                paginator = list.get(0);
                paginatorOld = list.get(1);

                paginator.setNumberOfPage(numberOfPages(totalRecords, rowPage.get()));

                Pagination pagination = new Pagination(paginator.getPage(), rowPage.get());

                List<Pais> result = new ArrayList<>();
                switch ((paginator.getName())) {

                    case "findAllPagination":

                        result = paisRepository.findAllPagination(pagination);

                        break;
                    case "findAllPaginationSorted":

                        result = paisRepository.findAllPaginationSorted(pagination, paginator.getSorted());

                        break;
                    case "findByNombrePaisPagination":
                        result = paisRepository.findByPaisPagination(nombrePais, pagination);

                        break;

                }

                paisLazyDataModel.setRowCount(totalRecords);

                PrimeFaces.current().executeScript("setDataTableWithPageStart()");

//      final DataTable d = (DataTable) FacesContext.getCurrentInstance().getViewRoot()
//            .findComponent("detailsTable:webTemplateUpdateTable");
//      pageTableField = (d.getPageCount() - 1);
                return result;
            }

            @Override
            public int count(Map<String, FilterMeta> map) {

                Integer totalRecords2 = paisRepository.count().intValue();

                return totalRecords2;
            }

        };

        //  Long count = paisRepository.count();
//            Integer numberOfPage = JmoordbCorePageUtil.numberOfPages(JmoordbCoreUtil.longToInteger(count), 25);
//
//            System.out.println("Number OfPage  " + numberOfPage);
//
//            Pagination pagination = new Pagination(1, 25);
//            pagination = JmoordbCorePageUtil.first(pagination);
//            pagination = JmoordbCorePageUtil.last(pagination);
//            pagination = JmoordbCorePageUtil.next(pagination);
//            pagination = JmoordbCorePageUtil.back(pagination);
//            paisList = paisRepository.findAll();
//            move(pagination);
    }
// </editor-fold>

    public String findAllPagination() {
        try {

            paginator
                    = new Paginator.Builder()
                            .page(1)
                            .sorted(new Sorted(new Document("idpais", 1)))
                            .title("Todos")
                            .name("findAllPagination")
                            .build();

            /**
             * Limpiar los elementos
             */
            nombrePais = "";

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
                            .sorted(new Sorted(new Document("idpais", 1)))
                            .title("Todos")
                            .name("findAllPaginationSorted")
                            .build();

            /**
             * Limpiar los elementos
             */
            nombrePais = "";

            setFirstPageDataTable();
        } catch (Exception e) {
            FacesUtil.errorMessage(FacesUtil.nameOfMethod() + "() : " + e.getLocalizedMessage());
        }

        return "";
    }

    // <editor-fold defaultstate="collapsed" desc="String  findByNombrePaginacion()">
    public String findByNombrePaisPaginacion() {
        try {
            paginator
                    = new Paginator.Builder()
                            .page(1)
                            //  .query(DocumentUtil.jsonToDocument(DocumentUtil.bsonToJson(filter)))
                            //.sort(new Document())
                            .sorted(new Sorted(new Document("idpais", 1)))
                            .name("findByNombrePaisPagination")
                            .title("Pais")
                            .build();

            /**
             * Limpiar los elementos
             */
            // nombre="";
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

    public void deletePais() {
//        this.products.remove(this.selectedPais);
//        this.selectedPaiss.remove(this.selectedPais);

        paisRepository.deleteByPk(selectedPais.getIdpais());

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pais Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }

    public String getDeleteButtonMessage() {
        if (hasSelectedPaises()) {
            int size = this.selectedPaises.size();
            return size > 1 ? size + " products selected" : "1 product selected";
        }

        return "Delete";
    }

    public boolean hasSelectedPaises() {
        return this.selectedPaises != null && !this.selectedPaises.isEmpty();
    }

    public void deleteSelectedPaises() {
        // this.paises.removeAll(this.selectedPaises);
        this.selectedPaises = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pais Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
        PrimeFaces.current().executeScript("PF('dtPais').clearFilters()");
    }

    public void savePais() {
        System.out.println("==========================================================");
        System.out.println("MEtodo:|-->>> savePais()===>>>>");
        System.out.println("selectedPais) " + selectedPais.toString());
        if (this.selectedPais.getIdpais() == null) {
//            this.selectedPais.setCode(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9));
//            this.products.add(this.selectedPais);
            if (paisRepository.save(selectedPais).isPresent()) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pais Added"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se añadio Pais"));
            }

        } else {

            if (paisRepository.update(selectedPais)) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pais Updated"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se actualizo pais"));
            }
            System.out.println("[[[[[[[[[[[[[[[[[[[[[[[[[[]]]]]]]]]]]]]]]]]]]]]]]]]]]");
            Planeta planeta = planetaRepository.findByIdplaneta("marte").get();
            /*
            caso 1-1
            */

//    planeta.setUniverso(new Universo("Cambiado a "+selectedPais.getPais()));
  /**
   * caso 1-2
   * Actauliza el primer elemento el segbundo lo deja intancto
   * Estatus:
   */  
//planeta.getUniverso().get(0).setNombre(selectedPais.getPais());
//planeta.getUniverso().add( new Universo(selectedPais.getPais()));
//
//            System.out.println("Cambiando el oceano");
//Especie especie = new Especie();
//especie.setNombre("especie "+ new Date());
//Oceano oceano = new Oceano("pacifico",
//  "Oceano  "+new Date());
//especie.setOceano(oceano);
////planeta.getEspecie().get(0).setOceano(oceano);
//planeta.getEspecie().add(especie);
//
//            System.out.println("---Oceano a cambiar en especie es");
//            System.out.println("-->planeta.getEspecie().toString() [] ="+planeta.getEspecie().toString());

//planeta.getUniverso().remove(new Universo("ejecutado Sun Jan 01 21:15:42 EST 2023"));
/**
 * +
 */

//planeta.getUniverso().removeAll(planeta.getUniverso());
 /**
   * caso 1-2
   * Crea una nueva lista
   * Estatus: no probado
   */  

//                    new Universo("FEcha "+new Date()));
//    List<Universo> universoList = Arrays.asList(new Universo(selectedPais.getPais()),
//                    new Universo("FEcha "+new Date()));
           // planeta.setUniverso(universoList);
//        


/**
 * Actualiza el grupo
 */

//List<Grupo> grupoList = grupoRepository.findAll();
//planeta.setGrupo(grupoList.get(1));
//            if(planetaRepository.update(planeta)){
//                   FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Planeta Updated"));
//            }else{
//                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Planeta NOT Updated"));
//            }     
            
            
                 
//            
            System.out.println("[[[[[[[[[[[[[[[[[[[[[[[[[[]]]]]]]]]]]]]]]]]]]]]]]]]]]");
            System.out.println("****************--> Persona");
            Optional<Persona> optional = personaRepository.findByPk(5L);
            if (optional.isPresent()) {
                Persona persona = optional.get();
           
                persona.setPais(selectedPais);
                
                persona.getMusica().add(new Musica("bolero"));

                persona.getMusica().forEach(m -> {
                    System.out.println(""+m.getEstilo());
                });
                
                if (personaRepository.update(persona)) {
     
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Persona Updated"));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Persona No Updated"));
                   
                }
            } else {
 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No hay persona con ese id"));
            }
       }

        PrimeFaces.current().executeScript("PF('managePaisDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }
}
