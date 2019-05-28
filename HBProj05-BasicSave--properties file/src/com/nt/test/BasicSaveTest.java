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
		//add mapping file
		cfg.addFile("src/com/nt/cfgs/Employee.hbm.xml");
		//build SessionFactory
	factory=cfg.buildSessionFactory();
		//open Session
		ses=factory.openSession();
			//prepare Domain class obj having data
		details=new EmpDetails();
		 details.setNo(9121);
		 details.setFname("raja31");
		 details.setLname("rao23");
		 details.setMail("rao@gmail.com");
		 //save object
		ses.save(details);
		ses.flush();
		
//		//close objs
		ses.close();
		factory.close();
	}//main
}//class
