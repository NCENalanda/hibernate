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
		 /* //get Access to Named NativeSQL Query
			query=ses.getNamedQuery("GET_EMPS_BY_RANGE");
			query.setInteger("start",10);
			query.setInteger("end", 200);
			list=query.list();
			//list.forEach(System.out::println);
			list.forEach(e->{
				System.out.println(e);
			});

			 //list.stream().map(e->e.getEid()).forEach(System.out::println);
*/			
			//get Access to Named Native SQL SCalar Query
			/*query=ses.getNamedQuery("GET_EMPS_BY_LASTNAME");
			query.setString("lname","rao");
			list1=query.list();
			list1.forEach(row->{
				for(Object val:row){
					System.out.print(val+"  ");
				}
				System.out.println();
			});*/
			
			
			}
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
