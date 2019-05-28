package com.nt.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.nt.utility.HibernateUtil;

@WebListener
public class HBSessionFactoryCloserServletContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("HBSessionFactoryCloserServletContextListener::contextInitalized(-)");
		try{
		  Class.forName("com.nt.utility.HibernateUtil");
		}
		catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("HBSessionFactoryCloserServletContextListener::contextDestroyed(-)");
		HibernateUtil.closeSessionFactory();
	}
	
}//class
