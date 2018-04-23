package com.jin.project;

public enum ExceptionEnum {
	
	WRONG_PERMISSONS("66666");
	
	private final String value;
	
	String getValue() {
		return value;
	}
	private ExceptionEnum(String value) {
		this.value = value;// TODO Auto-generated constructor stub
	}
	public String toString() {
		return value;
		
	}

}
