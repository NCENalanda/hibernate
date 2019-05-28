package com.nt.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.ListIndexBase;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "Anno_Person_Tab1")
public class Person {
	private int pid;
	private String pname;
	private String addrs;
	private List<Viechle> viechles;
	
	public Person() {
		System.out.println("Person:0-param constructor");
	}


	// getters & getters
	@Id
	@Type(type = "int")
	@GenericGenerator(name = "gen1", strategy = "increment")
	@GeneratedValue(generator = "gen1")
	@Column(length=5,nullable=false)
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	@Column(length=14,nullable=false)
	@Type(type="string")
	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	@Column(length=14,nullable=false)
	@Type(type="string")
	public String getAddrs() {
		return addrs;
	}

	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}

	@OneToMany(targetEntity = Viechle.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval=true)
	@LazyCollection(LazyCollectionOption.TRUE)
	//@IndexColumn(name = "lst_indx",base=1)
	@OrderColumn(name="lst_indx")
	@ListIndexBase(value=1)
	@JoinColumn(name = "person_id", referencedColumnName = "pid")
	@Fetch(FetchMode.SELECT)
	public List<Viechle> getViechles() {
		return viechles;
	}

	public void setViechles(List<Viechle> viechles) {
		this.viechles = viechles;
	}
}
