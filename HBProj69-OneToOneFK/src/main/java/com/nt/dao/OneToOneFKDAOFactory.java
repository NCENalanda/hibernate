package com.nt.dao;

public class OneToOneFKDAOFactory {
	
	public static OneToOneFKDAO getInstance(){
		return new OneToOneFKDAOImpl();
	}

}
