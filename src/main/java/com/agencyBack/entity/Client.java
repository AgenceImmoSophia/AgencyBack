package com.agencyBack.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
public class Client extends User {

	//ATTRIBUTES
	private List<String> listCode;
	@OneToMany
	private List<Good> listGood;
	

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
		return listGood;
	}

	public void setListGood(List<Good> listGood) {
		this.listGood = listGood;
	}


}
