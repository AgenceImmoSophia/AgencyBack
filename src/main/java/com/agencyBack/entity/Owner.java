package com.agencyBack.entity;

import java.io.Serializable;
import java.util.List;

public class Owner extends User implements Serializable {
	
	//ATTRIBUTES 
	private String phoneNumberPro;
	private List<Good> listGood;
			
			
	// CONSTRUCTORS
	public Owner() {
		super();
	}

	
	//METHODS
	public String getPhoneNumberPro() {
		return phoneNumberPro;
	}


	public void setPhoneNumberPro(String phoneNumberPro) {
		this.phoneNumberPro = phoneNumberPro;
	}


	public List<Good> getListGood() {
		return listGood;
	}


	public void setListGood(List<Good> listGood) {
		this.listGood = listGood;
	}
	
	
	

}
