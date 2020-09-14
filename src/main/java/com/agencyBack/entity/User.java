package com.agencyBack.entity;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

//@MappedSuperclass

@JsonTypeInfo(
		  use = JsonTypeInfo.Id.NAME,
		  include = JsonTypeInfo.As.PROPERTY, property = "type"
		)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Owner.class, name = "owner"),
    @JsonSubTypes.Type(value = Client.class, name = "client"),
    @JsonSubTypes.Type(value = EstateAgent.class, name = "estateAgent")
})
public class User extends Base{
	
	//ATTRIBUTES
	@Id
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
