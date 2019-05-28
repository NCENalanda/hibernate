package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.Product;

public class DeleteTest {

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
		/*//Delete object (Version1)
		prod=new Product();
		prod.setPid(1001);
		try{
		 tx=ses.beginTransaction();
		   ses.delete(prod);
		 tx.commit();
		 System.out.println("Object deleted");
		}
		catch(Exception e){
			tx.rollback();
			e.printStackTrace();
			System.out.println("object not found");
		}*/
		
		//Deleete obj (Version1 -Ext)
		prod=new Product();
		prod.setPid(1001);
		ses.delete(prod);
		ses.flush();
		
		//close objs
		ses.close();
		factory.close();
	}//main
}//class
