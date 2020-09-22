package com.agencyBack.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.ArrayList;
import java.util.List;

@Entity
@JsonTypeName("Owner")
public class Owner extends Users {

	//ATTRIBUTES
	private String phoneNumberPro;

	@JsonManagedReference("OwnerToGood")
	@OneToMany
	private List<Good> listOwnedGood = new ArrayList<Good>();

	// CONSTRUCTORS
	public Owner() {
		super();
		this.role = "Owner";
	}


	//METHODS
	public String getPhoneNumberPro() {
		return phoneNumberPro;
	}


	public void setPhoneNumberPro(String phoneNumberPro) {
		this.phoneNumberPro = phoneNumberPro;
	}



	public List<Good> getListOwnedGood() {
		return listOwnedGood;
	}


	public void setListOwnedGood(List<Good> listOwnedGood) {
		this.listOwnedGood = listOwnedGood;
	}	


}
