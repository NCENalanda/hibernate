package com.nt.test;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Project;
import com.nt.utility.HibernateUtil;

public class FirstLevelCacheTest2 {

	public static void main(String[] args) {
		Session ses=null;
		Project proj=null,proj1=null;
		Transaction tx=null;
		boolean flag=false;
		try{
		//get Session
		ses=HibernateUtil.getSession();
		//Load object
		proj=ses.get(Project.class,1001);
		System.out.println(proj.getProjectId()+"  "+proj.getProjName()+" "+proj.getClient()+" "+proj.getTeamSize()+" "+proj.getStartDate());
		if(proj!=null){
		  tx=ses.beginTransaction();
		    proj.setTeamSize(20);//change1
		    proj.setClient("YesBank");  //change2
		    proj.setTeamSize(14);  //change3
		    flag=true;
    		}//f
		}//try
		catch(HibernateException e){
			flag=false;
			 e.printStackTrace();
		}
		catch(Exception e){
			flag=false;
			e.printStackTrace();
		}
		finally{
			if(flag==true)
				tx.commit();
			else
				tx.rollback();
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
