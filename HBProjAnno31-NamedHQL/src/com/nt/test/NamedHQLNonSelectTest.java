package com.nt.test;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.nt.utility.HibernateUtil;

public class NamedHQLNonSelectTest {
  public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		Transaction tx=null;
		boolean flag=false;
		int result=0;
		// Get Session
		ses=HibernateUtil.getSession();
		try{
		  tx=ses.beginTransaction();
		  //get Access Named HQL query
		  query=ses.getNamedQuery("UPDATE_TO_GST_PRICE");
		  //set param values
		  query.setFloat("startRange",10000);
		  //execute the Query
		  result=query.executeUpdate();
		  flag=true;
		 }//try
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
				System.out.println("no.of records effected"+result);
			}
			else{
				tx.rollback();
			}
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
