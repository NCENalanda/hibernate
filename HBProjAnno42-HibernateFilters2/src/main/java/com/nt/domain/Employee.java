package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.Type;

@Entity
@Table(name="Employee")
@FilterDefs(value={@FilterDef(name="HB_FILTER_EID_RANGE",
                              parameters={@ParamDef(name="min",type="int"),
                                          @ParamDef(name="max",type="int")                    
                                         }
                              )
                    }
            )
@Filters(value={@Filter(name="HB_FILTER_EID_RANGE",condition="EID>=:min and EID<=:max")}
        )
public class Employee {
	private int eid;
	private String firstName;
	private String lastName;
	private String email;
	
	@Id
	@GenericGenerator(name = "gen1", strategy = "increment")
	@GeneratedValue(generator="gen1")
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	
	@Column(length=15,nullable=false)
	@Type(type="string")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(length=15,nullable=false)
	@Type(type="string")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
