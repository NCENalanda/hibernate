package com.nt.dao;

public class TransferProductsDAOFactory {
	public static TransferProductsDAO getInstance(){
		return new TranferProductsDAOImpl();
	}
}
