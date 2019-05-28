package com.nt.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory factory;
	private static ThreadLocal<Session> threadLocal=new ThreadLocal();
	
	static{
		try{
		//create SessionFactory object
		factory=new Configuration().configure("/com/nt/cfgs/hibernate.cfg.xml").buildSessionFactory();
		}
		catch(HibernateException he){
			he.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Session getSession(){
		Session ses=null;
		if(threadLocal.get()==null){
			ses=factory.openSession();
			threadLocal.set(ses);
			return ses;
		}
		else{
			ses=threadLocal.get();
			return ses;
		}
	}//getSession()
	
	public static void closeSession(){
		Session ses=null;
		if(threadLocal.get()!=null){
			ses=threadLocal.get();
			  ses.close();
			  threadLocal.remove();
		}
	}//closeSession()
	
	public static  void closeSessionFactory(){
		 if(factory!=null)
			 factory.close();
	}//closeSessionFactory()
}//class
