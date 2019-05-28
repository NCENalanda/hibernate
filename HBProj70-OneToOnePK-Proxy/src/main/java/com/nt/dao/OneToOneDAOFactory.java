package com.nt.dao;

public class OneToOneDAOFactory {
	
	public static  OneToOneDAO getInstance(){
		return new OneToOneDAOImpl();
	}

}
