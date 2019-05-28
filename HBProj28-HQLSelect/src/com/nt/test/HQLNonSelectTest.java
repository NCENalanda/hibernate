package com.nt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Product;
import com.nt.utility.HibernateUtil;

public class HQLNonSelectTest {
  private static  final String HQL_DELETE_PRODUCTS_BY_PRICE_RANGE="delete from Product where price>=:start and price<=:end";
  public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		boolean flag=false;
		Transaction tx=null;
		
		
		// Get Session
		ses=HibernateUtil.getSession();
		try{
		 tx=ses.beginTransaction();
		/* //prepare Query
		 query=ses.createQuery(HQL_DELETE_PRODUCTS_BY_PRICE_RANGE);
		 //set param values
		 query.setFloat("start",100);
		 query.setFloat("end",2000);
		 int result=query.executeUpdate();
		  System.out.println("no.of records that effected::"+result);*/
		 
		 //prepare query  (error)
		 query=ses.createQuery("insert into Product values(:id,:name,:price,:qty)");
		 query.setInteger("id",1001);
		 query.setString("name","table");
		 query.setFloat("price",999.44f);
		 query.setInteger("qty",4);
		 int result=query.executeUpdate();
	     System.out.println("no.of records that effected::"+result);
		 
		 
		 flag=true;
		
         }//try
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
				
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
