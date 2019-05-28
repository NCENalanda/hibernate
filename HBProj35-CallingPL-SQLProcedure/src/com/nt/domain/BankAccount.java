package com.nt.domain;

public class BankAccount {
	private long acno;
	private String holderName;
	private String type;
	private float balance;
	
	public BankAccount() {
		System.out.println("BankAccount::0-param constructor");
	}
	
	public long getAcno() {
		return acno;
	}
	public void setAcno(long acno) {
		this.acno = acno;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankAccount [acno=" + acno + ", holderName=" + holderName + ", type=" + type + ", balance=" + balance
				+ "]";
	}
	
	

}
