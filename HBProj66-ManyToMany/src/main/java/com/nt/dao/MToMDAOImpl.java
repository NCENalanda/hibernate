package com.nt.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
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
		/*proj1.getProgrammers().add(prgmr1);
		proj1.getProgrammers().add(prgmr2);
		proj2.getProgrammers().add(prgmr2);*/
		//add Projects to Programmers
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
	
	@Override
	public void loadDataUsingProgrammer() {
		Session ses=null;
		Transaction tx=null;
		List<Programmer>  list=null;
		Query query=null;
		//get Session
		ses=HibernateUtil.getSession();
		try{
		 //prepare Qyery	
		  query=ses.createQuery("from Programmer");
		  list=query.list();
		  list.forEach(prgmr->{
			  System.out.println("parent-->"+prgmr.getPid()+" "+prgmr.getPname()+" "+prgmr.getSalary());
			  //get Associated childs
			  Set<Project> childs=prgmr.getProjects();
			  childs.forEach(proj->{
				System.out.println("child--->"+proj.getProid()+" "+proj.getProname());  
			  });
		  });
		}
		catch(HibernateException he){
			he.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			HibernateUtil.closeSession(ses);
		}
	}//method
	
	@Override
	public void loadDataUsingProject() {
		Session ses=null;
		Transaction tx=null;
		List<Project>  list=null;
		Query query=null;
		//get Session
		ses=HibernateUtil.getSession();
		try{
		 //prepare Qyery	
		  query=ses.createQuery("from Project");
		  list=query.list();
		  list.forEach(proj->{
				System.out.println("child--->"+proj.getProid()+" "+proj.getProname());  
			  //get Associated childs
			  Set<Programmer> childs=proj.getProgrammers();
			  childs.forEach(prgmr->{
				  System.out.println("parent-->"+prgmr.getPid()+" "+prgmr.getPname()+" "+prgmr.getSalary());
			  });
		  });
		}
		catch(HibernateException he){
			he.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			HibernateUtil.closeSession(ses);
		}
	}//method
	
	@Override
	public void assingExisitingProjectsToExistingProgrammer() {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Programmer prgmr=null;
		Project proj1=null,proj2=null;
		Set<Project> childs=null;
		//get Session
		ses=HibernateUtil.getSession();
		//Load exisiting Programmer
		prgmr=ses.get(Programmer.class,1);
		//get All Projects of the above Programmer
		childs=prgmr.getProjects();
		//Load Existing two projects
		proj1=ses.get(Project.class,1004);
		proj2=ses.get(Project.class,1005);
		try{
			  tx=ses.beginTransaction();
			  //Add above projects  Set collection
			  childs.add(proj1);
			  childs.add(proj2);
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
					System.out.println("Existing Projects are added to existing programmer");
				}
				else{
					tx.rollback();
					System.out.println("Existing Projects are not added to existing programmer");
				}
				//close Session
				HibernateUtil.closeSession(ses);
			}//finally
	}//method
	
	@Override
	public void interChangeProjectsOfProgrammers() {
		Session ses=null;
		Transaction tx1=null,tx2=null;
		boolean flag1=false,flag2=false;
		Programmer prgmr1=null,prgmr2=null;
		Project proj1=null,proj2=null;
		Set<Project> projChilds1=null,projChilds2=null;
		Set<Programmer> prgmrChilds=null;
		//get Session
		ses=HibernateUtil.getSession();
		//Load exisiting Programmers
		prgmr1=ses.get(Programmer.class,1);
		prgmr2=ses.get(Programmer.class,4);
		//Load existing Projects of Programmers
		projChilds1=prgmr1.getProjects();
		projChilds2=prgmr2.getProjects();
		//Load sepecific Projects from cache
		proj1=ses.get(Project.class, 1029);
		//proj1.setProgrammers(null);
		proj2=ses.get(Project.class, 1031);
		  //proj2.setProgrammers(null);
		try{
		  tx1=ses.beginTransaction();	
		  //trasnfer projects
		  projChilds2.add(proj1);
		  projChilds1.add(proj2);
		  flag1=true;
		}//try
		catch(HibernateException he){
			flag1=false;
			throw he;
		}
		catch(Exception e){
			flag1=false;
			throw e;
		}
		finally{
			if(flag1==true){
				tx1.commit();
				System.out.println("Projects are added to trasnfer");
			}
			else{
				tx1.rollback();
				System.out.println("Projects are not added to Transffer");
			}
		}//finally
		try{
		  tx2=ses.beginTransaction();	
		  //trasnfer projects
		  projChilds2.remove(proj2);
		  projChilds1.remove(proj1);
		  flag2=true;
		}
		catch(HibernateException he){
			flag2=false;
			throw he;
		}
		catch(Exception e){
			flag2=false;
			throw e;
		}
		finally{
			if( flag2==true){
				tx2.commit();
				System.out.println("Projects are rmeoved to transffer");
			}
			else{
				tx2.rollback();
				System.out.println("Projects are not removed to Transffer");
			}
		}//finally
		
	}//method
	
	@Override
	public void deleteAllProgrammersOfAProject() {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Project proj=null;
		Set<Programmer> parents=null;
		//get SEssion
		ses=HibernateUtil.getSession();
		//load Project (child)
		proj=ses.get(Project.class,1031);
		//Load Programmer of the above project
		parents=proj.getProgrammers();
		try{
			  tx=ses.beginTransaction();
			   parents.clear();
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
				if( flag==true){
					tx.commit();
					System.out.println("All Programmers of A Project deleted");
				}
				else{
					tx.rollback();
					System.out.println("All Programmers of A Project not deleted");
				}
			}//finally
	}//method
	
}//class
