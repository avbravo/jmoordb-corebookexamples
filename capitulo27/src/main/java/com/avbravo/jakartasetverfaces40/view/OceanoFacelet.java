/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.avbravo.jakartasetverfaces40.view;

import com.avbravo.jakartasetverfaces40.model.Oceano;
import jakarta.el.MethodExpression;
import jakarta.el.ValueExpression;
import static jakarta.faces.application.StateManager.IS_BUILDING_INITIAL_STATE;

import java.io.IOException;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.annotation.View;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIOutput;
import jakarta.faces.component.UIParameter;
import jakarta.faces.component.UISelectItem;
import jakarta.faces.component.html.*;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.IntegerConverter;
import jakarta.faces.view.facelets.Facelet;
import java.util.Arrays;
import java.util.Date;
import org.primefaces.PrimeFaces;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.clock.Clock;
import org.primefaces.component.datatable.DataTable;
import static org.primefaces.component.focus.FocusBase.PropertyKeys.context;
import org.primefaces.component.spinner.Spinner;

/**
 *
 * @author avbravo
 */
@View("/oceano.xhtml")
@ApplicationScoped
public class OceanoFacelet extends Facelet {

    List<Oceano> list = Arrays.asList(new Oceano("pac", "Pacifico"), new Oceano("at", "Atlantico"));
    private HtmlPanelGroup editableDataTableGroup; // Placeholder.

    public List<Oceano> getList() {
        return list;
    }

    public void setList(List<Oceano> list) {
        this.list = list;
    }

