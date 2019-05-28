package com.nt.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PrgmrProjId implements Serializable {
	@Column(length=10)
	private int prgmrId;
	@Column(length=10)
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
