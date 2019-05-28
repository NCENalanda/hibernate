package com.nt.dao;

public class LOBDAOFactory {
	public static LOBDAO getInstance(){
		return new LOBDAOImpl();
	}

}
