package com.nt.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "Anno_Viechle_TAB")
public class Viechle {
	
	private long regNo;
	private String type;
	private Date dor;
	private String chasisNo;
	
	public Viechle() {
		System.out.println("Viechle:0-param constructor");
	}
	// setters & getters
	@Id
	//@GeneratedValue
	@Type(type="long")
	public long getRegNo() {
		return regNo;
	}
	public void setRegNo(long regNo) {
		this.regNo = regNo;
	}
	
	@Column(length=10,nullable=false)
	@Type(type="string")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(nullable=false)
	@Type(type="date")
	public Date getDor() {
		return dor;
	}
	public void setDor(Date dor) {
		this.dor = dor;
	}
	
	@Column(nullable=false,length=10)
	@Type(type="string")
	public String getChasisNo() {
		return chasisNo;
	}
	public void setChasisNo(String chasisNo) {
		this.chasisNo = chasisNo;
	}
}