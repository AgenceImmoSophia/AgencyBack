package com.agencyBack.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.io.Serializable;

@Entity
@DiscriminatorValue(value="EstateAgent")
@JsonTypeName("EstateAgent")
public class EstateAgent extends Users {

	//ATTRIBUTES
	private String username;
	private String password;

	// CONSTRUCTORS
	public EstateAgent() {
		super();
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
