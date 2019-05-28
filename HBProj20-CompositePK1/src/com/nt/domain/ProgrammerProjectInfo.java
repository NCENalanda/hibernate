package com.nt.domain;

import java.io.Serializable;

public class ProgrammerProjectInfo{ //implements Serializable{
    private int prgmrId;
    private  int projId;
    private String prgmrName;
    private String projName;
    private String status;
	public int getPrgmrId() {
		return prgmrId;
	}
	public void setPrgmrId(int prgmrId) {
		this.prgmrId = prgmrId;
	}
	public int getProjId() {
		return projId;
	}
	public void setProjId(int projId) {
		this.projId = projId;
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
