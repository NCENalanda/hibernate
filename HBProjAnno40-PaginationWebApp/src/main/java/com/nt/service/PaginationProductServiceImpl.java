package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.dao.PaginationDAOFactory;
import com.nt.dao.PaginationProductDAO;
import com.nt.domain.Product;
import com.nt.dto.ProductDTO;

public class PaginationProductServiceImpl implements PaginationProductService {

	@Override
	public int getPageCount() {
		PaginationProductDAO dao=null;
		long rowCount=0;
		int pageCount=0;
		
		//get DAO
		dao=PaginationDAOFactory.getInstance();
		//use DAO
		rowCount=dao.rowCount();
		//calculate pagesCount
		pageCount=(int) (rowCount/PaginationProductService.PAGE_SIZE);
		
		if(rowCount%PaginationProductService.PAGE_SIZE!=0)
			pageCount++;
		return pageCount;
	}

	@Override
	public List<ProductDTO> getReportData(int pageNo) {
		 int startPos=0;
		 PaginationProductDAO dao=null;
		 List<Product> listProduct=null;
		 List<ProductDTO>  listDTO=new ArrayList();
		//Decide StartPosition to get page Report data based on given pageno
		startPos=(pageNo*PaginationProductService.PAGE_SIZE)-PaginationProductService.PAGE_SIZE;
		//get DAO
		dao=PaginationDAOFactory.getInstance();
		//use DAO
		listProduct=dao.getProducts(startPos,PaginationProductService.PAGE_SIZE);
		//convert listProduct to listDTO
		listProduct.forEach(p->{
			ProductDTO dto=null;
			dto=new ProductDTO();
			dto.setPid(p.getPid());
			dto.setPname(p.getPname());
			dto.setPrice(p.getPrice());
			dto.setQty(p.getQty());
			listDTO.add(dto);
		});
		return listDTO;
	}

}
