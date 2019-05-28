package com.nt.dao;

public class ManyToOneDAOFactory {
	
	public static ManyToOneDAO getInstance(){
		return new ManyToOneDAOImpl();
	}

}
