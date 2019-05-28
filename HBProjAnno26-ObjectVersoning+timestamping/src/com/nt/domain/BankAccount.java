package com.nt.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="Bank_Account1")
public class BankAccount implements Serializable {
	private long acno;
	private  String holderName;
	private String type;
	private float balance;
	private int version;
	//private Date lastOperated=new Date();
	private Timestamp lastOperated;
	private Timestamp openingDate;

	@Column
	@CreationTimestamp
	public Timestamp getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(Timestamp openingDate) {
		this.openingDate = openingDate;
	}
	@Column
	@UpdateTimestamp
   public Timestamp getLastOperated() {
		return lastOperated;
	}
	public void setLastOperated(Timestamp lastOperated) {
		this.lastOperated = lastOperated;
	}
	/*	@Column
	@Temporal(TemporalType.TIMESTAMP)
	public Date getLastOperated() {
		return lastOperated;
	}
	

	public void setLastOperated(Date lastOperated) {
		this.lastOperated = lastOperated;
	}
*/	
	@Id
	@Column(length=10)
	@SequenceGenerator(name="gen1",
	                   sequenceName="ACNO_SEQ",
	                   initialValue=10,
	                   allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	@Type(type="long")
	public long getAcno() {
		return acno;
	}
	public void setAcno(long acno) {
		this.acno = acno;
	}
	
	@Column(length=10)
	@Type(type="string")
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	
	@Column(length=20)
	@Type(type="string")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(length=10)
	@Type(type="float")
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	@Column(length=6,name="VERSION_COL")
	@Type(type="int")
	@Version
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	

}
