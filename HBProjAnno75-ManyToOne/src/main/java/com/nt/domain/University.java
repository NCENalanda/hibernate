package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="UNIVERSITY_TAB")
public class University {
	
	private int unstId;
	private String name;
	private String region;
	
	public University() {
		System.out.println("University::0-param constructor");
	}
	
	@Id
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
	@Type(type="int")
	public int getUnstId() {
		return unstId;
	}
	public void setUnstId(int unstId) {
		this.unstId = unstId;
	}
	
	@Column(length=10)
	@Type(type="string")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(length=15)
	@Type(type="string")
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	} 

}
