package com.nt.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Programmers_Projects_Info")
public class ProgrammerProjectInfo{ //implements Serializable{
    @EmbeddedId
	private PrgmrProjId id;
    @Column(length=10)
    private String prgmrName;
    @Column(length=10)
    private String projName;
    @Column(length=10)
    private String status;
    
	
	public PrgmrProjId getId() {
		return id;
	}
	public void setId(PrgmrProjId id) {
		this.id = id;
	}
	public String getPrgmrName() {
		return prgmrName;
	}
	public void setPrgmrName(String prgmrName) {
		this.prgmrName = prgmrName;
	}
	public String getProjName() {
		return projName;
	}
	public void setProjName(String projName) {
		this.projName = projName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
