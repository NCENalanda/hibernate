package com.nt.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
	private int acno;
	private String holder;
	private float balance;

	@Id
	public int getAcno() {
		return acno;
	}

	public void setAcno(int acno) {
		this.acno = acno;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

}
