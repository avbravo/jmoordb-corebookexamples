/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.avbravo.bingo.repository;

import com.avbravo.bingo.model.Numero;
import com.avbravo.jmoordbutils.JsfUtil;
import jakarta.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author avbravo
 */
@ApplicationScoped
public class NumeroRepository implements Serializable {

    private List<Numero> numeroList = new ArrayList<>();

    public NumeroRepository() {
    }

    public List<Numero> getNumeroList() {
        return numeroList;
    }

    public void setNumeroList(List<Numero> numeroList) {
        this.numeroList = numeroList;
    }

    public Boolean save(Numero numero) {
        Boolean saved = Boolean.FALSE;
        try {
            if (numeroList.isEmpty()) {
                numeroList.add(numero);
                saved = Boolean.TRUE;
            } else {
                Boolean found = Boolean.FALSE;
                for (Numero n : numeroList) {
                    if (n.getIdnumero().equals(numero.getIdnumero())) {
                        found = Boolean.TRUE;
                        break;
                    }

                }
                if (found) {
                    return saved;
                }
                numeroList.add(numero);
                saved = Boolean.TRUE;
            }
        } catch (Exception e) {
        }
        return saved;
    }
    
    public List<Numero> findByJugado(String jugado){
        List<Numero> list = new ArrayList<>();
        try {
            for(Numero n:numeroList){
                if(n.getJugado().equals(jugado)){
                    list.add(n);
                }
            }
        } catch (Exception e) {
            JsfUtil.errorMessage("findByJugado() "+e.getLocalizedMessage());
        }
        return list;
    }
    public Numero findByNumero(Integer numero){
       Numero numeroVar = new Numero();
        try {
            for(Numero n:numeroList){
                if(n.getNumero().equals(numero)){
                    numeroVar = n;
                    break;
                }
            }
        } catch (Exception e) {
            JsfUtil.errorMessage("findByJugado() "+e.getLocalizedMessage());
        }
        return numeroVar;
    }
    public Integer positionOfNumero(Integer numero){
       Integer position =0;
        try {
            Integer i=0;
            for(Numero n:numeroList){
                if(n.getNumero().equals(numero)){
                    position=i;
                    break;
                }
                i++;
            }
        } catch (Exception e) {
            JsfUtil.errorMessage("findByJugado() "+e.getLocalizedMessage());
        }
        return position;
    }
    public Integer countByJugado(String jugado){
        List<Numero> list = new ArrayList<>();
        try {
            for(Numero n:numeroList){
                if(n.getJugado().equals(jugado)){
                    list.add(n);
                }
            }
        } catch (Exception e) {
            JsfUtil.errorMessage("findByJugado() "+e.getLocalizedMessage());
        }
        return list.size();
    }
    public List<Numero> findAll(){
        
        return numeroList;
    }
    
    public void reiniciar(){
        numeroList = new ArrayList<>();
    }
}
