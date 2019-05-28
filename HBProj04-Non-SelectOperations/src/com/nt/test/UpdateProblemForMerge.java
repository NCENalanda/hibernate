package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.Product;

public class UpdateProblemForMerge {

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
		//perform both save and update operations on Same record
		//Using single transaction and using two different objects.
		prod1=new Product();
		prod1.setPid(4531); 
	    prod1.setPname("telescope"); prod1.setPrice(456);
	    prod1.setQty(4);
	    
	    prod2=new Product();
	/*	prod2.setPid(4531); 
	    prod2.setPname("telescope"); prod2.setPrice(556);
	    prod2.setQty(54);*/
		try{
		 tx=ses.beginTransaction();
		   ses.save(prod1);
			prod2.setPid(4531); 
		    prod2.setPname("telescope"); prod2.setPrice(556);
		    prod2.setQty(54);
		   ses.update(prod2);
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
