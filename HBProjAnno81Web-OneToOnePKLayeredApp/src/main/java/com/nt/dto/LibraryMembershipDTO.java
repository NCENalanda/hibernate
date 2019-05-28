package com.nt.dto;

import java.io.Serializable;
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
public class LibraryMembershipDTO implements Serializable {
	private int lid;
	private Date doj;
	private StudentDTO studentDetails;
	
	public LibraryMembershipDTO() {
		System.out.println("LibraryMembershipDTO:0-param constructor");
	}
	  
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	
	public StudentDTO getStudentDetails() {
		return studentDetails;
	}
	public void setStudentDetails(StudentDTO studentDetails) {
		this.studentDetails = studentDetails;
	}
	

}
