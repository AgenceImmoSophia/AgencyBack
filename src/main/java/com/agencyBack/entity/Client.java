package com.agencyBack.entity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.ArrayList;
import java.util.List;


@Entity
@JsonTypeName("Client")
public class Client extends Users {

	//ATTRIBUTES
	@ElementCollection
	private List<String> listCode = new ArrayList<String>();
	@ManyToMany
	private List<Good> listDesiredGood = new ArrayList<Good>();


	// CONSTRUCTORS
	public Client() {
		super();
		this.role = "Client";
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
