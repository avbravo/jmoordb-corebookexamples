package com.nabenik.model;



import com.jmoordb.core.annotation.Column;
import com.jmoordb.core.annotation.Entity;
import com.jmoordb.core.annotation.Id;
import com.jmoordb.core.annotation.enumerations.AutogeneratedActive;
import com.jmoordb.core.annotation.enumerations.JakartaSource;
import java.io.Serializable;

@Entity()

public class Pet implements Serializable {

    @Id(autogeneratedActive = AutogeneratedActive.ON)
    private Long id;

    @Column
    private String name;

    @Column
    private String type;

    public Pet() {
    }

    public Pet(Long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
