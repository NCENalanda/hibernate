package com.nt.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.LibraryMembership;
import com.nt.domain.Student;
import com.nt.utility.HibernateUtil;

public class OneToOneDAOImpl implements OneToOneDAO {

	@Override
	public void saveDataUsingStudent() {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		Student st=null;
		LibraryMembership lib=null;
		//prpeare object
		st=new Student();
		st.setName("raja");
		st.setAddress("hyd");
		
		lib=new LibraryMembership();
		lib.setDoj(new Date());
		//set p->c and c->p
		st.setLibraryDetails(lib);
		lib.setStudentDetails(st);
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 ses.save(st);
          flag=true;			
		}//try
		catch(HibernateException he){
			flag=false;
			throw he;
		}
		catch(Exception e){
			flag=false;
			throw e;
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("Objs are saved(p->c)");
			}
			else{
				tx.rollback();
				System.out.println("Objs are not saved(p->c)");
			}
		 //close Session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void saveDataUsingLibraryMembership() {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		Student st=null;
		LibraryMembership lib=null;
		//prpeare object
		st=new Student();
		st.setName("rani");
		st.setAddress("vizag");
		
		lib=new LibraryMembership();
		lib.setDoj(new Date());
		//set p->c and c->p
		st.setLibraryDetails(lib);
		lib.setStudentDetails(st);
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 ses.save(lib);
          flag=true;			
		}//try
		catch(HibernateException he){
			flag=false;
			throw he;
		}
		catch(Exception e){
			flag=false;
			throw e;
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("Objs are saved(c->p)");
			}
			else{
				tx.rollback();
				System.out.println("Objs are not saved(c->p)");
			}
		 //close Session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
}//class
