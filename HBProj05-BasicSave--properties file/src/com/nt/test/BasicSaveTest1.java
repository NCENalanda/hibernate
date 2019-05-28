package com.nt.test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;

public class BasicSaveTest1 {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		EmpDetails details=null;
		Transaction tx=null;
		int idVal=0;
		InputStream is=null;
		Properties props=null;
		try{
		//locate properties file
		is=new FileInputStream("src/com/nt/commons/bundle.properties");
		//load proeprties file contentent to java.util.Properties obj
		props=new Properties();
		props.load(is);
		}//try
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		//activate Hibernate framework (BootStrapping hibernate)
		cfg=new Configuration();
		//set hibernate cfg proeprties
		cfg.setProperties(props);
		//add mapping file
		cfg.addFile("src/com/nt/cfgs/Employee.hbm.xml");
		//build SessionFactory
	factory=cfg.buildSessionFactory();
		//open Session
		ses=factory.openSession();
			//prepare Domain class obj having data
		details=new EmpDetails();
		 details.setNo(9122);
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
