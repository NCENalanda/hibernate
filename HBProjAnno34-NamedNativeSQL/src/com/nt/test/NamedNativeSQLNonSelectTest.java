package com.nt.test;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.StandardBasicTypes;

import com.nt.domain.Employee;
import com.nt.utilty.HibernateUtil;

public class NamedNativeSQLNonSelectTest {
	public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		int count=0;
		Transaction tx=null;
		boolean flag=false;
		
		//get Session
		ses=HibernateUtil.getSession();
		try{
		 tx=ses.beginTransaction();
		  //get Access to Named Native SQL Query
		  query=ses.getNamedQuery("UPDATE_EMP");
		  query.setInteger("id", 1103);
		  query.setString("lname","chari");
		  //execute the query
		  count=query.executeUpdate();
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
				System.out.println("Record updated");
			}
			else{
				tx.rollback();
				System.out.println("Record not updated");
			}
				
		 HibernateUtil.closeSession(ses);
		 HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
