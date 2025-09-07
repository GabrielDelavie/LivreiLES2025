package com.livrei.les.ecomercy.domain;

public class Dimensions extends EntityDomain {

	private static final long serialVersionUID = 1L;
	private double height;
	private double width;
	private double length;

	public Dimensions() {
		// TODO Auto-generated constructor stub
	}

	public Dimensions(double height, double width, double length) {
		super();
		this.height = height;
		this.width = width;
		this.length = length;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
	
	
}
