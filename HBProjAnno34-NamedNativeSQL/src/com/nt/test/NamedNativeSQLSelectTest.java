package com.nt.test;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.StandardBasicTypes;

import com.nt.domain.Employee;
import com.nt.utilty.HibernateUtil;

public class NamedNativeSQLSelectTest {
	public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		List<Employee> list=null;
		List<Object[]> list1=null;
		//get Session
		ses=HibernateUtil.getSession();
		try{
	/*	  //get Access to Named NativeSQL Query
			query=ses.getNamedQuery("GET_ALL_EMPS");
			list=query.list();
			list.forEach(System.out::println);*/
			
			//get Access to Named NativeSQL Query
			query=ses.getNamedQuery("GET_EID_EMAIL");
			((SQLQuery)query).addScalar("EID",StandardBasicTypes.INTEGER);
			((SQLQuery)query).addScalar("EMAIL",StandardBasicTypes.STRING);
			
			list1=query.list();
			
			list1.forEach(row->{
				for(Object val:row){
					System.out.print(val+" "+val.getClass());
				}
				System.out.println();
			});
			
			
			}//try
		catch(HibernateException he){
			he.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
		 HibernateUtil.closeSession(ses);
		 HibernateUtil.closeSessionFactory();
		}
	}

}
