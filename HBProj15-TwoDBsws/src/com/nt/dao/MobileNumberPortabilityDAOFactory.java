package com.nt.dao;

public class MobileNumberPortabilityDAOFactory {
	public static MobileNumberPortabilityDAO getInstance(){
		return new MobileNumberPortabilityDAOImpl();
	}

}
