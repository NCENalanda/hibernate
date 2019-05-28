package com.nt.test;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.BankTxDetails;
import com.nt.utility.HibernateUtil;

public class GeneratorTest1 {
	public static void main(String[] args) {
		Session ses=null;
		boolean flag=false;
		Transaction tx=null;
		BankTxDetails txDetails=null,txDetails1=null;
		int idVal=0;
		//get Session
		ses=HibernateUtil.getSession();
		try{
		//begin Tx
		 tx=ses.beginTransaction();
		 //prepare Domain  class obj
		 for(int i=1;i<=5;++i){
		 txDetails=new BankTxDetails();
		 txDetails.setTxName("WithDraw");
		 txDetails.setTxAmount(5000);
		 txDetails.setTxDate(new Date());
         idVal=(int)ses.save(txDetails);
         System.out.println("id Value(1)::"+idVal);
         //Thread.sleep(20000);
         flag=true;
		 }
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
