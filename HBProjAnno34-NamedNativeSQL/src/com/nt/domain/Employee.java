package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="Employee")
@NamedNativeQueries({@NamedNativeQuery(name="GET_ALL_EMPS",query="SELECT * FROM EMPLOYEE",resultClass=Employee.class),
		             @NamedNativeQuery(name="UPDATE_EMP",query="UPDATE EMPLOYEE SET LASTNAME=:lname where EID=:id"),
		             @NamedNativeQuery(name="GET_EID_EMAIL",query="SELECT EID,EMAIL FROM EMPLOYEE")
		             }
                    )
public class Employee {
	private int eid;
	private String firstName;
	private String lastName;
	private String email;
	
	public Employee() {
		System.out.println("Employee :: 0-param constructor");
	}

	@Id
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
	@Column(length=7)
	@Type(type="int")
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	
	@Column(length=20)
	@Type(type="string")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(length=20)
	@Type(type="string")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(length=20)
	@Type(type="string")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}
	

}
