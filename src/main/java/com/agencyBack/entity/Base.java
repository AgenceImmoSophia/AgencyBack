package com.agencyBack.entity;

import java.io.Serializable;

public abstract class Base implements Serializable {

    // CONSTRUCTORS
    public Base() {
    }

    //METHODS
    public abstract Long getId();

    public abstract void setId(Long id);

}
