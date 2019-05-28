package com.nt.dao;

public class StudentLibraryOperationsDAOFactory {
	
	public static  StudentLibraryOperationsDAO getInstance(){
		return new StudentLibraryOperationsDAOImpl();
	}

}
