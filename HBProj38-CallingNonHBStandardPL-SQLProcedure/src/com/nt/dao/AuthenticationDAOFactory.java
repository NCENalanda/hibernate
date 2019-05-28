package com.nt.dao;

public class AuthenticationDAOFactory {
	
	public static AuthenticationDAO  getInstance(){
		//return  new AuthenticationDAOImpl();
//		return  new AuthenticationDAOImpl1();
		return  new AuthenticationDAOImpl2();
	}

}
