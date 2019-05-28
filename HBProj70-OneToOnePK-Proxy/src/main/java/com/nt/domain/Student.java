package com.nt.domain;

public class Student {
	private int sid;
	private String name;
	private String address;
	private LibraryMembership libraryDetails;
	
	public Student() {
		System.out.println("Student:0-param constructor");
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LibraryMembership getLibraryDetails() {
		return libraryDetails;
	}
	public void setLibraryDetails(LibraryMembership libraryDetails) {
		this.libraryDetails = libraryDetails;
	}

}
