package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Type;

@Entity
@Table(name="student_lock1")
public class Student {
	@Id
	private int sno;
	private String sname;
	private String address;
	private int ver;
	
	@Column(length=10)
	@Type(type="int")
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	
	@Column(length=20)
	@Type(type="string")
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	@Column(length=20)
	@Type(type="string")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Version
	@Column(name="ver",nullable=true,length=10)
	@Type(type="int")
	public int getVer() {
		return ver;
	}
	public void setVer(int ver) {
		this.ver = ver;
	} 

}
