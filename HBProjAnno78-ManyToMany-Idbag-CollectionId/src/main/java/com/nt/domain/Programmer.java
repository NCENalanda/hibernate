package com.nt.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="ANNO_PROGRAMMERS_TAB2")
public class Programmer {
	private int pid;
	private String pname;
	private int salary;
	private Set<Project> projects=new HashSet();
	
	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	@Column(length=10,nullable=false)
	@Type(type="string")
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}

	@Column(length=10,nullable=false)
	@Type(type="int")
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	@ManyToMany(targetEntity=Project.class,cascade=CascadeType.ALL,
			    fetch=FetchType.EAGER)
	@JoinTable(name="ANNO_PROGRAMMERS_PROJECTS_TAB2",
       inverseJoinColumns=@JoinColumn(name="PROJECT_ID",referencedColumnName="PROID"),
       joinColumns=@JoinColumn(name="PROGRRAMMER_ID",referencedColumnName="PID") 
   )
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

}
