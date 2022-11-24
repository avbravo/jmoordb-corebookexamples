package com.jmoordbcore.capitulo23.view.components;

public class VCommandButton {


    String id;
    String value;
    String ajax;
    String action;
    String update;

    public VCommandButton() {
    }

    public VCommandButton(String id, String value, String ajax, String action, String update) {
        this.id = id;
        this.value = value;
        this.ajax = ajax;
        this.action = action;
        this.update = update;
    }

    
    
    public String getAjax() {
        return ajax;
    }

    public void setAjax(String ajax) {
        this.ajax = ajax;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

 

    public String getBinding() {
        return ajax;
    }

    public void setBinding(String ajax) {
        this.ajax = ajax;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }


    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
     public static class Builder {

          String id;
    String value;
      String ajax;
    String action;
    
        String update;
        
        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder value(String value) {
            this.value = value;
            return this;
        }
        public Builder ajax(String ajax) {
            this.ajax = ajax;
            return this;
        }
        public Builder action(String action) {
            this.action = action;
            return this;
        }
        public Builder update(String update) {
            this.update = update;
            return this;
        }

       

        public VCommandButton build() {
            return new VCommandButton(id, value, ajax, action, update);

        }

    }

}
