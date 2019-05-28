package com.nt.test;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.StandardBasicTypes;

import com.nt.domain.Employee;
import com.nt.utilty.HibernateUtil;

public class NamedNativeSQLSelectTest1 {
	public static void main(String[] args) {
        Configuration cfg=null;
        Transaction tx=null;
        Query query=null;
        int count=0;
		//create Configuration object
		cfg=new Configuration().configure("/com/nt/cfgs/hibernate.cfg.xml");
		try(SessionFactory factory=cfg.buildSessionFactory()){
			try(Session ses=factory.openSession()){
			 //begin tx
			  tx=ses.beginTransaction();
			    //get Access to Named Query
			  query=ses.getNamedQuery("UPDATE_EMP");
			  query.setString("lname","reddy1");
			  query.setInteger("id",1103);
			  count=query.executeUpdate();
			  tx.commit();
			  if(count==0)
				  System.out.println("Record not updated");
			  else
				  System.out.println("Record  updated");
			  
			}
		}
		catch(HibernateException he){
			he.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
	}//main
}//class
