package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;

public class BasicSaveTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		EmpDetails details=null;
		Transaction tx=null;
		int idVal=0;
		
		//activate Hibernate framework (BootStrapping hibernate)
		cfg=new Configuration();
		
		//load and read both xml file
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//cfg=cfg.configure();
		
		//build SessionFactory
	factory=cfg.buildSessionFactory();
		//open Session
		ses=factory.openSession();
			//prepare Domain class obj having data
		details=new EmpDetails();
		 details.setNo(9);
		 details.setFname("raja");
		 details.setLname("rao");
		 details.setMail("rao@gmail.com");
		 
		try{
		//begin Transaction
			tx=ses.beginTransaction(); //internally uses  con.setAutoCommit(false)
			  //save object
			 idVal=(Integer)ses.save(details);
			 System.out.println("Generated Id Value::"+idVal);
			//commit Transaction
			tx.commit();  //internally uses con.commit();
			System.out.println("Object saved (insert record)");
		}
		catch(Exception e){
			tx.rollback(); //internally uses con.rollback()
			System.out.println("obj not saved(record not inserted)");
		}
		
//		//close objs
		ses.close();
		factory.close();
	}//main
}//class
