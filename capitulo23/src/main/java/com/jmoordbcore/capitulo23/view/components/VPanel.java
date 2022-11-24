package com.jmoordbcore.capitulo23.view.components;


import java.util.List;


public class VPanel {
    String id;
   Integer columns;
   List<VLabel> vLabel;
   List<VInputText> vInputText;
   List<VCommandButton> vCommandButton;

    public VPanel(String id, Integer columns, List<VLabel> vLabel, List<VInputText> vInputText, List<VCommandButton> vCommandButton) {
        this.id = id;
        this.columns = columns;
        this.vLabel = vLabel;
        this.vInputText = vInputText;
        this.vCommandButton = vCommandButton;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    

    public Integer getColumns() {
        return columns;
    }

    public void setColumns(Integer columns) {
        this.columns = columns;
    }

    public List<VLabel> getvLabel() {
        return vLabel;
    }

    public void setvLabel(List<VLabel> vLabel) {
        this.vLabel = vLabel;
    }

    public List<VInputText> getvInputText() {
        return vInputText;
    }

    public void setvInputText(List<VInputText> vInputText) {
        this.vInputText = vInputText;
    }

    public List<VCommandButton> getvCommandButton() {
        return vCommandButton;
    }

    public void setvCommandButton(List<VCommandButton> vCommandButton) {
        this.vCommandButton = vCommandButton;
    }
    
  public static class Builder {
      String id;
   Integer columns;
   List<VLabel> vLabel;
   List<VInputText> vInputText;
   List<VCommandButton> vCommandButton;
    public Builder id(String id) {
            this.id = id;
            return this;
        }
    public Builder columns( Integer columns) {
            this.columns = columns;
            return this;
        }
    public Builder vLabel( List<VLabel> vLabel) {
            this.vLabel =vLabel;
            return this;
        }
    
    public Builder vInputText( List<VInputText> vInputText) {
            this.vInputText =vInputText;
            return this;
        }
    
    public Builder vCommandButton  (List<VCommandButton> vCommandButton) {
            this.vCommandButton =vCommandButton;
            return this;
        }
    
     public VPanel build() {
            return new VPanel(id, columns, vLabel, vInputText, vCommandButton);

        }
  }
}
