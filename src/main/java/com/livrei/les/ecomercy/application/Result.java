package com.livrei.les.ecomercy.application;

import java.util.ArrayList;

import com.livrei.les.ecomercy.domain.EntityDomain;

public class Result {
	private String message;
	private ArrayList<EntityDomain> entidades;
	private String metodo;
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String msg) {
		this.message = msg;
	}
	
	public ArrayList<EntityDomain> getEntidades() {
		return entidades;
	}
	
	public void setEntidades(ArrayList<EntityDomain> entidades) {
		this.entidades = entidades;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

}
