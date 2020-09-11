package com.agencyBack.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
@Entity
public class Contract extends Base {
	
	// ATTRIBUTES
	@Id
	private Long id;
	private float price;
	private Date date;
	
	
	// CONSTRUCTOR
	public Contract() {
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
	

}
