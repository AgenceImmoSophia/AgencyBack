package com.agencyBack.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;
@Entity
public class Contract extends Base {
	@Id
	private Long id;
	private float price;
	private Date date;
	
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
	

}
