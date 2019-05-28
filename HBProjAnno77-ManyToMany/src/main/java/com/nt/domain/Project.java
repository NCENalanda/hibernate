package com.nt.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="ANNO_PROJECTS_TAB")
public class Project {
	private int proid;
	private String proname;
	private Set<Programmer> programmers=new HashSet();
	
	@Id
	@SequenceGenerator(name = "gen1",sequenceName="Proj_Seq1",initialValue=1000,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	public int getProid() {
		return proid;
	}
	public void setProid(int proid) {
		this.proid = proid;
	}
	
	@Column(length=10,nullable=false)
	@Type(type="string")
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	
	
	@ManyToMany(targetEntity=Programmer.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="ANNO_PROGRAMMERS_PROJECTS_TAB",
	            joinColumns=@JoinColumn(name="PROJECT_ID",referencedColumnName="PROID"),
	            inverseJoinColumns=@JoinColumn(name="PROGRRAMMER_ID",referencedColumnName="PID") 
	           )
	public Set<Programmer> getProgrammers() {
		return programmers;
	}
	public void setProgrammers(Set<Programmer> programmers) {
		this.programmers = programmers;
	}

}
