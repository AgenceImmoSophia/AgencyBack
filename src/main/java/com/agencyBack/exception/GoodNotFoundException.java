package com.agencyBack.exception;

import javassist.NotFoundException;

public class GoodNotFoundException extends NotFoundException {
    public GoodNotFoundException(String message) {
        super(message);
    }
}

