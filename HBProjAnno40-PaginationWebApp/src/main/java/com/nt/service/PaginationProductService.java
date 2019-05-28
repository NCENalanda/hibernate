package com.nt.service;

import java.util.List;

import com.nt.domain.Product;
import com.nt.dto.ProductDTO;

public interface PaginationProductService {
	public static final int PAGE_SIZE=4;
	public  int getPageCount();
	public List<ProductDTO> getReportData(int pageNo);

}
