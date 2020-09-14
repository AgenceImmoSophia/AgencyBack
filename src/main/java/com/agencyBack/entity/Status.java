package com.agencyBack.entity;

public enum Status {
    TOSELL(1),
    TORENT(2),
    NOTAVAILABLE(3);

    private int value;


    Status(int i) {
        this.value = i;
    }

    public int getValue(){
        return value;
    }
}
