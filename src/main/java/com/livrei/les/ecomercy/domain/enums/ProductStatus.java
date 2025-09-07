package com.livrei.les.ecomercy.domain.enums;

public enum ProductStatus {
	ACTIVE(1),
	INACTIVE(2);
	
	private int code;
	
	private ProductStatus(int code) {
		this.code = code;
	}
	public int getCode() {
		return code;
	}
	
	public static ProductStatus valueOf(int code) {
		for( ProductStatus value: ProductStatus.values()) {
			if(value.getCode()==code) {
				return value;
			}
			
		}
		throw new IllegalArgumentException("Invalid ProductStatus Code");
	}
}
