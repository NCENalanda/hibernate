package com.nt.test;

import com.nt.dao.TransferProductsDAO;
import com.nt.dao.TransferProductsDAOFactory;
import com.nt.utility.HibernateUtil;

public class HQLInsertTest {

	public static void main(String[] args) {
		TransferProductsDAO dao=null;
		int result=0;
		//get DAO
		dao=TransferProductsDAOFactory.getInstance();
		//use dAO
		result=dao.transferProductByPriceRange(8000);
		System.out.println("No.of premium products that are tranffered::"+result);
		//close SessionFactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
