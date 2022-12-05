package com.jmoordbcore.capitulo23.view.components;

public class VLabel {

    
    /**
     * 
            EntityField entityField = new EntityField.Builder()
                    .nameOfMethod(nameOfField)
                    .returnTypeValue(type)                    
                    .annotationType(AnnotationType.NONE)
                    .returnType(ProcessorUtil.convertToReturnTypeOfField(type))
                    .typeReferenced(TypeReferenced.REFERENCED)
                    
                    .build();
     * 
     */
    String id;
    String value;
   Integer order;

    public VLabel() {
    }

    public VLabel(String id, String value, Integer order) {
        this.id = id;
        this.value = value;
        this.order = order;
    }

    
    
    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
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
    Integer order;
        public Builder id(String id) {
            this.id = id;
            return this;
        }
        public Builder value(String value) {
            this.value = value;
            return this;
        }
        public Builder order(Integer order) {
            this.order = order;
            return this;
        }

       

        public VLabel build() {
            return new VLabel(id, value, order);

        }

    }

}
