package com.agencyBack.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import java.io.Serializable;
@MappedSuperclass
public class User extends Base{
	
	//ATTRIBUTES
	@Id
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
