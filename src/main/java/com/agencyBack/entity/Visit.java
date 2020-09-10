package com.agencyBack.entity;

import java.io.Serializable;
import java.sql.Date;

public class Visit implements Serializable{
	
	private Date date;
	private Good good;
	private EstateAgent estateAgent;
	private Client client;
	
	public Visit() {
		
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Good getGood() {
		return good;
	}

	public void setGood(Good good) {
		this.good = good;
	}

	public EstateAgent getEstateAgent() {
		return estateAgent;
	}

	public void setEstateAgent(EstateAgent estateAgent) {
		this.estateAgent = estateAgent;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	

}
