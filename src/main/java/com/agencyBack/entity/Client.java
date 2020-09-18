package com.agencyBack.entity;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
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
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
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

	public List<Good> getListDesiredGood() {
		return listDesiredGood;
	}

	public void setListDesiredGood(List<Good> listDesiredGood) {
		this.listDesiredGood = listDesiredGood;
	}


}
