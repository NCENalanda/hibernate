package com.nt.dao;

public class MToMDAOFactory {
	
	public static MToMDAO getInstance(){
		return new MToMDAOImpl();
	}

}
