package com.agencyBack.exception;

public class GoodAlreadyInListException extends Throwable {
	
	String message = "The good you are trying to add to your list of goods is already in the list.";
	
    public GoodAlreadyInListException() {
        super();
    }
    
    @Override
    public String getMessage() {
    	return this.message;
    }
}
