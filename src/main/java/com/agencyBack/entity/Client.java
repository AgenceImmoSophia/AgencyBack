package com.agencyBack.entity;

import java.io.Serializable;

public class Client extends User implements Serializable {
	
	//ATTRIBUTES 
	private List<Good.code> listCode;
	private List<Good> listGood;
	
	// CONSTRUCTORS
	public Client() {
		super();
	}

	//METHODS
	public List<Good.code> getListCode() {
		return listCode;
	}

	public void setListCode(List<Good.code> listCode) {
		this.listCode = listCode;
	}

	public List<Good> getListGood() {
		return listGood;
	}

	public void setListGood(List<Good> listGood) {
		this.listGood = listGood;
	}

		
	
	
}
