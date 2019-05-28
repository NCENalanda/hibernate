package com.nt.dao;

public interface OneToOneDAO {
	public  void saveDataUsingStudent();
	public  void saveDataUsingLibraryMembership();
	public  void  loadDataUsingStudent();
	public  void  loadDataUsingLibraryMembership();
	public void deleteDataUsingStudent();
	public void deleteDataUsingLibraryMembership();
	public void  deleteOnlyLibaryMemebership();

}
