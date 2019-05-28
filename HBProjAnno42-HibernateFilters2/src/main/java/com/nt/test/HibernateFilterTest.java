package com.nt.test;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.nt.domain.Employee;
import com.nt.utility.HibernateUtil;

public class HibernateFilterTest {

	public static void main(String[] args) {
		Session ses=null;
		Filter filter=null;
		Query query=null;
		List<Employee> list=null;
		try{
		//get Session 
		ses=HibernateUtil.getSession();
		//enable Filter
		filter=ses.enableFilter("HB_FILTER_EID_RANGE");
		//set Filter condition params
		filter.setParameter("min",1);
		filter.setParameter("max",10);
		//prepare HQL Query
        query=ses.createQuery("from Employee");
        //execute Query
        list=query.list();
        //process the List
        System.out.println("When Filter is enabled");
        list.forEach(e->{
        	System.out.println(e.getEid()+" "+e.getFirstName()+" "+e.getLastName()+" "+e.getEmail());
        });
        //disable filter
        ses.disableFilter("HB_FILTER_EID_RANGE");
        list=query.list();
        System.out.println("When Filter is not enabled");
        //process the List
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
        //close SEssion
        HibernateUtil.closeSession(ses);
        HibernateUtil.closeSessionFactory();
        }
        
	}

}
