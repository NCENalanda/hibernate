package com.nt.test;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.PrgmrProjId;
import com.nt.domain.ProgrammerProjectInfo;
import com.nt.utility.HibernateUtil;

public class CompositePKInsertTest {

	public static void main(String[] args) {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		ProgrammerProjectInfo info=null;
		PrgmrProjId id=null,idVal=null;
	  //get Session
		ses=HibernateUtil.getSession();
	   try{
		 tx=ses.beginTransaction();
		 //save object
		  id=new PrgmrProjId();
		  id.setPrgmrId(103); id.setProjId(1002);
		  info=new  ProgrammerProjectInfo();
		  info.setId(id);
		  info.setPrgmrName("raja");info.setProjName("openFx");
		  info.setStatus("maintence");
		  
		  idVal=(PrgmrProjId)ses.save(info);
		  System.out.println("Compposite PK ID value::"+idVal.getPrgmrId()+"<-->"+idVal.getProjId());
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
		   if(flag==true){
			   tx.commit();
			   System.out.println("Object saved");
		   }
		   else {
			   tx.rollback();
			   System.out.println("Object not saved");
		   }
		   //close objs
		   HibernateUtil.closeSession(ses);
		   HibernateUtil.closeSessionFactory();
	   }//finally
		
	}//main
}//class
