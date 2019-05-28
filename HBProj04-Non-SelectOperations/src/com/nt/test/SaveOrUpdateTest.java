package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.Product;

public class SaveOrUpdateTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Product prod=null; 
		Transaction tx=null;
		//Bootstrap hibernate
		cfg=new Configuration();
		//load Cfg file
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//Build Sesssion Factory
		factory=cfg.buildSessionFactory();
		//create Session
		ses=factory.openSession();
		//Save or update Object
		prod=new Product();
		prod.setPid(1001);
		prod.setPname("chair1");
		prod.setPrice(7499);
		prod.setQty(0);
		try{
		 tx=ses.beginTransaction();
		   ses.saveOrUpdate(prod);
         tx.commit();
         System.out.println("Object is inserted/updated");
		}
		catch(Exception e){
			tx.rollback();
			System.out.println("Object is not inserted/updated");
		}
		
		//close objs
		ses.close();
		factory.close();
	}//main
}//class
