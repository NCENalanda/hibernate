package com.nt.dao;

import org.hibernate.Transaction;
import org.hibernate.Session;

import com.nt.bo.StudentBO;
import com.nt.utility.HibernateUtil;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public int insert(StudentBO bo) {
	   Session ses=null;
	   Transaction tx=null;
	   int id=0;
	   //get Session
	   ses=HibernateUtil.getSession();
	   try{
		 tx=ses.beginTransaction();
	       id=(int)ses.save(bo);
	     tx.commit();
	     return id;
	   }//try
	   catch(Exception e){
		   tx.rollback();
		   throw e;
	   }
	   finally{
		   HibernateUtil.closeSession();
	   }
	
	}//method
}//class
