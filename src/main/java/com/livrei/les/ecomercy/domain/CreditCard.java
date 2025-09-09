package com.livrei.les.ecomercy.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CreditCard extends EntityDomain{

	private static final long serialVersionUID = 1L;
	private String number;
	private String printedName;
	private String brand;
	private String securityCode;
	private String expiration;
	
    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client user;
    
	public CreditCard() {}
	
	public CreditCard(String number, String printedName, String brand, String securityCode, String expiration) {
		super();
		this.number = number;
		this.printedName = printedName;
		this.brand = brand;
		this.securityCode = securityCode;
		this.expiration = expiration;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPrintedName() {
		return printedName;
	}

	public void setPrintedName(String printedName) {
		this.printedName = printedName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getExpiration() {
		return expiration;
	}

	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	public Client getUser() {
		return user;
	}

	public void setUser(Client user) {
		this.user = user;
	}
	
	
	
	
	
}
