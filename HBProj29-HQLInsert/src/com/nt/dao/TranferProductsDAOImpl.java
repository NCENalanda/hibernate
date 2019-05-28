package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.utility.HibernateUtil;

public class TranferProductsDAOImpl implements TransferProductsDAO {
 private static final String HQL_TRANSFER_PRODUCTS="insert into PremiumProduct(pid,pname,price,qty) select p.pid,p.pname,p.price,p.qty from Product p where p.price>=:start";
	@Override
	public int transferProductByPriceRange(float start){
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		int result=0;
		Query query=null;
		//get SEssion
		ses=HibernateUtil.getSession();
		try{
	     tx=ses.beginTransaction();
	     //prepare Queery
	     query=ses.createQuery(HQL_TRANSFER_PRODUCTS);
	     query.setFloat("start",start);
	     //execute the query
	     result=query.executeUpdate();
	     flag=true;
		}
		catch(HibernateException he){
			he.printStackTrace();
			flag=false;
		}
		catch(Exception e){
			e.printStackTrace();
			flag=false;
		}
		finally{
		 if(flag==true){
			 tx.commit();
		 }
		 else{
			 tx.rollback();
		 }
		 HibernateUtil.closeSession(ses);
		}//finallt
		return result;
	}//method
}//class
