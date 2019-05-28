package com.nt.test;

import com.nt.dao.StockMarketDAO;
import com.nt.dao.StockMarketDAOFactory;
import com.nt.domain.StockShare;
import com.nt.utility.HibernateUtil;

public class ObjectTimeStampingTest {
	public static void main(String[] args) {
		StockMarketDAO dao=null;
		StockShare share=null;
		//get DAO
		dao=StockMarketDAOFactory.getInstance();
		/*//prepare share
		share=new StockShare();
		share.setStockName("KingFisher");
		share.setOwnerCompany("UBCL");
		share.setCurrentPrice(80.0f);
		share.setStatus("active");
		System.out.println("Object saved?"+dao.insertStock(share));*/
		
		if(dao.updateStock(1,78.0f)){
			System.out.println("StockUpdated becoz it is Active and newPrice Set");
		}
		else{
			System.out.println("Stock  not Updated becoz it is not Active or newPrice not Set");
		}
		
		//close SessinFactory
		HibernateUtil.closeSessionFactory();
	}
}
