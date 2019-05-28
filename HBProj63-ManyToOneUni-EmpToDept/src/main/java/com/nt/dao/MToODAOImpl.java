package com.nt.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Department;
import com.nt.domain.EmpDetails;
import com.nt.utility.HibernateUtil;

public class MToODAOImpl implements MToODAO {

	@Override
	public void saveDataUsingEmployee() {
		Session ses=null;
		EmpDetails emp1=null,emp2=null;
		Department dept=null;
		boolean flag=false;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prpeare objects
		emp1=new EmpDetails();
		emp1.setEmpName("jani");
		emp1.setSalary(9000);
		emp2=new EmpDetails();
		emp2.setEmpName("rani");
		emp2.setSalary(10000);
		
		dept=new Department();
		dept.setDeptName("Accounts");
		dept.setDeptHead("KING");
		//add parent to childs
		emp1.setDept(dept); emp2.setDept(dept);
		try{
		 //begin Transaction
			tx=ses.beginTransaction();
              ses.save(emp1);
              ses.save(emp2);
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
			if(flag==true){
				tx.commit();
				System.out.println("chids and parent objs are saved(child->parent)");
			}
			else{
				tx.rollback();
				System.out.println("chids and parent objs are not saved(child->parent)");
			}
			//close session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void listDataUsingEmployee() {
		Session ses=null;
		List<EmpDetails> list=null;
		Query query=null;
		
		
		//get Session
		ses=HibernateUtil.getSession();
		try{
		//prepare Query object
		query=ses.createQuery("from EmpDetails");
		//execute HQL Query
		list=query.list();
		//process the List
		list.forEach(emp->{
		 System.out.println("child-->"+emp.getEmpNo()+" "+emp.getEmpName()+" "+emp.getSalary());
		 //get get Associated parent
		  Department dept=emp.getDept();
		  System.out.println("parent-->"+dept.getDeptNo()+" "+dept.getDeptName()+" "+dept.getDeptHead());
		});
		}
		catch(HibernateException he){
			throw he;
		}
		catch(Exception e){
			throw e;
		}
		finally{
			//close session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void addNewEmployeetoExistingDept() {
		Session ses=null;
		Transaction tx=null;
		Department dept=null;
		boolean flag=false;
		EmpDetails emp=null;
		//Get SEssion
		ses=HibernateUtil.getSession();
		//load existing parent
		dept=ses.get(Department.class,1001);
		//create new Child
		emp=new EmpDetails();
		emp.setEmpName("ramesh");
		emp.setSalary(8000);
		//add existing parent to child
		emp.setDept(dept);
		try{
		 tx=ses.beginTransaction();
		   ses.save(emp);
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
			if(flag==true){
				tx.commit();
				System.out.println("new child is added existing parent");
			}
			else{
				tx.rollback();
				System.out.println("new child is not added  to existing parent");
			}
			//close session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void transferEmpFromOneDeptToAnotherDept() {
		Session ses=null;
		Transaction tx=null;
		Department dept=null;
		boolean flag=false;
		EmpDetails emp=null;
		//Get SEssion
		ses=HibernateUtil.getSession();
		//load Existing child
		emp=ses.get(EmpDetails.class,5);
		//get existing dest Dept
		dept=ses.get(Department.class, 1000);
		try{
		 tx=ses.beginTransaction();
		  //add eexisting dept to existing emp 
		    emp.setDept(dept);
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
			if(flag==true){
				tx.commit();
				System.out.println("Employee Transffered");
			}
			else{
				tx.rollback();
				System.out.println("Employee not transffered");
			}
			//close session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void deleteAllEmployeesAndItsDepartment() {
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		Department dept=null;
		boolean flag=false;
		Query query=null;
		List<EmpDetails> list=null;
		//prepare Query
		query=ses.createQuery("from EmpDetails where dept.deptNo=?");
		//set param vlaue
		query.setInteger(0,1001);
		//execute Query 
		list=query.list();
		try{
		 tx=ses.beginTransaction();
		   list.forEach(emp->{
			   ses.delete(emp);
		   });
		  
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
			if(flag==true){
				tx.commit();
				System.out.println("Employee Transffered");
			}
			else{
				tx.rollback();
				System.out.println("Employee not transffered");
			}
			//close session
			HibernateUtil.closeSession(ses);
		}//finally
		
	}
	
	@Override
	public void deleteOneEmployeeFromDepartment() {
		Session ses=null;
		EmpDetails emp=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//Load child
		emp=ses.get(EmpDetails.class,2);
		emp.setDept(null);
		try{
		 tx=ses.beginTransaction();
		   ses.delete(emp);
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
			if(flag==true){
				tx.commit();
				System.out.println("One Emp from Department is deleted");
			}
			else{
				tx.rollback();
				System.out.println("One Emp from Department is not deleted");
			}
			//close session
			HibernateUtil.closeSession(ses);
		}//finally
	}
	
	@Override
	public void deleteOneEmployeeFromDepartmentWithHQL() {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Query query=null;
		int count=0;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare Query
		query=ses.createQuery("delete from EmpDetails where empno=:id");
		query.setInteger("id",5);
		//Load child
		try{
		 tx=ses.beginTransaction();
           count=query.executeUpdate();
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
			if(flag==true){
				tx.commit();
				System.out.println(count+"records are deleted");
			}
			else{
				tx.rollback();
				System.out.println("Record not deleted");
			}
			//close session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
}//class
