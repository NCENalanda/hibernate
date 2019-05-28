package com.nt.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
@Entity
@Table(name="Anno_LibraryMembership_tab")
public class LibraryMembership {
	private int lid;
	private Date doj;
	private Student studentDetails;
	
	public LibraryMembership() {
		System.out.println("LibraryMembership:0-param constructor");
	}
	
	    @Id
	    @GenericGenerator(name="gen1",
	                     strategy="foreign",
	                    parameters=@Parameter(name="property",value="studentDetails")
                          )
	    @GeneratedValue(generator="gen1")
	
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	
	@Column(nullable=false)
	@Type(type="date")
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	
	@OneToOne(targetEntity=Student.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@PrimaryKeyJoinColumn(name="lid",referencedColumnName="sid")
	public Student getStudentDetails() {
		return studentDetails;
	}
	public void setStudentDetails(Student studentDetails) {
		this.studentDetails = studentDetails;
	}
	

}
