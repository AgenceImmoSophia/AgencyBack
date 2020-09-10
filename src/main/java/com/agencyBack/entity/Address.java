package com.agencyBack.entity;

import java.io.Serializable;

public class Address implements Serializable{
	
	private String city;
	private String zipcode;
	private String streetNber;
	private String street;
	private String country;
	
	public Address() {
		
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getStreetNber() {
		return streetNber;
	}

	public void setStreetNber(String streetNber) {
		this.streetNber = streetNber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
