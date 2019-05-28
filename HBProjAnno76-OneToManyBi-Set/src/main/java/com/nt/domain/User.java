package com.nt.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="ANNO_USER_TAB")
public class User {
	private int userId;
	private String firstName;
	private String addrs;
	private Set<PhoneNumber> phones;  //for OneToMany
	
	public User() {
		System.out.println("User:0-param constructor");
	}

	@Id
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(length=13,nullable=false)
	@Type(type="string")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(length=13,nullable=false)
	@Type(type="string")
	public String getAddrs() {
		return addrs;
	}

	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}

	@OneToMany(targetEntity=PhoneNumber.class,
			    cascade=CascadeType.ALL,
			    fetch=FetchType.LAZY,orphanRemoval=true
			   )
	@JoinColumn(name="unid",referencedColumnName="userId")
	@I
	public Set<PhoneNumber> getPhones() {
		return phones;
	}

	public void setPhones(Set<PhoneNumber> phones) {
		this.phones = phones;
	}

}
