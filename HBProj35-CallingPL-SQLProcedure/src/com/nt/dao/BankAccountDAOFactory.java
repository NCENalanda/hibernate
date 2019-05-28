package com.nt.dao;

public class BankAccountDAOFactory {
 public static BankAccountDAO getInstance(){
	 return  new BankAccountDAOImpl();
 }
}
