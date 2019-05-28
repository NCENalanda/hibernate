package com.nt.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="Anno_FlighPassenger_TAB")
public class FlightPassenger {
	private int passengerId;
	private long aadharNo;
	private int age;
	private String name;
	private long mobileNo;
	private FlightTicket ticket;

	@Id
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	@Column(length=13,nullable=false)
	@Type(type="long")
	public long getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}

	@Column(length=3,nullable=false)
	@Type(type="int")
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Column(length=10,nullable=false)
	@Type(type="string")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length=11,nullable=false)
	@Type(type="long")
	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	@OneToOne(targetEntity=FlightTicket.class,
			   cascade=CascadeType.ALL,
			   fetch=FetchType.LAZY,
			   mappedBy="passenger")
	public FlightTicket getTicket() {
		return ticket;
	}

	public void setTicket(FlightTicket ticket) {
		this.ticket = ticket;
	}

}
