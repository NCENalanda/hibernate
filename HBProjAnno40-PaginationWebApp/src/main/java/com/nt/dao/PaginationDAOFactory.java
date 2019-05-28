package com.nt.dao;

public class PaginationDAOFactory {
	public static PaginationProductDAO getInstance(){
		return new PaginationProductDAOImpl();
	}

}
