package com.agencyBack.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("EstateAgent")
public class EstateAgent extends Users {

	//ATTRIBUTES
	private String username;
	private String password;

	// CONSTRUCTORS
	public EstateAgent() {
		super();
		this.role = "EstateAgent";
	}

	//METHODS
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}




}
