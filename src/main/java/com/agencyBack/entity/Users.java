package com.agencyBack.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import org.springframework.context.annotation.Primary;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = As.EXISTING_PROPERTY, visible = true, property = "role")
@JsonSubTypes({
    @JsonSubTypes.Type(name = "Client", value = Client.class),
    @JsonSubTypes.Type(name = "Owner", value = Owner.class),
    @JsonSubTypes.Type(name = "EstateAgent", value = EstateAgent.class)
})
public class Users extends Base{
	
	//ATTRIBUTES
	protected String role;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name ;
	private String phoneNumberPers;
	@OneToOne
	private Address address;

	// CONSTRUCTORS
    public Users() {
    }
    
    //METHODS
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
    
	@Override
   	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumberPers() {
		return phoneNumberPers;
	}

	public void setPhoneNumberPers(String phoneNumberPers) {
		this.phoneNumberPers = phoneNumberPers;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
   
	@Override
    public boolean equals(final Object obj)
    {
        if ( obj == null || !(obj instanceof Good) ) 
            return false;

        Users user = (Users) obj;
        
        if (!user.id.equals(this.id)) 
        	return false;

        return true;
    }
	
	
}
