package com.agencyBack.entity;

import java.io.Serializable;
import java.sql.Date;

public class Good implements Serializable {
    private Long id;
    private String nameOfGood;
    private Owner owner;
    private Float price;
    private Address address;
    private String code;
    private Float area;
    private String description;
    private Status status;
    private Date dateAdded;
    private Date dateAvailability;
    private Float revenueCadastral;
    private List<Visit> clientVisit;
    private Contract contract;
    private Float deposit;
    private Float charges;
    private Boolean isFurnished;
    private String state;

    public Good(){}

    public Long getId() {
        return id;
    }

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

    public List<Visit> getClientVisit() {
        return clientVisit;
    }

    public void setClientVisit(List<Visit> clientVisit) {
        this.clientVisit = clientVisit;
    }

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
}