package com.nt.test;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.BankTxDetails;
import com.nt.utility.HibernateUtil;

public class GeneratorTest1_GUID_UUID {
	public static void main(String[] args) {
		Session ses=null;
		boolean flag=false;
		Transaction tx=null;
		BankTxDetails txDetails=null,txDetails1=null;
		String idVal=null;
		//get Session
		ses=HibernateUtil.getSession();
		try{
		//begin Tx
		 tx=ses.beginTransaction();
		 //prepare Domain  class obj
		 txDetails=new BankTxDetails();
		 txDetails.setTxName("WithDraw");
		 txDetails.setTxAmount(5000);
		 txDetails.setTxDate(new Date());
         idVal=(String)ses.save(txDetails);
         System.out.println("id Value(1)::"+idVal);
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
			if(flag==true)
				tx.commit();
			else
				tx.rollback();
			
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally

	}//main
}//class
