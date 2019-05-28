package com.nt.dao;

import com.nt.domain.StockShare;

public interface StockMarketDAO {
	public boolean insert(StockShare share);
	public StockShare get(int stockId);
	public boolean update(int stockId,float newValue);
}
