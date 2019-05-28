package com.nt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

import com.nt.service.CustomJdbcConnetionProvider;

public class HibernateUtil {
	private static SessionFactory factory;
	static{
	  Configuration cfg=null;	
	  StandardServiceRegistryBuilder builder=null;
	  StandardServiceRegistry registry=null;
	  CustomJdbcConnetionProvider conProvider=null;
	   //Bootstraping of Hibenrate
	  cfg=new Configuration();
	  //load both XML file(cfg file)
	  cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
	  //create ServieRegistryBuilder
	  builder=new StandardServiceRegistryBuilder();
	  //create Custome Service class object
	  conProvider=new CustomJdbcConnetionProvider();
	  builder.addService(ConnectionProvider.class,conProvider);
	  //create SErviceRegistry
	  registry=builder.applySettings(cfg.getProperties()).build();
	  //build HB SessionFactory
	  factory=cfg.buildSessionFactory(registry);
	  //factory=cfg.buildSessionFactory();
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
