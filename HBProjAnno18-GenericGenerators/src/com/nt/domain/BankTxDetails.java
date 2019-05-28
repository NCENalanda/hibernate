package com.nt.domain;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="Bank_Tx_Details")
public class BankTxDetails {
	private int txId;
	//private String txId;
	private String txName;
	private float txAmount;
	private Date txDate;
	
	/*@Id
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")*/
	
	/*@Id
	@GenericGenerator(name="gen1",strategy="sequence")
	@GeneratedValue(generator="gen1")*/
	
	/*@Id
	@GenericGenerator(name="gen1",
	                  strategy="sequence",
	                  parameters=@Parameter(name="sequence_name", value ="TxID_SEQ"))
   @GeneratedValue(generator="gen1")	*/
	
	@Id
	@GenericGenerator(name="gen1",
	                  strategy="hilo",
	                  parameters={@Parameter(name="table", value="HB_HILO"),
	                		      @Parameter(name="column",value="HB_HI"),
	                		      @Parameter(name="max_lo",value="5")
	                              }
	                  )
	@GeneratedValue(generator="gen1")
	
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
	
	public String getTxName() {
		return txName;
	}
	public void setTxName(String txName) {
		this.txName = txName;
	}
	
	public float getTxAmount() {
		return txAmount;
	}
	public void setTxAmount(float txAmount) {
		this.txAmount = txAmount;
	}
	
	public Date getTxDate() {
		return txDate;
	}
	public void setTxDate(Date txDate) {
		this.txDate = txDate;
	}

}
