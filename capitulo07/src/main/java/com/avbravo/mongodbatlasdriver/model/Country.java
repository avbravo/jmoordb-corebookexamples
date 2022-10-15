/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.mongodbatlasdriver.model;

import com.jmoordb.core.annotation.Column;
import javax.persistence.Id;

/**
 *
 * @author avbravo
 */
public class Country {
    @Id
    private String idcountry;
    @Column
    private String country;

    public Country() {
    }

    public Country(String idcountry, String country) {
        this.idcountry = idcountry;
        this.country = country;
    }

    public String getIdcountry() {
        return idcountry;
    }

    public void setIdcountry(String idcountry) {
        this.idcountry = idcountry;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
     @Override
    public boolean equals(Object object) {
        if (!(object instanceof Country)) {
            return false;
        }
        Country other = (Country) object;
        if ((this.idcountry == null && other.idcountry!= null) || (this.idcountry!= null && !this.idcountry.equals(other.idcountry))) {
            return false;
        }
        return true;
    }

  
}
