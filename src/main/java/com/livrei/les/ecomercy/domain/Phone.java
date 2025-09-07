package com.livrei.les.ecomercy.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Phone extends EntityDomain{

	private static final long serialVersionUID = 1L;
	private String name;
	private String ddd;
	private String type;
	
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
    
	public Phone() {
		// TODO Auto-generated constructor stub
	}
	
	public Phone( String name, String ddd, String type) {
		this.name = name;
		this.ddd = ddd;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
