package com.agencyBack.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.ArrayList;
import java.util.List;


@Entity
@DiscriminatorValue(value="Client")
@JsonTypeName("Client")
public class Client extends Users {

	//ATTRIBUTES
	@ElementCollection
	private List<String> listCode = new ArrayList<String>();
	@OneToMany
	private List<Good> listDesiredGood = new ArrayList<Good>();
	

	// CONSTRUCTORS
	public Client() {
		super();
	}

	//METHODS
	public List<String> getListCode() {
		return listCode;
	}

	public void setListCode(List<String> listCode) {
		this.listCode = listCode;
	}

	public List<Good> getListGood() {
		return listDesiredGood;
	}

	public void setListGood(List<Good> listGood) {
		this.listDesiredGood = listGood;
	}


}
