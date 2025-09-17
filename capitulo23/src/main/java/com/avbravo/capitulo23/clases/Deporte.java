/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.capitulo23.clases;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.annotation.builder.CoreBuilderProperty;

/**
 *
 * @author avbravo
 */
@Entity
public class Deporte {

    @Id
    private Long iddeporte;
    @Column
    private String name;
    @Column
    private String grupo;

    public Deporte() {
    }

    public Deporte(Long iddeporte, String name) {
        this.iddeporte = iddeporte;
        this.name = name;
    }

    public Long getIddeporte() {
        return iddeporte;
    }

    @CoreBuilderProperty
    public void setIddeporte(Long iddeporte) {
        this.iddeporte = iddeporte;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

}
