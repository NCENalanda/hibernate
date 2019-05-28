package com.nt.test;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.PrgmrProjId;
import com.nt.domain.ProgrammerProjectInfo;
import com.nt.utility.HibernateUtil;

public class CompositePKSelectTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		ProgrammerProjectInfo info=null;
		PrgmrProjId id=null;
	  //get Session
		ses=HibernateUtil.getSession();
	   try{
		 //save object
		  id=new PrgmrProjId();
		  id.setPrgmrId(101); id.setProjId(1002);
		  
		  info=ses.get(ProgrammerProjectInfo.class,id);
		  System.out.println(info.getId().getPrgmrId()+" "+info.getId().getProjId()+" "+info.getPrgmrName()+" "+info.getProjName()+" "+info.getStatus());
		 flag=true;
	   }
	   catch(HibernateException he){
		   he.printStackTrace();
		   flag=false;
	   }
	   catch(Exception e){
		   e.printStackTrace();
		   flag=false;
	   }
	   finally{
		   //close objs
		   HibernateUtil.closeSession(ses);
		   HibernateUtil.closeSessionFactory();
	   }//finally
		
	}//main
}//class
