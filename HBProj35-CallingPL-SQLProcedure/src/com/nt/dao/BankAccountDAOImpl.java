package com.nt.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.nt.domain.BankAccount;
import com.nt.utility.HibernateUtil;

public class BankAccountDAOImpl implements BankAccountDAO {

	@Override
	public List<BankAccount> getAccountHoldersByBalanceRange(float startRange, float endRange) {
		 Session ses=null;
		 Query query=null;
		 List<BankAccount>  list=null;
		//get Session
		 ses=HibernateUtil.getSession();
		 try{
		//get Access to Named NativeSQL Query
		 query=ses.getNamedQuery("CALL_PROCEDURE");
		  //set values to Query params
		 query.setFloat("start",startRange);
		 query.setFloat("end",endRange);
		/* query.setFirstResult(1);
		 query.setMaxResults(10);*/
		 //execute Query/Call Procedure
		 list=query.list();
		 
		 return list;
		 }
		 catch(HibernateException  he){
			 he.printStackTrace();
			 return null;
		 }
		 catch(Exception e){
			 e.printStackTrace();
			 return null;
		 }
		 finally{
			//close Session
			HibernateUtil.closeSession(ses);
		 }
	}//method
}//class
