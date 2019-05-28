package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.TMCCustomer;
import com.nt.utility.HibernateUtil;

public class GeneratorsTest2 {

	public static void main(String[] args) {
		Session ses=null;
		boolean flag=false;
		Transaction tx=null;
		TMCCustomer customer=null;
		String idVal=null;
		//get Session
		ses=HibernateUtil.getSession();
		try{
		  //begin Transaction
			tx=ses.beginTransaction();
		  //create Domain class obj
			customer=new TMCCustomer();
			customer.setCustName("rajesh");
			customer.setCustAddrs("hyd");
			customer.setBillAmt(9000);
			//save Object
			idVal=(String)ses.save(customer);
			System.out.println("Generated Id value::"+idVal);
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
			if(flag==false){
				tx.rollback();
				System.out.println("Object not saved");
			}
			else{
				tx.commit();
				System.out.println("Object saved");
			}
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally

	}//main
}//class
