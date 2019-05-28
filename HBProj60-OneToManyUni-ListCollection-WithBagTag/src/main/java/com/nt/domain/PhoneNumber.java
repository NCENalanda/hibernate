package com.nt.domain;

public class PhoneNumber {
	private long phone;
	private String numberType;
	private String provider;
	
	public PhoneNumber() {
		System.out.println("PhoneNumber:0-param constructor");
	}
	
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getNumberType() {
		return numberType;
	}
	public void setNumberType(String numberType) {
		this.numberType = numberType;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	

}
