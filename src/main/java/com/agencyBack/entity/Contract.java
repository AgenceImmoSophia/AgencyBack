package com.agencyBack.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.sql.Date;
@Entity
public class Contract extends Base {
	@Id
	private Long id;
	private float price;
	private Date date;
	@OneToOne
	private Good good;
	@OneToOne
	private EstateAgent estateAgent;
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
