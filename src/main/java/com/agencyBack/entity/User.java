package com.agencyBack.entity;

import java.io.Serializable;

public class User extends Base{
	
	//ATTRIBUTES 
	private Long id;
	private String name ;
	private String phoneNumberPers;
	
	
	// CONSTRUCTORS
    public User() {
    }
    
    //METHODS
	@Override
   	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
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
