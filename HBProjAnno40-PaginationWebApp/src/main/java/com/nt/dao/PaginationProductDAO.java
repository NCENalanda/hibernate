package com.nt.dao;

import java.util.List;

import com.nt.domain.Product;

public interface PaginationProductDAO {
	public long rowCount();
	public List<Product> getProducts(int startPos,int pageSize);
}
