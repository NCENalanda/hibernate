package com.nt.service;

public class PaginationProductServiceFactory {
	
	public static PaginationProductService getInstance(){
		return new PaginationProductServiceImpl();
	}

}
