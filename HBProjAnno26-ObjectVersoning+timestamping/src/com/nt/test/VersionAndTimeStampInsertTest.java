package com.nt.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.BankAccount;
import com.nt.utility.HibernateUtil;

public class VersionAndTimeStampInsertTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		BankAccount account=null;
		long idVal=0;
		//get Session 
		ses=HibernateUtil.getSession();
		try{
		 tx=ses.beginTransaction();
		  //prepare object
		 account=new BankAccount();
		 account.setHolderName("maliya");
		 account.setType("non-Perfoming");
		 account.setBalance(90000000);
		 
		 idVal=(long)ses.save(account);
		 System.out.println("Account no::"+idVal);
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
			if(flag==true){
				tx.commit();
				System.out.println("Object saved");
			}
			else{
				tx.rollback();
				System.out.println("Object not saved");
			}
		 //close objects
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}///class
