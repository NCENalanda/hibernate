package com.nt.dao;

public class MToODAOFacatory {
	
	public static MToODAO getInstance(){
		return new MToODAOImpl();
	}

}
