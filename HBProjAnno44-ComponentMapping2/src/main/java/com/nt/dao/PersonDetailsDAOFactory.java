package com.nt.dao;

public class PersonDetailsDAOFactory {
	
	public static PersonDetailsDAO getInstance(){
		return new PersonDetailsDAOImpl();
	}

}
