package com.nt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	private static SessionFactory factory;
	static{
	  Configuration cfg=null;	
	  StandardServiceRegistryBuilder builder=null;
	  StandardServiceRegistry registry=null;
	   //Bootstraping of Hibenrate
	  cfg=new Configuration();
	  //load both XML file(cfg file)
	  cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
	  //build HB SessionFactory
	  factory=cfg.buildSessionFactory();
	}
	
	public static Session getSession(){
		Session ses=null;
		if(factory!=null)
			ses=factory.openSession();
		return ses;
	}
	
	public static void closeSessionFactory(){
		if(factory!=null)
			factory.close();
	}
	
	public static void closeSession(Session ses){
		 if(ses!=null)
		   ses.close();
	}

}
