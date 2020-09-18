package com.agencyBack.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.sql.Date;
@Entity
public class Contract extends Base {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private float price;
	private Date date;
	private TypeOfContract typeofcontract;
	@JsonBackReference("GoodToContract")
	@OneToOne
	private Good good;
	@OneToOne
	private EstateAgent estateAgent;
	@JsonBackReference
	@OneToOne
	private Client client;

	public Contract() {
	}

	public Contract(Long id, float price, Date date) {
		super();
		this.id = id;
		this.price = price;
		this.date = date;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
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
