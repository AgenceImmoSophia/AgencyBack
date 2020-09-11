package com.agencyBack.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;
@Entity
public class Owner extends User {

	//ATTRIBUTES
	private String phoneNumberPro;

	@OneToMany
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
