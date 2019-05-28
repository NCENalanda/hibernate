package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.MobileCustomer;
import com.nt.utility.MysqlHibernateUtil;
import com.nt.utility.OracleHibernateUtil;

public class MobileNumberPortabilityDAOImpl implements MobileNumberPortabilityDAO {

	@Override
	public boolean transfer(long mobileNo) {
		Session oraSes=null,mysqlSes=null;;
		MobileCustomer customer=null;
		boolean oraFlag=false,mysqlFlag=false,finalResultFlag=false;
		Transaction oraTx=null,mysqlTx=null;
		
		//get Oralcle Session
		oraSes=OracleHibernateUtil.getSession();
		//get MySQL Session
		mysqlSes=MysqlHibernateUtil.getSession();
		//get Object from Oracle
		customer=oraSes.get(MobileCustomer.class,mobileNo);
		//store object into MySQL
		try{
		 //	begin Tx
		  mysqlTx=mysqlSes.beginTransaction();
		   customer.setStatus("active");
		   mysqlSes.save(customer);
		  mysqlFlag=true;
		  oraTx=oraSes.beginTransaction();
		   oraSes.delete(customer);
		  oraFlag=true;
		}
		catch(HibernateException he){
		    oraFlag=false;
		    mysqlFlag=false;
		    throw he;
		}
		catch(Exception e){
			 oraFlag=false;
			    mysqlFlag=false;
			    throw e;
		}
		finally{
			if(oraFlag==false || mysqlFlag==false){
				oraTx.rollback();
				mysqlTx.rollback();
				System.out.println("MNP Failed");
				finalResultFlag=false;
			}
			else{
				oraTx.commit();
				mysqlTx.commit();	
				System.out.println("MNP succeded");
				finalResultFlag=true;
			}
			//close objects
			OracleHibernateUtil.closeSession(oraSes);
			MysqlHibernateUtil.closeSession(mysqlSes);
			//OracleHibernateUtil.closeSessionFactory();
			//MysqlHibernateUtil.closeSessionFactory();
		}//finally
		
		return finalResultFlag;
	}//method
}//class
