package com.nt.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.nt.utility.HibernateUtil;

public class MyScListener implements ServletContextListener {

	 public   void contextInitialized( ServletContextEvent sc){
		 System.out.println("contextInitialized");
		 try{
	       Class.forName("com.nt.utility.HibernateUtil");
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	   }
	   public   void contextDestroyed( ServletContextEvent sc){
		   System.out.println("contextDestroyed(-)");
	       HibernateUtil.closeSessionFactory();
	   }
	
}
