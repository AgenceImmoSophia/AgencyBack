package com.agencyBack.entity;


import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.sql.Date;

@Entity
public class Visit extends Base{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date date;

	@JsonBackReference("GoodToVisit")
	@ManyToOne
	private Good good;
	@ManyToOne
	private EstateAgent estateAgent;
	@JsonBackReference
	@ManyToOne
	private Client client;

	public Visit() {

	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
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
