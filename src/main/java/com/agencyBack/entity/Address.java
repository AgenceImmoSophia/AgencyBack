package com.agencyBack.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address extends Base{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String city;
	private String zipcode;
	private String streetNber;
	private String street;
	private String country;
	
	public Address() {
		
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;

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
	
	
	@Override
    public boolean equals(final Object obj)
    {
        if ( obj == null || !(obj instanceof Address) ) 
            return false;

        Address otherAddress = (Address) obj;

        if (!otherAddress.country.equals(this.country)) 
        	return false;
        if (!otherAddress.city.equals(this.city))
        	return false;	
        if (!otherAddress.zipcode.equals(this.zipcode))
        	return false;	
        if (!otherAddress.street.equals(this.street))
        	return false;
    	if (!otherAddress.streetNber.equals(this.streetNber))  
    	return false;
        
        return true;
    }
    
}
