package com.nt.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
	private int userId;
	private String firstName;
	private String addrs;
	private Map<String,PhoneNumber> phones;
	
	public User() {
		System.out.println("User:0-param constructor");
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getAddrs() {
		return addrs;
	}

	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}

	public Map<String,PhoneNumber> getPhones() {
		return phones;
	}

	public void setPhones(Map<String,PhoneNumber> phones) {
		this.phones = phones;
	}

}
