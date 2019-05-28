package com.nt.dao;

public interface OneToManyDAO {
	public void saveData()throws Exception;
	public void deleteOnePhoneNumberOfAUser();
	public  void makingOrphanPhoneNumberAsChildPhoneNumberToAParent();
}
