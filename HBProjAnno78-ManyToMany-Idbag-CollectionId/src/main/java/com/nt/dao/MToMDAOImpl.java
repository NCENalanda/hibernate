package com.nt.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Programmer;
import com.nt.domain.Project;
import com.nt.utility.HibernateUtil;

public class MToMDAOImpl implements MToMDAO {

	@Override
	public void saveDataUsingProgrammer() {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Programmer prgmr1=null,prgmr2=null;
		Project proj1=null,proj2=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		prgmr1=new Programmer();
		prgmr1.setPname("raja"); prgmr1.setSalary(9000);
		prgmr2=new Programmer();
		prgmr2.setPname("ravi"); prgmr2.setSalary(8000);
		
		proj1=new Project();
		proj1.setProname("OpenFx");
		
		proj2=new Project();
		proj2.setProname("CitiBank");
		
		//add Programmers to Projects
		prgmr1.getProjects().add(proj1);
		prgmr2.getProjects().add(proj1);
		prgmr2.getProjects().add(proj2);
		try{
		  tx=ses.beginTransaction();
		   //parent to child
		    ses.save(prgmr1);
		    ses.save(prgmr2);
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
			if(flag==true){
				tx.commit();
				System.out.println("records are saved (parent-child)");
			}
			else{
				tx.rollback();
				System.out.println("records are not saved (child-parent)");
			}
			//close Session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void saveDataUsingProjects() {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Programmer prgmr1=null,prgmr2=null;
		Project proj1=null,proj2=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare objects
		prgmr1=new Programmer();
		prgmr1.setPname("jani"); prgmr1.setSalary(9000);
		prgmr2=new Programmer();
		prgmr2.setPname("rani"); prgmr2.setSalary(8000);
		
		proj1=new Project();
		proj1.setProname("AMEX");
		
		proj2=new Project();
		proj2.setProname("Amerprise");
		
		//add Programmers to Projects
		proj1.getProgrammers().add(prgmr1);
		proj1.getProgrammers().add(prgmr2);
		proj2.getProgrammers().add(prgmr2);
		try{
		  tx=ses.beginTransaction();
		   //child to parent
		    ses.save(proj1);
		    ses.save(proj2);
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
			if(flag==true){
				tx.commit();
				System.out.println("records are saved (parent-child)");
			}
			else{
				tx.rollback();
				System.out.println("records are not saved (child-parent)");
			}
			//close Session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
}//class
