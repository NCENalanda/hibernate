package com.nt.dao;

public class OneToManyDAOFactory {
	
	public static OneToManyDAO getInstance(){
		return new OneToManyDAOImpl();
	}

}
