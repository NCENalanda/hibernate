package com.nt.domain;

public final class InsurancePolicy implements IInsurancePolicy {
	private int policyId;
	private String policyName;
	private int tenure;
	private int premium;
	private int closingTime;
	
	public InsurancePolicy() {
	 System.out.println("PolicyInsurance:0-param constructor");
	}
	
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

	public int getClosingTime() {
		return closingTime;
	}

	public void setClosingTime(int closingTime) {
		this.closingTime = closingTime;
	}
}
