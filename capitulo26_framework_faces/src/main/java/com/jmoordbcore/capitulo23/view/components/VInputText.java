package com.jmoordbcore.capitulo23.view.components;

public class VInputText {


    String id;
    String value;
    String binding;
    String action;

    public VInputText() {
    }

    public VInputText(String id, String value, String binding, String action) {
        this.id = id;
        this.value = value;
        this.binding = binding;
        this.action = action;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
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
      String binding;
    String action;
        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder value(String value) {
            this.value = value;
            return this;
        }
        public Builder binding(String binding) {
            this.binding = binding;
            return this;
        }
        public Builder action(String action) {
            this.action = action;
            return this;
        }

       

        public VInputText build() {
            return new VInputText(id, value, binding, action);

        }

    }

}
