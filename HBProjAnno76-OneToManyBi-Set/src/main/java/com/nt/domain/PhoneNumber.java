package com.nt.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="ANNO_PHONENUMBER_TAB")
public class PhoneNumber {
	private long phone;
	private String numberType;
	private String provider;  
	private User user; //Many To One
	
	public PhoneNumber() {
		System.out.println("PhoneNumber:0-param constructor");
	}
	
	@Id
	@Column(length=12)
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	@Column(length=13,nullable=false)
	@Type(type="string")
	public String getNumberType() {
		return numberType;
	}
	public void setNumberType(String numberType) {
		this.numberType = numberType;
	}
	
	@Column(length=13,nullable=false)
	@Type(type="string")
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}

	@ManyToOne(targetEntity=User.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="unid",referencedColumnName="userId")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
