package com.agencyBack.exception;

public class CodeAlreadyInListException extends Throwable {
	
	String message = "The code you are trying to add to your list of codes is already in the list.";

    public CodeAlreadyInListException() {
        super();
    }
    
    @Override
    public String getMessage() {
    	return this.message;
    }
}
