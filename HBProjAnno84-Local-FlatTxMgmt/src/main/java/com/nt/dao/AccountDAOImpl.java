package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.utility.HibernateUtil;

public class AccountDAOImpl implements AccountDAO {
  private static final String HQL_WITHDRAW_QUERY="update Account set balance=balance-:amt where acno=:srcId";
  private static final String HQL_DEPOSITE_QUERY="update Account set balance=balance+:amt where acno=:destId";
    
	@Override
	public boolean transferMoney(int srcAcno, int destAcno, float amt) {
		Session ses=null;
		Query query1=null,query2=null;
		Transaction tx=null;
		boolean flag=false;
		int result1=0,result2=0;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare Queries
		query1=ses.createQuery(HQL_WITHDRAW_QUERY);
		query1.setFloat("amt",amt);
		query1.setInteger("srcId",srcAcno);
		
		query2=ses.createQuery(HQL_DEPOSITE_QUERY);
		query2.setFloat("amt",amt);
		query2.setInteger("destId",destAcno);
		try{
		 tx=ses.beginTransaction();
		   //execute query
		 result1=query1.executeUpdate();
		 result2=query2.executeUpdate();
		 if(result1==0 || result2==0)
			 flag=false;
		 else
			 flag=true;
		}//try
		catch(HibernateException  he){
			flag=false;
		}
		catch(Exception e){
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
		}
		return flag;
	}//method
}//class