    @Override
    public void apply(FacesContext facesContext, UIComponent root) throws IOException {
        if (!facesContext.getAttributes().containsKey(IS_BUILDING_INITIAL_STATE)) {
            return;
        }

        ComponentBuilder components = new ComponentBuilder(facesContext);
        List<UIComponent> rootChildren = root.getChildren();

        UIOutput output = new UIOutput();

        output.setValue("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
        rootChildren.add(output);
        
        //
         UIOutput output2 = new UIOutput();

        output2.setValue("<h:outputStylesheet library=\"webjars\" name=\"primeflex/3.0.1/primeflex.min.css\" />");
        rootChildren.add(output2);
                
        HtmlBody body = components.create(HtmlBody.COMPONENT_TYPE);
        rootChildren.add(body);
        /**
         * Form
         */
        HtmlForm form = components.create(HtmlForm.COMPONENT_TYPE);
        form.setId("form");
        body.getChildren().add(form);
        
        /*
        
        */
         
        
        /**
         * 
         */

        HtmlOutputLabel label = components.create(HtmlOutputLabel.COMPONENT_TYPE);
        label.setValue("Enter your name");
        form.getChildren().add(label);

        HtmlInputText message = components.create(HtmlInputText.COMPONENT_TYPE);
        message.setId("message");
        form.getChildren().add(message);

        HtmlOutputText text = components.create(HtmlOutputText.COMPONENT_TYPE);
        form.getChildren().add(text);

        /**
         * CommandButton
         */
        HtmlCommandButton actionButton = components.create(HtmlCommandButton.COMPONENT_TYPE);
        actionButton.setId("button");
        actionButton.addActionListener(e -> text.setValue("Hi " + message.getValue()));
        actionButton.setValue("Do action");
        form.getChildren().add(actionButton);
        /**
         * Datatable
         */
//        HtmlDataTable dataTable = new HtmlDataTable();
//        // Get amount of columns.
//       
//        int columns = ((List) list.get(0)).size();
//
//        // Set columns.
//        for (int i = 0; i < columns; i++) {
//
//            // Set header (optional).
//            UIOutput header = new UIOutput();
//            header.setValue("idoceano");
//            
//
//            // Set output.
//            UIOutput outputColumn = new UIOutput();
//            ValueBinding myItem
//                    = FacesContext
//                            .getCurrentInstance()
//                            .getApplication()
//                            .createValueBinding("#{myItem[" + i + "]}");
//            outputColumn.setValueBinding("value", myItem);
//
//            // Set column.
//            UIColumn column = new UIColumn();
//            column.setHeader(header);
//            column.getChildren().add(outputColumn);
//
//            // Add column.
//          dataTable.getChildren().add(column);
//        }
//form.getChildren().add(dataTable);

        /**
         * HtmlDataTable
         *
         */
// Create <h:dataTable value="#{myBean.dataList}" var="dataItem">.
        HtmlDataTable editableDataTable = new HtmlDataTable();
        editableDataTable.setValueExpression("value",
                createValueExpression("#{DemoFacelet.list}", List.class));
        editableDataTable.setVar("dataItem");

        // Create <h:column> for 'ID' column.
        HtmlColumn idColumn = new HtmlColumn();
        editableDataTable.getChildren().add(idColumn);

        // Create <h:outputText value="ID"> for <f:facet name="header"> of 'ID' column.
        HtmlOutputText idHeader = new HtmlOutputText();
        idHeader.setValue("ID");
        idColumn.setHeader(idHeader);

        // Create <h:outputText value="#{dataItem.id}"> for the body of 'ID' column.
        HtmlOutputText idOutput = new HtmlOutputText();
        idOutput.setValueExpression("value",
                createValueExpression("#{dataItem.idoceano}", String.class));
        idColumn.getChildren().add(idOutput);

        // Create <h:column> for 'Name' column.
        HtmlColumn nameColumn = new HtmlColumn();
        editableDataTable.getChildren().add(nameColumn);

        // Create <h:outputText value="Name"> for <f:facet name="header"> of 'Name' column.
        HtmlOutputText nameHeader = new HtmlOutputText();
        nameHeader.setValue("Name");
        nameColumn.setHeader(nameHeader);

        // Create <h:inputText id="name" value="#{dataItem.name}"> for the body of 'Name' column.
        HtmlInputText nameInput = new HtmlInputText();
        nameInput.setId("name"); // Custom ID is required in dynamic UIInput and UICommand.
        nameInput.setValueExpression("value",
                createValueExpression("#{dataItem.oceano}", String.class));
        nameColumn.getChildren().add(nameInput);
// Create <h:column> for 'Value' column.
        HtmlColumn valueColumn = new HtmlColumn();
        editableDataTable.getChildren().add(valueColumn);

        //   Create <h:outputText value="Value"> for <f:facet name="header"> of 'Value' column.
        HtmlOutputText valueHeader = new HtmlOutputText();
        valueHeader.setValue("Value");
        valueColumn.setHeader(valueHeader);

        // Create <h:inputText id="value" value="#{dataItem.value}"> for the body of 'Value' column.
        HtmlInputText valueInput = new HtmlInputText();
        valueInput.setId("value"); // Custom ID is required in dynamic UIInput and UICommand.
        valueInput.setValueExpression("value",
                createValueExpression("#{dataItem.oceano}", String.class));
        valueColumn.getChildren().add(valueInput);

        // Add the datatable to <h:panelGroup binding="#{myBean.editableDataTableGroup}">.
        editableDataTableGroup = new HtmlPanelGroup();
        editableDataTableGroup.getChildren().add(editableDataTable);

        // Create <h:outputText value="<br/>" escape="false"> and add to <h:panelGroup
        // binding="#{myBean.editableDataTableGroup}">.
        HtmlOutputText lineBreak = new HtmlOutputText();
        lineBreak.setValue("<br/>");
        lineBreak.setEscape(false); // Don't escape HTML.
        editableDataTableGroup.getChildren().add(lineBreak);

        // Create <h:commandButton id="save" value="Save" action="#{myBean.saveDataList}">
        // and add to <h:panelGroup binding="#{myBean.editableDataTableGroup}">.
        HtmlCommandButton saveButton = new HtmlCommandButton();
        saveButton.setId("save"); // Custom ID is required in dynamic UIInput and UICommand.
        saveButton.setValue("Save");
        saveButton.setActionExpression(
                createActionExpression("#{myBean.saveDataList}", String.class));
        editableDataTableGroup.getChildren().add(saveButton);
        form.getChildren().add(editableDataTable);
        /**
         * Otro datatable
         */
//HtmlDataTable data;
//    HtmlOutputText output0;
//    ArrayList<String> hobbits = new ArrayList<String>();
//    hobbits.add("bilbo");
//    hobbits.add("frodo");
//    hobbits.add("merry");
//    hobbits.add("pippin");
//    hobbits.add("lumpy");
//    ListDataModel dataModel = new ListDataModel(hobbits);
//    panel = new UINamingContainer();
//    panel.setId(panelId);
//    form.getChildren().add(panel);
//    input0 = new HtmlInputText();
//    input0.setId("input0");
//    panel.getChildren().add(input0);
//    input1 = new HtmlInputText();
//    input1.setId("input1");
//    panel.getChildren().add(input1);
//    data = new HtmlDataTable();
//    data.setId("data");
//    panel.getChildren().add(data);
//    data.setValue(dataModel);
//    data.setVar("hobbitName");
//    String dataId = data.getClientId();
//  HtmlColumn  column0 = new HtmlColumn();
//   column0.setId("column0");
//    data.getChildren().add(column0);
//    output0 = new HtmlOutputText();
//    output0.setId("output0");
//    output0.setValue(getFacesContext().getApplication().getExpressionFactory().createValueExpression(getFacesContext().getELContext(), "#{hobbitName}", String.class));
//    column0.getChildren().add(output0);
//  HtmlCommandButton  button0 = new HtmlCommandButton();
//    button0.setId("button0");
//    panel.getChildren().add(button0);
//  HtmlCommandButton  button1 = new HtmlCommandButton();
//    button1.setId("button1");
//    panel.getChildren().add(button1);
        /**
         * HtmlPanelGrid
         */
        HtmlPanelGrid htmlPanelGrid = new HtmlPanelGrid();
// Aplica los css
        // htmlPanelGrid.setStyleClass(jsfContext.resolveStyleClass(JsfStyleClasses.FORM_LAYOUT_TABLE));
        htmlPanelGrid.setColumns(2);
        for (Oceano oceano : list) {
            HtmlOutputLabel label1 = components.create(HtmlOutputLabel.COMPONENT_TYPE);
            label1.setValue(oceano.getIdoceano());
            HtmlOutputLabel label2 = components.create(HtmlOutputLabel.COMPONENT_TYPE);
            label2.setValue(oceano.getOceano());
            form.getChildren().add(label1);
            htmlPanelGrid.getChildren().add(label1);
            htmlPanelGrid.getChildren().add(label2);
        }
        form.getChildren().add(htmlPanelGrid);
        /**
         * Menu
         */
        HtmlPanelGrid htmlPanelGridMenu = new HtmlPanelGrid();
        htmlPanelGridMenu.setColumns(2);

        htmlPanelGridMenu.getChildren().add(createLabel("HtmlOutcomeTargetLink"));

        HtmlPanelGroup menu = new HtmlPanelGroup();
        menu.setId("menu");
        HtmlOutputLink link = new HtmlOutputLink();
        link.setTitle("Link");

        // ... other components etc.
        menu.getChildren().add(link);
        htmlPanelGridMenu.getChildren().add(menu);

        /**
         * HtmlOutcomeTargetLink
         */
        htmlPanelGridMenu.getChildren().add(createLabel("HtmlOutcomeTargetLink"));
        HtmlOutcomeTargetLink link1 = new HtmlOutcomeTargetLink();
        link1.setValue("Edit");
        link1.setOutcome("edit");
        UIParameter param = new UIParameter();
        param.setName("id");
        param.setValue("500");
        link1.getChildren().add(param);
        htmlPanelGridMenu.getChildren().add(link1);

        /**
         * Spinner
         */
        htmlPanelGridMenu.getChildren().add(createLabel("Spinner Primefaces"));
//<h:panelGroup>
        HtmlPanelGroup panelMin = new HtmlPanelGroup();
        panelMin.setId("panelMin");
        //	<p:spinner id="minima" value="1" min="0" max="1000"/>
        Spinner spinner = new Spinner();
        spinner.setAccesskey("spinner");
        spinner.setValue(1);
        spinner.setMin(0);
         spinner.setSize(5);
        spinner.setMax(1000);
        spinner.setConverter(new IntegerConverter());
        panelMin.getChildren().add(spinner);

        htmlPanelGridMenu.getChildren().add(panelMin);
        /**
         * Agregarlo al form
         */
        

        
        /**
         * Calendar de primefaces
         */
         htmlPanelGridMenu.getChildren().add(createLabel("Calendar Primefaces"));
        Calendar calendar = new Calendar();
        calendar.setId("Calendar");
        calendar.setValue(new Date());
        htmlPanelGridMenu.getChildren().add(calendar);
        
        
        /**
         * Clock
         */
        htmlPanelGridMenu.getChildren().add(createLabel("Clock Primefaces"));
        Clock clock = new Clock();
        clock.setValue(new Date());
         if (clock.isSyncRequest()) {
    PrimeFaces.current().ajax().addCallbackParam("datetime", System.currentTimeMillis());
   
  }
          htmlPanelGridMenu.getChildren().add(clock);
          
          DataTable d = new DataTable();
          //d.
        /**
         * Agregarlo al form
         */
        form.getChildren().add(htmlPanelGridMenu);
        /**
         * ---------------------------------------------------------
         * SelectOneMenu Lo colocamos en un panel Grid
         * ----------------------------------
         */
//</h:selectOneMenu>
        HtmlPanelGrid htmlPanelGridSelectOneMenu = new HtmlPanelGrid();
        htmlPanelGridSelectOneMenu.setColumns(2);
// Aplica los css

        HtmlOutputLabel labelSelectOneMenu = components.create(HtmlOutputLabel.COMPONENT_TYPE);
        labelSelectOneMenu.setValue("Select OneMenu");

        htmlPanelGridSelectOneMenu.getChildren().add(labelSelectOneMenu);
        HtmlSelectOneMenu type_menu = new HtmlSelectOneMenu();
        type_menu.setId("type_menu");
        type_menu.setValue("text_many");

        UISelectItem type_item_1 = new UISelectItem();
        type_item_1.setItemLabel("Text (many lines)");
        type_item_1.setItemValue("text_many");
        type_item_1.setId("type_item_1");
        type_menu.getChildren().add(type_item_1);

        UISelectItem type_item_2 = new UISelectItem();
        type_item_2.setItemLabel("Date");
        type_item_2.setItemValue("date");
        type_item_2.setId("type_item_2");
        type_item_2.setId("type_item_2");
        type_menu.getChildren().add(type_item_2);

        UISelectItem type_item_3 = new UISelectItem();
        type_item_3.setItemLabel("Text (one line)");
        type_item_3.setItemValue("text_one");
        type_item_3.setId("type_item_3");
        type_menu.getChildren().add(type_item_3);

        UISelectItem type_item_4 = new UISelectItem();
        type_item_4.setItemLabel("Document");
        type_item_4.setItemValue("file");
        type_item_4.setId("type_item_4");
        type_menu.getChildren().add(type_item_4);

        UISelectItem type_item_5 = new UISelectItem();
        type_item_5.setItemLabel("Image");
        type_item_5.setItemValue("image");
        type_item_5.setId("type_item_5");
        type_menu.getChildren().add(type_item_5);
        htmlPanelGridSelectOneMenu.getChildren().add(type_menu);
        form.getChildren().add(htmlPanelGridSelectOneMenu);

        /**
         *
         *
         */
        output = new UIOutput();
        output.setValue("</html>");
        rootChildren.add(output);
    }

    private static class ComponentBuilder {

        FacesContext facesContext;

        ComponentBuilder(FacesContext facesContext) {
            this.facesContext = facesContext;
        }

        @SuppressWarnings("unchecked")
        <T> T create(String componentType) {
            return (T) facesContext.getApplication().createComponent(facesContext, componentType, null);
        }
    }

    private ValueExpression createValueExpression(String valueExpression, Class<?> valueType) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return facesContext.getApplication().getExpressionFactory().createValueExpression(
                facesContext.getELContext(), valueExpression, valueType);
    }

    private MethodExpression createActionExpression(String actionExpression, Class<?> returnType) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return facesContext.getApplication().getExpressionFactory().createMethodExpression(
                facesContext.getELContext(), actionExpression, returnType, new Class[0]);
    }

    private HtmlOutputLabel createLabel(String text) {
        HtmlOutputLabel label = new HtmlOutputLabel();
        label.setValue(text);
        return label;
    }
}
