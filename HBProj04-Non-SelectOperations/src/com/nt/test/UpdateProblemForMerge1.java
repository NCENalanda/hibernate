package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.Product;

public class UpdateProblemForMerge1 {

	public static void main(String[] args) {
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Product prod1=null,prod2=null,prod3=null; 
		Transaction tx=null;
		//Bootstrap hibernate
		cfg=new Configuration();
		//load Cfg file
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//Build Sesssion Factory
		factory=cfg.buildSessionFactory();
		//create Session
		ses=factory.openSession();
		//load the object
		prod1=ses.get(Product.class, 4531);
	    
	    prod2=new Product();
		prod2.setPid(4531); 
	    prod2.setPname("telescope1"); prod2.setPrice(5561);
	    prod2.setQty(541);
		try{
		 tx=ses.beginTransaction();
		    prod1.setQty(456);
		    ses.save(prod2);
		   //ses.update(prod2);
		   //prod3=(Product)ses.merge(prod2);
		   //System.out.println("prod3::"+prod3);
		 tx.commit();
		 System.out.println(prod1.hashCode()+" "+prod2.hashCode()+" "+prod3.hashCode());
		}
		catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
		
		//close objs
		ses.close();
		factory.close();
	}//main
}//class
