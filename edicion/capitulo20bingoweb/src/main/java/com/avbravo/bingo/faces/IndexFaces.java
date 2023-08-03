/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.avbravo.bingo.faces;

import com.avbravo.bingo.model.Numero;
import com.avbravo.bingo.repository.NumeroRepository;
import com.avbravo.jmoordbutils.JsfUtil;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author avbravo
 */
@Named
@ApplicationScoped
@Data
public class IndexFaces implements Serializable{
    private static final long serialVersionUID = 1L;
    
      @Inject
    NumeroRepository numeroRepository;
      
        private List<Numero> numeroList = new ArrayList<>();
    /**
     * Creates a new instance of IndexFaces
     */
    public IndexFaces() {
    }
    
        // <editor-fold defaultstate="collapsed" desc=" init">
    @PostConstruct
    public void init() {
        findAll();

    }
// </editor-fold>
    
    
     public String findAll() {
        numeroList = numeroRepository.findAll();
        //    JsfUtil.successMessage("Tiene " + numeroList.size() + " Jugados");
        return "";
    }
    
    public String hello(){
        JsfUtil.warningMessage("Hola Mundo");
        System.out.println("llego al Hello.....");
        return "";
    }
    
    public String goBingo(){
        create();
        return "bingo.xhtml";
    }
    private Integer progress1;
    private Integer progress2;

    public void longRunning() throws InterruptedException {
        setProgress2(0);
        Integer k = getProgress2();
        while (k == null || k < 100) {
            k = updateProgress(k);
            setProgress2(k);
            Thread.sleep(500);
        }
    }

    private static Integer updateProgress(Integer progress) {
        if (progress == null) {
            progress = 0;
        }
        else {
            progress = progress + (int) (Math.random() * 35);

            if (progress > 100) {
                progress = 100;
            }
        }

        return progress;
    }

    public void onComplete() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Progress Completed"));
    }

    public void cancel() {
        progress1 = null;
        progress2 = null;
    }

    public Integer getProgress1() {
        progress1 = updateProgress(progress1);
        return progress1;
    }

    public Integer getProgress2() {
        return progress2;
    }

    public void setProgress1(Integer progress1) {
        this.progress1 = progress1;
    }

    public void setProgress2(Integer progress2) {
        this.progress2 = progress2;
    }
    
    public String create(){
        try {
            
            Numero aloe = new Numero("aloe",1, "aloe.png", "no");
            Numero anis = new Numero("anis",18, "anis.png", "no");
            Numero azahar = new Numero("azahar",6, "azahar.png", "no");
           
            Numero canela = new Numero("canela",15, "canela.png", "no");
            Numero clavel = new Numero("clavel",12, "clavel.png", "no");
            Numero crizantemo = new Numero("crizantemo",3, "crizantemo.png", "no");
            Numero hojadelimon = new Numero("hojadelimon",8, "hojadelimon.png", "no");
            Numero jazmin = new Numero("jazmin",9, "jazmin.png", "no");
            Numero jengibre= new Numero("jengibre",2, "jengibre.png", "no");
            Numero lavanda= new Numero("lavanda",11, "lavanda.png", "no");
            Numero limon= new Numero("limon",16, "limon.png", "no");
            Numero lirio= new Numero("lirio",13, "lirio.png", "no");
            Numero manzanilla= new Numero("manzanilla",10, "manzanilla.png", "no");
            Numero margarita= new Numero("margarita",17, "margarita.png", "no");
            Numero menta= new Numero("menta",7, "menta.png", "no");
            Numero rosa= new Numero("rosa",4, "rosa.png", "no");
            Numero rosemary= new Numero("rosemary",14, "rosemary.png", "no");
            Numero valeriana= new Numero("valeriana",5, "valeriana.png", "no");
            

         numeroRepository.save(aloe);
         numeroRepository.save(anis);
         numeroRepository.save(azahar);
         //c
         numeroRepository.save(canela);
         numeroRepository.save(clavel);
         numeroRepository.save(crizantemo);
         numeroRepository.save(hojadelimon);
         numeroRepository.save(jazmin);
         numeroRepository.save(jengibre);
         numeroRepository.save(lavanda);
         numeroRepository.save(limon);
         numeroRepository.save(lirio);
         numeroRepository.save(manzanilla);
         numeroRepository.save(margarita);
         numeroRepository.save(menta);
         numeroRepository.save(rosa);
         numeroRepository.save(rosemary);
         numeroRepository.save(valeriana);
         
         
         


        } catch (Exception e) {
             JsfUtil.errorMessage("Error "+e.getLocalizedMessage());
        }
        return "";
    }
    public String reiniciar(){
        try {
            numeroRepository.reiniciar();
            create();
//              numeroList = numeroRepository.findAll();
         JsfUtil.successMessage("Se reinicio los numeros");
         
         


        } catch (Exception e) {
             JsfUtil.errorMessage("Error "+e.getLocalizedMessage());
        }
        return "";
    }
}
