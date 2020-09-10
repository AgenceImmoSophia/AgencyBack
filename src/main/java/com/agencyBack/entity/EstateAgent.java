package com.agencyBack.entity;

import java.io.Serializable;

public class EstateAgent extends User {
	
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
