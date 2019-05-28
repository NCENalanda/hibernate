package com.nt.dao;

import java.util.List;

import com.nt.domain.Product;

public interface ProductDAO {
	public List<Object[]> getProductsByPriceRange(float startRange,float endRange);
}
