package com.nt.dao;

public interface OneToManyDAO {
	public void loadDataUsingUserAndJoins()throws Exception;
	public void loadDataUsingPhoneNumberAndJoins()throws Exception;
	public void loadDataUsingPhoneNumberAndJoins1()throws Exception;
    public void loadDataUsingUserAndQBCWithFetchMode()throws Exception;
}
