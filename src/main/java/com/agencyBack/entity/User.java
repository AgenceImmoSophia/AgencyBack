package com.agencyBack.entity;

import java.io.Serializable;

public class User implements Serializable{
	
	//ATTRIBUTES 
	private long id;
	private String name ;
	private String phoneNumberPers;
	
	
	// CONSTRUCTORS
    public User() {
    }
    
    //METHODS 
   	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumberPers() {
		return phoneNumberPers;
	}

	public void setPhoneNumberPers(String phoneNumberPers) {
		this.phoneNumberPers = phoneNumberPers;
	}

	
	
    
    
    
    
	
	
}
