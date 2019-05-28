package com.nt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Product;
import com.nt.utility.HibernateUtil;

public class NamedHQLTest {
  public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		List<Product> list=null;
		// Get Session
		ses=HibernateUtil.getSession();
		try{
/*		  //get Access Named HQL Query	
			query=ses.getNamedQuery("GET_ALL_PRODUCTS");
		   //execute Query
			list=query.list();
		   //process the Result
			list.forEach(p->{
				System.out.println(p.getPid()+" "+p.getPname()+" "+p.getQty()+" "+p.getPrice());
			});
*/
			//get Access to Named HQL query
			query=ses.getNamedQuery("GET_ALL_PRODUCTS_BY_PRICE_RANGE");
			//set values query params
			query.setFloat("start",10000);
			query.setFloat("end", 100000);
			//execute the query
			list=query.list();
			//process the result
			list.forEach(p->{
				System.out.println(p.getPid()+" "+p.getPname()+" "+p.getPrice()+" "+p.getQty());
			});
			
		 }//try
		catch(HibernateException he){
			he.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
