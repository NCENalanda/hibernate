package com.nt.dao;

public interface OneToManyDAO {
  public void saveDataUsingPerson();
  public void loadDataUsingPerson();
  public void loadDataUsingPersonWithQBC();
  public  void deleteOneViechleOfAPerson();
}
