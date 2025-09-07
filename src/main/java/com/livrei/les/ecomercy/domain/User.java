package com.livrei.les.ecomercy.domain;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "tb_user")
public class User extends EntityDomain {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	@Column(nullable = false, unique = true)
	private String email;
	private String password;
	
	@Column(length = 11, nullable = false, unique = true)
	private String cpf;
	private Instant birthDate;
	private String gender;
	private String ranking;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "phone_id")
	private Phone phone;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Address> addresses = new ArrayList<>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CreditCard> cards = new ArrayList<>();
	
	@OneToMany(mappedBy = "client")
	@JsonIgnore
	private List<Order> orders = new ArrayList<>();
	

	public User() {
		
	}
	public User(Long id, String name, String email, String password, String cpf, Instant birthDate, String gender, String ranking, Phone phone, List<CreditCard> cards, List<Address> addresses) {
		super(id);
		this.name = name;
		this.email = email;
		this.password = password;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.gender = gender;
		this.ranking = ranking;
		this.cards = cards;
		this.phone = phone;
		this.addresses = addresses;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Instant getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Instant birthDate) {
		this.birthDate = birthDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRanking() {
		return ranking;
	}
	public void setRanking(String ranking) {
		this.ranking = ranking;
	}
	public List<CreditCard> getCards() {
		return cards;
	}
	public void setCards(List<CreditCard> cards) {
		this.cards = cards;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	
}
