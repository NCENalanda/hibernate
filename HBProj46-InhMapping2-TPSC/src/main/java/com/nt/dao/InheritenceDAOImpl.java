package com.nt.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Customer;
import com.nt.domain.Employee;
import com.nt.domain.Person;
import com.nt.utility.HibernateUtil;

public class InheritenceDAOImpl implements InheritenceDAO {
  private static final String HQL_LOAD_USING_PERSON="from Person";
  private static final String HQL_LOAD_USING_EMPLOYEE="from Employee";
	@Override
	public String saveData() throws Exception {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		String resultMsg=null;
		Person  per=null;
		Employee  emp=null;
		Customer cust=null;
		//get Session
		ses=HibernateUtil.getSession();
		try{
		 tx=ses.beginTransaction();
		 //prepare and save objs
	/*	 per=new Person();
		 per.setName("raja"); per.setCompany("HCL");
	*/	 
		 emp=new Employee();
		 emp.setName("rani"); emp.setCompany("Wipro");
		 emp.setDesg("programmer"); emp.setSalary(90000);
		 
		 cust=new Customer();
		 cust.setName("jani"); cust.setAddrs("hyd");
		 cust.setBillAmt(9000); cust.setCompany("samsung");
		 //ses.save(per);
		 ses.save(emp);
		 ses.save(cust);
			
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
		   if(flag==false){
			   tx.rollback();
			  resultMsg="Objects Not saved";
		   }
		   else{
			   tx.commit();
			  resultMsg="Objects  saved";
		   }
			
			HibernateUtil.closeSession(ses);	
		}//finally
		
		return resultMsg;
	}//method
	
	@Override
	public List<Person> loadDataUsingPerson() throws Exception {
		Session ses=null;
		List<Person> list=null;
		Query query=null;
		//get SEssiom
		ses=HibernateUtil.getSession();
		try{
			query=ses.createQuery(HQL_LOAD_USING_PERSON);
			list=query.list();
		}
		catch(HibernateException he){
			throw he;
		}
		catch(Exception e){
			throw e;
		}
		finally{
			HibernateUtil.closeSession(ses);
		}
		return list;
	}//method
	
	   @Override
		public List<Employee> loadDataUsingEmployee() throws Exception {
		   Session ses=null;
			List<Employee> list=null;
			Query query=null;
			//get SEssiom
			ses=HibernateUtil.getSession();
			try{
				query=ses.createQuery(HQL_LOAD_USING_EMPLOYEE);
				list=query.list();
			}
			catch(HibernateException he){
				throw he;
			}
			catch(Exception e){
				throw e;
			}
			finally{
				HibernateUtil.closeSession(ses);
			}
			return list;
		}
	
}//class
