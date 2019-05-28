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
		System.out.println("Object saved?"+dao.insert(share));*/
		
		System.out.println("Object updated?"+dao.update(1,78.0f));
		System.out.println("Objected updated at"+dao.get(1).getLastUpdated());
		
		//close SessinFactory
		HibernateUtil.closeSessionFactory();
	}
}
