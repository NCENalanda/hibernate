package com.nt.domain;

import java.util.Date;

public class Passport {
	private int ppNo;
	private String country;
	private Date dob;
	private Date expiryDate;
	private Person personDetails;
	
	public Passport() {
		System.out.println("Passport::0-param construtor");
	}
	
	public int getPpNo() {
		return ppNo;
	}
	public void setPpNo(int ppNo) {
		this.ppNo = ppNo;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public Person getPersonDetails() {
		return personDetails;
	}
	public void setPersonDetails(Person personDetails) {
		this.personDetails = personDetails;
	}
	
	

}
