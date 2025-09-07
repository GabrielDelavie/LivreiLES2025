package com.livrei.les.ecomercy.domain.enums;

public enum AddressType {
	CHARGE(1),
	DELIVERY(2);
	
	private int code;
	
	private AddressType(int code) {
		this.code = code;
	}
	public int getCode() {
		return code;
	}
	
	public static AddressType valueOf(int code) {
		for( AddressType value: AddressType.values()) {
			if(value.getCode()==code) {
				return value;
			}
			
		}
		throw new IllegalArgumentException("Invalid OrderStatus Code");
	}
}
