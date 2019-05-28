package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.Product;

public class UpdateTest {

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
	/*	//Update object (Full object modification) (Version1)
		prod=new Product();
		prod.setPid(1001); //existing id
		prod.setPname("gold chair");
		prod.setPrice(4567);
		prod.setQty(20);
		try{
		 tx=ses.beginTransaction();
		   ses.update(prod);
         tx.commit();
         System.out.println("Object  updated");
		}
		catch(Exception e){
			tx.rollback();
			System.out.println("Object not updated");
		}*/
		//Version1 -Ext1
		prod=new Product();
		prod.setPid(1001); //existing id
		prod.setPname("chair1");
		prod.setPrice(7499);
		prod.setQty(0);
		ses.update(prod);
		ses.flush();
		System.out.println("Object  updated");
		
		//close objs
		ses.close();
		factory.close();
	}//main
}//class
