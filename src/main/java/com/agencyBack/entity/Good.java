package com.agencyBack.entity;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "goods")
public class Good extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameOfGood;
    private TypeOfGood typeOfGood;
    @JsonBackReference("OwnerToGood")
    //@JsonBackReference
    @ManyToOne
    private Owner owner;
    private Float price;
    @OneToOne
    private Address address;
    private String code;
    private Float area;
    private String description;
    private Status status;
    private Date dateAdded;
    private Date dateAvailability;
    private Float revenueCadastral;
    @JsonManagedReference("GoodToVisit")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Visit> clientVisit = new ArrayList<Visit>();
    @JsonManagedReference("GoodToContract")
    @OneToOne(cascade = CascadeType.ALL)
    private Contract contract;
    private Float deposit;
    private Float charges;
    private Boolean isFurnished;
    private String state;

    public Good(){
    }


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfGood() {
        return nameOfGood;
    }

    public void setNameOfGood(String nameOfGood) {
        this.nameOfGood = nameOfGood;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDateAvailability() {
        return dateAvailability;
    }

    public void setDateAvailability(Date dateAvailability) {
        this.dateAvailability = dateAvailability;
    }

    public Float getRevenueCadastral() {
        return revenueCadastral;
    }

    public void setRevenueCadastral(Float revenueCadastral) {
        this.revenueCadastral = revenueCadastral;
    }

    //@JsonIgnore
    public List<Visit> getClientVisit() {
        return clientVisit;
    }


    public void setClientVisit(List<Visit> clientVisit) {
        this.clientVisit = clientVisit;
    }

    //@JsonIgnore
    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Float getDeposit() {
        return deposit;
    }

    public void setDeposit(Float deposit) {
        this.deposit = deposit;
    }

    public Float getCharges() {
        return charges;
    }

    public void setCharges(Float charges) {
        this.charges = charges;
    }

    public Boolean getFurnished() {
        return isFurnished;
    }

    public void setFurnished(Boolean furnished) {
        isFurnished = furnished;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

	public TypeOfGood getTypeOfGood() {
		return typeOfGood;
	}

	public void setTypeOfGood(TypeOfGood typeOfGood) {
		this.typeOfGood = typeOfGood;
	}

	@Override
    public boolean equals(final Object obj)
    {
        if ( obj == null || !(obj instanceof Good) ) 
            return false;

        Good good = (Good) obj;
        
        if (!good.id.equals(this.id)) 
        	return false;

        return true;
    }

}
