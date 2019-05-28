package com.nt.domain;

import java.io.Serializable;

public class ProgrammerProjectInfo{ //implements Serializable{
    private PrgmrProjId id;
    private String prgmrName;
    private String projName;
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
