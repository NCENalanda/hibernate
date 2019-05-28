package com.nt.test;

import java.util.List;

import com.nt.dao.ProductDAO;
import com.nt.dao.ProductDAOFactory;
import com.nt.domain.Product;
import com.nt.utility.HibernateUtil;

public class CallingFunctionTest {

	public static void main(String[] args) {
		ProductDAO dao=null;
		List<Object[]> list=null;
		//get dAO
		dao=ProductDAOFactory.getInstance();
		//invoke method
		list=dao.getProductsByPriceRange(5000,10000);
		//display reuslts..
		list.forEach(row->{
			for(Object val:row){
				System.out.print(val+"  ");
			}
			System.out.println();
		});
		
		//close SessionFactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
