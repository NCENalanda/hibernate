package com.nt.test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;

public class BasicSaveTest3 {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		EmpDetails details=null;
		Transaction tx=null;
		int idVal=0;
		//activate Hibernate framework (BootStrapping hibernate)
		cfg=new Configuration();
        //add Programatic Approach		
		cfg.setProperty("hibernate.connection.driver_class","oracle.jdbc.driver.OracleDriver");
		cfg.setProperty("hibernate.connection.url","jdbc:oracle:thin:@localhost:1521:xe");
		cfg.setProperty("hibernate.connection.username","system1");
		cfg.setProperty("hibernate.connection.password","manager1");
		cfg.setProperty("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		cfg.setProperty("hibernate.show_sql","true");
		//add cfg file
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");

		//add mapping file
		cfg.addFile("src/com/nt/cfgs/Employee.hbm.xml");
		//build SessionFactory
	factory=cfg.buildSessionFactory();
		//open Session
		ses=factory.openSession();
			//prepare Domain class obj having data
		details=new EmpDetails();
		 details.setNo(9123);
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
