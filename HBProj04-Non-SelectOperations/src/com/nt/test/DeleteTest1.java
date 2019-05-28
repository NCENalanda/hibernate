package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.Product;

public class DeleteTest1 {

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
	  //Load and Delete object (Version2)
      prod=ses.load(Product.class,1002);
      System.out.println("after Loading");
       if(prod!=null){
		try{
		 tx=ses.beginTransaction();
		   ses.delete(prod);
		 tx.commit();
		 System.out.println("Object deleted");
		}
		catch(Exception e){
			tx.rollback();
			e.printStackTrace();
			System.out.println("object not deleted");
		}
       }
       else{
    	   System.out.println("Object not found");
       }

		/*//Load and Delete object (Version2-Ext)
		  prod=ses.get(Product.class,1002);
	       if(prod!=null){
	    	   ses.delete(prod);
	    	   ses.flush();
	    	   System.out.println("Object deleted");
	       }
	       else{
	    	   System.out.println("Object not found");
	       }
	       System.out.println(prod.hashCode());
	       System.out.println(prod.getPid()+" "+prod.getPname());*/
	
		//close objs
		ses.close();
		factory.close();
	}//main
}//class
