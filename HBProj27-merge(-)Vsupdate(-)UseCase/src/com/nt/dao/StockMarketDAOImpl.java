package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.StockShare;
import com.nt.utility.HibernateUtil;

public class StockMarketDAOImpl implements StockMarketDAO {

	@Override
	public boolean insertStock(StockShare share) {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		try{
		 tx=ses.beginTransaction();
		  ses.save(share);
		 flag=true;
		}
		catch(HibernateException he){
			flag=false;
			he.printStackTrace();
		}
		catch(Exception e){
			flag=false;
			e.printStackTrace();
		}
		finally{
			if(flag==true)
				tx.commit();
			else
			   tx.rollback();
		 HibernateUtil.closeSession(ses);
		}
		return flag;
	}//method

	@Override
	public StockShare getStock(int stockId) {
		Session ses=null;
		StockShare share=null;
		//get Session
		ses=HibernateUtil.getSession();
		try{
		 share=ses.get(StockShare.class,stockId);	
		}
		catch(HibernateException he){
			he.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			HibernateUtil.closeSession(ses);
		}
		return share;
	}

	@Override
	public boolean updateStock(int stockId, float newValue) {
		Session ses=null;
		StockShare share=null,share1=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session 
		ses=HibernateUtil.getSession();
		share=getStock(stockId);
		try{
		  tx=ses.beginTransaction();
		   //modify stockValue
		  share.setCurrentPrice(newValue);
		  //get Stock status
		  share1=ses.get(StockShare.class,stockId);
		  if(share1.getStatus().equalsIgnoreCase("active")){
		    //ses.update(share); //throws NonUniqueObjectException
			 ses.merge(share);
			  //share1.setCurrentPrice(share.getCurrentPrice());
		     flag=true;
		  }
		}
		catch(HibernateException  he){
			flag=false;
			he.printStackTrace();
		}
		catch(Exception e){
			flag=false;
			e.printStackTrace();
		}
		finally{
			if(flag==true)
				tx.commit();
			else
				tx.rollback();
			
			HibernateUtil.closeSession(ses);
		}
		return flag;
	}

}
