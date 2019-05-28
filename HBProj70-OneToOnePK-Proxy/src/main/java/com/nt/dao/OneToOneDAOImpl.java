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
	
	@Override
	public void loadDataUsingStudent() {
		Session ses=null;
		ses=HibernateUtil.getSession();
		boolean flag=false;
		List<Student>  list=null;
		Query query=null;
		//prepare query
		query=ses.createQuery("from Student");
		try{
		 list=query.list();	
		 list.forEach(st->{
			System.out.println("parent-->"+st.getSid()+" "+st.getName()+" "+st.getAddress());
			LibraryMembership lib=st.getLibraryDetails();
			System.out.println("child-->"+lib.getLid()+" "+lib.getDoj());
		 });
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
		 //close Session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void loadDataUsingLibraryMembership() {
		Session ses=null;
		ses=HibernateUtil.getSession();
		boolean flag=false;
		List<LibraryMembership>  list=null;
		Query query=null;
		//prepare query
		query=ses.createQuery("from LibraryMembership");
		try{
		 list=query.list();	
		 list.forEach(lib->{
			System.out.println("child-->"+lib.getLid()+" "+lib.getDoj());
			Student st=lib.getStudentDetails();
			System.out.println("parent-->"+st.getSid()+" "+st.getName()+" "+st.getAddress());
		 });
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
		 //close Session
			HibernateUtil.closeSession(ses);
		}//finally
		
	}//method
	
	@Override
	public void deleteDataUsingStudent() {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		Student st=null;
		//load Pearent obj
		st=ses.get(Student.class,1);
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 ses.delete(st);
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
				System.out.println("Obj is deleted(p->c)");
			}
			else{
				tx.rollback();
				System.out.println("Objs is not deleted(p->c)");
			}
		 //close Session
			HibernateUtil.closeSession(ses);
		}//finally
		
	}//method
	
	@Override
	public void deleteDataUsingLibraryMembership() {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		LibraryMembership lib=null;
		//load Pearent obj
		lib=ses.get(LibraryMembership.class,2);
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 ses.delete(lib);
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
				System.out.println("Obj is deleted(c->p)");
			}
			else{
				tx.rollback();
				System.out.println("Objs is not deleted(c->p)");
			}
		 //close Session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	@Override
	public void deleteOnlyLibaryMemebership() {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
        Query query=null;
        int count=0;
		//load Pearent obj
		query=ses.createQuery("delete from LibraryMembership where lid=:id");
		query.setInteger("id",3);
		try{
		 tx=ses.beginTransaction();
		 count=query.executeUpdate();
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
				System.out.println("Only Child Obj is deleted::"+count);
			}
			else{
				tx.rollback();
				System.out.println("Only child is not deleted");
			}
		 //close Session
			HibernateUtil.closeSession(ses);
		}//finally
		
	}//method
	
}//class
