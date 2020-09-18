package com.agencyBack.exception;

public class GoodNotInListException extends Throwable {
	
	String message = "The good you are trying to remove from your list of goods isn't in the list.";
	
    public GoodNotInListException() {
        super();
    }
    
    @Override
    public String getMessage() {
    	return this.message;
    }
}

