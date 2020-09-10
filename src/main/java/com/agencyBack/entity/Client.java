package com.agencyBack.entity;

import java.io.Serializable;
import java.util.List;

public class Client extends User {
	
	//ATTRIBUTES 
	private List<String> listCode;
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
