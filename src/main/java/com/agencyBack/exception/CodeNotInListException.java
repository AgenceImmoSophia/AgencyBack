package com.agencyBack.exception;

public class CodeNotInListException extends Throwable {
	
	String message = "The code you are trying to remove from your list of codes is not in the list.";

    public CodeNotInListException() {
        super();
    }
    
    @Override
    public String getMessage() {
    	return this.message;
    }
}

