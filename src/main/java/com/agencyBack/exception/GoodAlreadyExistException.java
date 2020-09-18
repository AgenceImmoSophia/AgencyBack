package com.agencyBack.exception;

public class GoodAlreadyExistException extends Throwable {
	
	String message = "The good you are trying to add to your list of goods is already in the list";

	public GoodAlreadyExistException(String message) {
		super(message);
	}
}

