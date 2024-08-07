/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.capitulo19.model;

import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.annotation.enumerations.GenerationType;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author avbravo
 */
@Entity
public class Venta {

     @Id(strategy = GenerationType.AUTO)
    private Long idventa;

    @Column
    private Long idempresa;

    @Column
    private Date fechaHora;
    @Column
    private Double total;

    public Venta() {
    }

    public Venta(Long idventa, Long idempresa, Date fechaHora, Double total) {
        this.idventa = idventa;
        this.idempresa = idempresa;
        this.fechaHora = fechaHora;
        this.total = total;
    }

    
    
    public Long getIdventa() {
        return idventa;
    }

    public void setIdventa(Long idventa) {
        this.idventa = idventa;
    }

    public Long getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Long idempresa) {
        this.idempresa = idempresa;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.idventa);
        hash = 79 * hash + Objects.hashCode(this.idempresa);
        hash = 79 * hash + Objects.hashCode(this.fechaHora);
        hash = 79 * hash + Objects.hashCode(this.total);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Venta other = (Venta) obj;
        if (!Objects.equals(this.idventa, other.idventa)) {
            return false;
        }
        if (!Objects.equals(this.idempresa, other.idempresa)) {
            return false;
        }
        if (!Objects.equals(this.fechaHora, other.fechaHora)) {
            return false;
        }
        return Objects.equals(this.total, other.total);
    }

    @Override
    public String toString() {
        return "Venta{" + "idventa=" + idventa + ", idempresa=" + idempresa + ", fechaHora=" + fechaHora + ", total=" + total + '}';
    }

   
   

}
