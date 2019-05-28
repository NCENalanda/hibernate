package com.nt.domain;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

@Entity
@Table(name="Bank_Tx_Details")
public class BankTxDetails {
	private int txId;
	//private String txId;
	private String txName;
	private float txAmount;
	private Date txDate;
	
	
/*	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length=10)
	@Type(type="int")
*/
	/*@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(length=10)
	@Type(type="int")*/
	
	/*@Id
	@SequenceGenerator(name="gen1",
	                   sequenceName="HB_TX_SEQ",
	                   initialValue=100,
	                   allocationSize=5) 
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)*/
	
	/*@Id
	@TableGenerator(name="gen1",
	               table="SEQ_TAB",
	               pkColumnName="SEQ_NAME",
	               valueColumnName="NEXT_VAL",
	               pkColumnValue="TxId",
	               initialValue=10,
	               allocationSize=2)
	@GeneratedValue(generator="gen1",strategy=GenerationType.TABLE)
	@Column(length=10)*/
	
/*	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	@Column(length=10)*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getTxId() {
		return txId;
	}
	public void setTxId(int txId) {
		this.txId = txId;
	}
	/*public String getTxId() {
		return txId;
	}
	public void setTxId(String txId) {
		this.txId = txId;
	}*/
	
	@Column(length=20)
	@Type(type="string")
	public String getTxName() {
		return txName;
	}
	public void setTxName(String txName) {
		this.txName = txName;
	}
	
	@Column(length=10)
	@Type(type="float")
	public float getTxAmount() {
		return txAmount;
	}
	public void setTxAmount(float txAmount) {
		this.txAmount = txAmount;
	}
	
	@Column(length=20)
	@Type(type="date")
	public Date getTxDate() {
		return txDate;
	}
	public void setTxDate(Date txDate) {
		this.txDate = txDate;
	}

}
