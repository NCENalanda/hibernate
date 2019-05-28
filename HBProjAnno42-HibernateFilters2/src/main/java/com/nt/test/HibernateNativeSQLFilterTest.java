package com.nt.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.nt.domain.Employee;
import com.nt.utility.HibernateUtil;
import com.sun.xml.internal.ws.handler.HandlerException;

public class HibernateNativeSQLFilterTest {

	public static void main(String[] args) {
		Session ses=null;
		Filter filter=null;
		SQLQuery query=null;
		List<Employee> list=null;
		
		try{
		//get Session 
		ses=HibernateUtil.getSession();
		//enable Filter
		filter=ses.enableFilter("HB_FILTER_EID_RANGE");
		//set Filter condition params
		filter.setParameter("min",1);
		filter.setParameter("max",10);
		//prepare SQLQuery object
		query=ses.createSQLQuery("SELECT *  FROM EMPLOYEE");
		query.addEntity(Employee.class);
		//execute Native SQL
		list=query.list();
		//process the Result
		list.forEach(e->{
			System.out.println(e.getEid()+" "+e.getFirstName()+" "+e.getLastName()+" "+e.getEmail());
		});
		ses.disableFilter("HB_FILTER_EID_RANGE");
		list=query.list();
		list.forEach(e->{
			System.out.println(e.getEid()+" "+e.getFirstName()+" "+e.getLastName()+" "+e.getEmail());
		});
		
		}
		catch(HibernateException he){
			he.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
        //close Objects
        HibernateUtil.closeSession(ses);
        HibernateUtil.closeSessionFactory();
		}
        
	}//main
}//class
