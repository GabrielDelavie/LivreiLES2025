package com.livrei.les.ecomercy.domain;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_payment")
public class Payment extends EntityDomain{

	private static final long serialVersionUID = 1L;
	private Instant moment;
	
	@OneToOne
	@MapsId
	private Order order;
	
	public Payment() {}

	public Payment(Long id,Instant moment, Order order) {
		super(id);
		this.moment = moment;
		this.order = order;
		// TODO Auto-generated constructor stub
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	@JsonIgnore
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	
}
