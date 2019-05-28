package com.nt.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="D_INH_PAYMENT2")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="PAYMENT_TYPE",discriminatorType=DiscriminatorType.STRING)
public abstract class Payment {
	private int txId;
	private float amount;
	private  Date txDate;
	
    @Column(length=10)
    @Type(type="int")
    @Id
    @GeneratedValue(generator="gen1")
    @GenericGenerator(name="gen1",strategy="increment")
	public int getTxId() {
		return txId;
	}
	public void setTxId(int txId) {
		this.txId = txId;
	}
	
	@Column(length=10,precision=2)
    @Type(type="float")
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	@Column(nullable=false)
    @Type(type="date")
	public Date getTxDate() {
		return txDate;
	}
	public void setTxDate(Date txDate) {
		this.txDate = txDate;
	}

}
