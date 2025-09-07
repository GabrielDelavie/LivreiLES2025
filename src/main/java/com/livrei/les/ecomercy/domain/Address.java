package com.livrei.les.ecomercy.domain;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.livrei.les.ecomercy.domain.enums.AddressType;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Address extends EntityDomain{

	private static final long serialVersionUID = 1L;
	private String residenceType;
	private String name;
	private String type;
	private String number;
	private String neighborhood;
	private String city;
	private String state;
	private String country;
	private String cep;
	private String byname;
	private String observation;

    @ElementCollection(targetClass = AddressType.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(
    		name = "address_type", 
    		joinColumns = @JoinColumn(name = "address_id")
    		)
    @Column(name = "tipo")
    private Set<AddressType> tipos = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
	
	public Address() {}
	
	public Address(Long id,String residenceType, String name, String type, String number, String neighborhood, String city,
			String state, String country, String cep, String byname, String observation) {
		
		super(id);
		this.residenceType = residenceType;
		this.name = name;
		this.type = type;
		this.number = number;
		this.neighborhood = neighborhood;
		this.city = city;
		this.state = state;
		this.country = country;
		this.cep = cep;
		this.byname = byname;
		this.observation = observation;
		
		
	}
	public String getResidenceType() {
		return residenceType;
	}
	public void setResidenceType(String residenceType) {
		this.residenceType = residenceType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getByname() {
		return byname;
	}
	public void setByname(String byname) {
		this.byname = byname;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	
	
}
