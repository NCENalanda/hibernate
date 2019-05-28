package com.nt.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.College;
import com.nt.domain.University;
import com.nt.utility.HibernateUtil;

public class ManyToOneDAOImpl implements ManyToOneDAO {

	@Override
	public void saveDataUsingCollege() {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		College clg1=null,clg2=null;
		University university=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		clg1=new College();
		clg1.setName("CBIT");
		clg1.setAddrs("GandiPet");
		
		clg2=new College();
		clg2.setName("JBIT");
		clg2.setAddrs("MoinaBad");
		
		university=new University();
		university.setName("JNTUH");
		university.setRegion("Telgana");
		//add Parent to childs
		clg1.setUniversity(university);
		clg2.setUniversity(university);
		try{
		 tx=ses.beginTransaction();	
			ses.save(clg1);
			ses.save(clg2);
		flag=true;	
		}
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
				System.out.println("objects are saved");
			}
			else{
				tx.rollback();
				System.out.println("objects are not saved");
			}
          HibernateUtil.closeSession();		
		}
	}//method
	
	@Override
	public void loadDataUsingCollege() {
		Session ses=null;
		List<College> list=null;
		Query query=null;
		//get Session
		ses=HibernateUtil.getSession();
		query=ses.createQuery("from College");
		try{
		  //execute Query
		  list=query.list();
		 /* list.forEach(clg->{
			  System.out.println("child--->"+clg.getCollegeId()+" "+clg.getName()+" "+clg.getAddrs());
			  University unst=clg.getUniversity();
			  System.out.println("parent--->"+unst.getUnstId()+" "+unst.getName()+" "+unst.getRegion());
		  });*/
		}
		catch(HibernateException he){
			throw he;
		}
		catch(Exception e){
			throw e;
		}
		finally{
          HibernateUtil.closeSession();		
		}
	}//method
	
}//class
