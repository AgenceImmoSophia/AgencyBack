package com.agencyBack.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue(value="Owner")
public class Owner extends Users {

	//ATTRIBUTES
	private String phoneNumberPro;

	@OneToMany
	private List<Good> listOwnGood = new ArrayList<Good>();

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
		return listOwnGood;
	}


	public void setListGood(List<Good> listGood) {
		this.listOwnGood = listGood;
	}	


}
