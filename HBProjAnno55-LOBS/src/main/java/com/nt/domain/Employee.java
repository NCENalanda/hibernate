package com.nt.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="LOB_Employee_Registration")
public class Employee {
	private int eid;
	private String ename;
	private  String eaddrs;
	private  java.sql.Blob ephoto;
	private java.sql.Clob eresume;
	
	@Id
	@GenericGenerator(strategy="increment",name="gen1")
	@GeneratedValue(generator="gen1")
	@Type(type="int")
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	
	@Type(type="string")
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	@Type(type="string")
	public String getEaddrs() {
		return eaddrs;
	}
	public void setEaddrs(String eaddrs) {
		this.eaddrs = eaddrs;
	}
	
	@Type(type="blob")
	public java.sql.Blob getEphoto() {
		return ephoto;
	}
	public void setEphoto(java.sql.Blob ephoto) {
		this.ephoto = ephoto;
	}
	
	@Type(type="clob")
	public java.sql.Clob getEresume() {
		return eresume;
	}
	public void setEresume(java.sql.Clob eresume) {
		this.eresume = eresume;
	}

}
