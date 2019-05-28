package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="PERSON_DETAILS")
@NamedQueries({@NamedQuery(name="GET_ALL_PERSONDETAILS", query = "from PersonDetails"),
	           @NamedQuery(name="GET_ALL_PERSONDETAILS_BY_DESG",
	                        query="select pid,pjob.desg,pjob.salary from PersonDetails where pjob.desg=:position")
               }
              )
public class PersonDetails {
	private int pid;
	private String pname;
	private JobDetails pjob;
	
	@Id
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
	@Column(length=11)
	@Type(type="int")
	public int getPid() {
		return pid;
	}
	
	
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	@Column(nullable=false,length=15)
	@Type(type="string")
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	
	@Embedded
	public JobDetails getPjob() {
		return pjob;
	}
	public void setPjob(JobDetails pjob) {
		this.pjob = pjob;
	}

}
