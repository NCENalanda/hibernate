package com.nt.dao;

public class AccountDAOFactory {
	
	public static AccountDAO getInstance(){
		return new AccountDAOImpl();
	}

}
