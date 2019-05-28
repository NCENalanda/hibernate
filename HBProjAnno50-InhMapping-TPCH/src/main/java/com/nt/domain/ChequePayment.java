package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.Type;

@Entity
@DiscriminatorValue(value="CHEQUE")
public class ChequePayment extends Payment {
	private String chequeType;
	private long chequeNumber;
	
	@Column(length=10)
	@Type(type="string")
	public String getChequeType() {
		return chequeType;
	}
	public void setChequeType(String chequeType) {
		this.chequeType = chequeType;
	}
	
	@Column(length=15)
	@Type(type="long")
	public long getChequeNumber() {
		return chequeNumber;
	}
	public void setChequeNumber(long chequeNumber) {
		this.chequeNumber = chequeNumber;
	}

}
