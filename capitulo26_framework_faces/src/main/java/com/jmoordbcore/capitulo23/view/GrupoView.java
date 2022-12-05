/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jmoordbcore.capitulo23.view;

import com.jmoordb.core.annotation.enumerations.JakartaSource;
import com.jmoordb.core.annotation.view.VForm;
import com.jmoordb.core.annotation.view.View;
import com.jmoordbcore.capitulo13.model.Grupo;
import com.jmoordbcore.capitulo23.view.components.VCommandButton;
import com.jmoordbcore.capitulo23.view.components.VHeader;
import com.jmoordbcore.capitulo23.view.components.VInputText;
import com.jmoordbcore.capitulo23.view.components.VLabel;
import com.jmoordbcore.capitulo23.view.components.VPanel;
import com.jmoordbcore.capitulo23.view.components.VROW;
import com.jmoordbcore.capitulo23.view.components.VTemplate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author avbravo
 */
@View(entity = Grupo.class, jakartaSource = JakartaSource.JAKARTA, generate = true)
public class GrupoView {

    @VHeader(title = "grupo", meta = "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>")
    @VTemplate(path = "/WEB-INF/template.xhtml")
    @VForm(name = "form1")
    public void vForm() {
        @VROW(position = 1, column = 0)
        VLabel label1 = new VLabel.Builder()
                .id("labelidgrupo")
                .value("idgrupo")
                .build();
        
        @VROW(position = 1,column = 1)
        VInputText inputTextIdGrupo = new VInputText.Builder()
                .id("inputTextidgrupo")
                .value("")
                .action("")
                .binding("#{gruooView.grupo.idgrupo}")
                .build();

        @VROW(position = 2,column = 0)
        VCommandButton commandButtonSave = new VCommandButton.Builder()
                .id("commandButtonSave")
                .value("Save")
                .action("#{grupoView.save(#{grupoView.gruo}})")
                .ajax("")
                .build();

    }
    
    @VHeader(title = "grupo", meta = "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>")
    @VTemplate(path = "/WEB-INF/template.xhtml")
    @VForm(name = "form2")
    public void vForm2() {
        

        
        VLabel label1 = new VLabel.Builder()
                .id("labelidgrupo")
                .value("idgrupo")
                .build();
        
        VInputText inputTextIdGrupo = new VInputText.Builder()
                .id("inputTextidgrupo")
                .value("")
                .action("")
                .binding("#{gruooView.grupo.idgrupo}")
                .build();

      
        VCommandButton commandButtonSave = new VCommandButton.Builder()
                .id("commandButtonSave")
                .value("Save")
                .action("#{grupoView.save(#{grupoView.gruo}})")
                .ajax("")
                .build();
        
        VPanel vPanel = new VPanel.Builder()
                .id("panel1")
                .columns(2)
                .vLabel(List.of(label1)) 
                .vInputText(List.of(inputTextIdGrupo)) 
                .vCommandButton(List.of(commandButtonSave))
                .build();

    }
}
