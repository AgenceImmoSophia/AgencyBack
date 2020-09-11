package com.agencyBack.entity;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class Base implements Serializable {

    // CONSTRUCTORS
    public Base() {
    }

    //METHODS
    public abstract Long getId();

    public abstract void setId(Long id);

}
