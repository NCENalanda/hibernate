package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.Product;

public class MergetTest {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Product prod=null,prod1; 
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
		prod.setPid(561);
		prod.setPname("plastic chair1");
		prod.setPrice(74991);
		prod.setQty(201);
		try{
		 tx=ses.beginTransaction();
		 prod1=(Product) ses.merge(prod);
		 System.out.println("Prod1-->"+prod1.getPid()+" "+prod1.getPname()+" "+prod1.getQty()+" "+prod1.getPrice());
         tx.commit();
         System.out.println("Object is inserted/updated");
		}
		catch(Exception e){
			tx.rollback();
			e.printStackTrace();
			System.out.println("Object is not inserted/updated");
		}
		
		//close objs
		ses.close();
		factory.close();
	}//main
}//class
