package com.nt.dao;

public class StockMarketDAOFactory {

	public  static StockMarketDAO getInstance(){
		return new StockMarketDAOImpl();
	}
}
