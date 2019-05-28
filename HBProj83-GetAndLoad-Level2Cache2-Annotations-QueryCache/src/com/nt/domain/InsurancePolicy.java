package com.nt.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="INSURANCE_POLICY")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public  class InsurancePolicy  {
	
	private int policyId;
	private String policyName;
	private int tenure;
	private int premium;
	
	public InsurancePolicy() {
	 System.out.println("PolicyInsurance:0-param constructor");
	}
	
	@Id
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public int getPremium() {
		return premium;
	}
	public void setPremium(int premium) {
		this.premium = premium;
	}

}
