package com.nt.dao;

import com.nt.domain.StockShare;

public interface StockMarketDAO {
	public boolean insertStock(StockShare share);
	public StockShare getStock(int stockId);
	public boolean updateStock(int stockId,float newValue);
}
