package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;

public class PersistTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		EmpDetails details=null;
		Transaction tx=null;
		//activate/Boot strap hibernate
		cfg=new Configuration();
		//read hibernate cfg file
		cfg=cfg.configure("com/nt/cfgs/hibernate.cfg.xml");
		//buildSessionFactory
		factory=cfg.buildSessionFactory();
		//Create Session session
		ses=factory.openSession();
		//prepare object
		details=new EmpDetails();
		details.setNo(7678); details.setFname("Ramesh");
		details.setLname("rao"); details.setMail("rao@gmail.com");
		/*try{
		// beginTransaction
		 tx=ses.beginTransaction();
		   ses.persist(details);
         tx.commit();
         System.out.println("Object is persisted");
		}
		catch(Exception e){
			tx.rollback();
		 System.out.println("Object is not persisted");
		 e.printStackTrace();
		}*/
		
		/*ses.persist(details);
		 ses.flush();
		*/ 
		
		
		
		//close objs
		ses.close();
		factory.close();
	}//main
}//class
