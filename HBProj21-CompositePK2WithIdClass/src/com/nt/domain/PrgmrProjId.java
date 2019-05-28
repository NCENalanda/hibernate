package com.nt.domain;

import java.io.Serializable;

public class PrgmrProjId implements Serializable {
	private int prgmrId;
	private int projId;
	
	public PrgmrProjId() {
	 System.out.println("PrgmrProjId:0-param constructor");
	}

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

}
