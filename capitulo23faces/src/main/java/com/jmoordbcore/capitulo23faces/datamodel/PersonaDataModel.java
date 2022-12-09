/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo23faces.datamodel;

import com.jmoordbcore.capitulo23faces.model.Persona;
import jakarta.faces.model.ListDataModel;
import java.util.List;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author avbravo
 */
public class PersonaDataModel extends ListDataModel<Persona> implements SelectableDataModel<Persona> {

    public PersonaDataModel() {
    }

    public PersonaDataModel(List<Persona> data) {
        super(data);
    }

    @Override
    public Persona getRowData(String rowKey) {
        List<Persona> list = (List<Persona>) getWrappedData();

        for (Persona personao : list) {
            if (personao.getIdboleta().equals(rowKey)) {
                return personao;
            }
        }

        return null;
    }

    @Override
    public Object getRowKey(Persona persona) {
        return persona.getIdboleta();
    }
    
}
