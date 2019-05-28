package com.nt.dao;

public interface OneToManyDAO {
	public void saveDataUsingUser()throws Exception;
	public void saveDataUsingPhoneNumber()throws Exception;
	public void loadDataUsingUser()throws Exception;
	public void loadDataUsingPhoneNumber()throws Exception;
    public  void  deleteAllPhoneNumbersOfAUser()throws Exception;
    public void deleteAllPhoneNumbersAndTheirUserUsingPhoneNumber()throws Exception;
    
    
    
    
}
