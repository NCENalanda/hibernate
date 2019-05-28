//EmpDetails.java (POJO class/BO class/Domain class/Entity class)
package com.nt.domain;

public class EmpDetails {
	private int no;
	private String fname;
	private String lname;
	private String mail;
	
	public EmpDetails() {
		System.out.println("EmpDetails::0-param constructor");
	}

	public int getNo() {
		System.out.println("EmpDetails:getNo()");
		return no;
	}

	public void setNo(int no) {
		System.out.println("EmpDetails:setNo(-)");
		this.no = no;
	}

	public String getFname() {
		System.out.println("EmpDetails:getFname()");
		return fname;
	}

	public void setFname(String fname) {
		System.out.println("EmpDetails:setFname(-)");
		this.fname = fname;
	}

	public String getLname() {
		System.out.println("EmpDetails:getLname()");
		return lname;
	}

	public void setLname(String lname) {
		System.out.println("EmpDetails:setLname(-)");
		this.lname = lname;
	}

	public String getMail() {
		System.out.println("EmpDetails:getMail()");
		return mail;
	}

	public void setMail(String mail) {
		System.out.println("EmpDetails:setMail()");
		this.mail = mail;
	}
}
