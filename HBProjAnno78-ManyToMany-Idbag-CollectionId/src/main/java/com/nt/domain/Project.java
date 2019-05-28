package com.nt.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="ANNO_PROJECTS_TAB2")
public class Project {
	private int proid;
	private String proname;
	private List<Programmer> programmers=new ArrayList();
	
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
	@JoinTable(name="ANNO_PROGRAMMERS_PROJECTS_TAB2",
	            joinColumns=@JoinColumn(name="PROJECT_ID",referencedColumnName="PROID"),
	            inverseJoinColumns=@JoinColumn(name="PROGRRAMMER_ID",referencedColumnName="PID") 
	           )
	@GenericGenerator(name="gen2",strategy="increment")
	@CollectionId(columns=@Column(name="prgmr_proj_indx",length=5),
	               generator = "gen2",
	               type = @Type(type="int"))
	public List<Programmer> getProgrammers() {
		return programmers;
	}
	public void setProgrammers(List<Programmer> programmers) {
		this.programmers = programmers;
	}

}
