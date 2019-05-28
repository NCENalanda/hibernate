package com.nt.dao;

public class InheritenceDAOFactory {
	public static InheritenceDAO getInstance(){
		return  new InheritenceDAOImpl();
	}

}
