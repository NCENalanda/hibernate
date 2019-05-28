package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Student;
import com.nt.utility.HibernateUtil;

public class OptimisticLockTest1 {

	public static void main(String[] args) {
		Session ses=null;
		Student st=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//load and modify
		try{
			st=ses.get(Student.class,101);
			try{
				Thread.sleep(40000);
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
			tx=ses.beginTransaction();
			  st.setAddress("hyd114");
			flag=true;
		}//try
		catch(HibernateException e){
			flag=false;
			e.printStackTrace();
		}
		catch(Exception e){
			flag=false;
			e.printStackTrace();
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("Client1:: Object modified");
			}
			else{
				tx.rollback();
				System.out.println("Client1:: Object not modified");
			}
		  //close Session
			HibernateUtil.closeSession(ses);
		}//finally
		HibernateUtil.closeSessionFactory();
	}//main
}//class
