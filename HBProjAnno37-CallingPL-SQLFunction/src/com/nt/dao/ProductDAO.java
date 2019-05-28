package com.nt.dao;

import java.util.List;

import com.nt.domain.Product;

public interface ProductDAO {
	public List<Product> getProductsByPriceRange(float startRange,float endRange);
}
