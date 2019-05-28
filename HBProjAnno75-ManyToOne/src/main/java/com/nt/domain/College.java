package com.nt.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.Type;

@Entity
@Table(name="COLLEGE_TAB")
public class College {
	private int collegeId;
	private String name;
	private String addrs;
	private University university;
	
	public College() {
		System.out.println("College:0-param constructor");
	}
	
	@Id
	@SequenceGenerator(name="gen1",sequenceName="College_Seq",initialValue=100,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	@Column(length=10)
	@Type(type="string")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(length=10)
	@Type(type="string")
	public String getAddrs() {
		return addrs;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	
	@LazyToOne(LazyToOneOption.FALSE)
	@ManyToOne(targetEntity=University.class,
			   cascade=CascadeType.ALL,
			   fetch=FetchType.EAGER)
	@JoinColumn(name="affiliatedTo",referencedColumnName="unstId")
	
	//@Fetch(FetchMode.JOIN)
	public University getUniversity() {
		return university;
	}
	public void setUniversity(University university) {
		this.university = university;
	}

}
