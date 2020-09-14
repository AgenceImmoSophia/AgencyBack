package com.agencyBack.entity;

import javax.persistence.*;
import java.io.Serializable;
@MappedSuperclass
public class User extends Base{
	
	//ATTRIBUTES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name ;
	private String phoneNumberPers;
	@OneToOne
	private Address address;
	
	
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
   
    
	
	
}
