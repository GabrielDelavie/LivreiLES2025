package com.livrei.les.ecomercy.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Phone extends EntityDomain{

	private static final long serialVersionUID = 1L;
	private String number;
	private String ddd;
	private String type;
	
    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client user;
    
	public Phone() {
		// TODO Auto-generated constructor stub
	}
	
	public Phone( String number, String ddd, String type) {
		this.number = number;
		this.ddd = ddd;
		this.type = type;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String name) {
		this.number = name;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	
}
