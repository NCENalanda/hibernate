package com.nt.dao;

public interface OneToManyDAO {
	public void saveData()throws Exception;
	public void saveDataWithPersist()throws Exception;
	public void loadData()throws Exception;
	public void addPhoneNumberToExistingUser()throws Exception;
    public  void deleteOnePhoneNumberOfAUser()throws Exception;
    public  void  deleteAllPhoneNumbersOfAUser()throws Exception;
    public void deleteUserAndHisPhoneNumbers()throws Exception;
    public  void transferPhoneNumberFromOneUserToAnotherUser()throws Exception;
    public void changePhoneNumberProviderOfAUser();
}
