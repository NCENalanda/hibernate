package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.annotations.Type;

@Entity
@DiscriminatorValue(value="CARD")
public class CardPayment extends Payment {
	private String cardType;
	private long cardNumber;
	private String paymentGateway;
	
	@Column(length=7)
	@Type(type="string")
	public String getCardType() {
		return cardType;
	}
	
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
	@Column(length=16)
	@Type(type="long")
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	@Column(length=7)
	@Type(type="string")
	public String getPaymentGateway() {
		return paymentGateway;
	}
	public void setPaymentGateway(String paymentGateway) {
		this.paymentGateway = paymentGateway;
	}

}
