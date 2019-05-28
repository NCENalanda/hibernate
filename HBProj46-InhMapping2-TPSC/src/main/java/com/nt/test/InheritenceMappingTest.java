package com.nt.test;

import java.util.List;

import com.nt.dao.InheritenceDAO;
import com.nt.dao.InheritenceDAOFactory;
import com.nt.domain.Employee;
import com.nt.domain.Person;
import com.nt.utility.HibernateUtil;

public class InheritenceMappingTest {

	public static void main(String[] args) {
		InheritenceDAO dao=null;
		List<Person> list=null;
		List<Employee> list1=null;
		//get DAO
		dao=InheritenceDAOFactory.getInstance();
		/*try{
		System.out.println(dao.saveData());
		}
		catch(Exception e){
			System.out.println("Internal problem-->"+e.getMessage());
		}*/
		try{
		  list=dao.loadDataUsingPerson();
		  list.forEach(p->{
			  System.out.println(p.getId()+" "+p.getName()+" "+p.getCompany());
		  });
		}//try
		catch(Exception e){
			System.out.println("Internal problem--->"+e.getMessage());
		}
		System.out.println("----------------------");
		
		try{
			  list1=dao.loadDataUsingEmployee();
			  list1.forEach(e->{
				  System.out.println(e.getId()+" "+e.getName()+" "+e.getCompany()+" "+e.getDesg()+" "+e.getSalary());
			  });
			}//try
			catch(Exception e){
				System.out.println("Internal problem--->"+e.getMessage());
			}
			System.out.println("----------------------");
		
		HibernateUtil.closeSessionFactory();

	}//main
}//class
