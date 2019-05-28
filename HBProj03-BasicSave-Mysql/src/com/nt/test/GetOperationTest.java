package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;
import com.nt.domain.EmpDetailsInterface;

public class GetOperationTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		//EmpDetailsInterface details=null;
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
	//get the Object
		//details=(EmpDetailsInterface)ses.load(EmpDetailsInterface.class,8302);
		details=(EmpDetails)ses.load(EmpDetails.class,8302);
		System.out.println(details.getClass());
		System.out.println(details.getNo()+" "+details.getFname()+" "+details.getLname()+"  "+details.getMail());
		
//		//close objs
		ses.close();
		factory.close();
	}//main
}//class
