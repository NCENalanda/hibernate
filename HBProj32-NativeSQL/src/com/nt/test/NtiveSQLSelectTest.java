package com.nt.test;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.StandardBasicTypes;

import com.nt.domain.Employee;
import com.nt.utilty.HibernateUtil;

public class NtiveSQLSelectTest {
	private static final String ALL_EMPS="SELECT * FROM EMPLOYEE WHERE EID>=:start and EID<=:end";
	private static final String ALL_EMPS_BY_EMAIL="SELECT EID,EMAIL FROM EMPLOYEE WHERE EMAIL not like :dmn";
	private static final String  EMPS_COUNT="SELECT COUNT(*) FROM EMPLOYEE";
	public static void main(String[] args) {
		Session ses=null;
		SQLQuery query=null;
		List<Object[]> list=null;
		List<Employee> list1=null;
		Iterator<Object[]> it=null;
		List<Integer> list2=null;
		int empCount=0;
		
		//get Session
		ses=HibernateUtil.getSession();
		try{
		/* //prepare SQLQuery object	(Entity)
		 query=ses.createSQLQuery(ALL_EMPS);
		 //set param values
		 query.setInteger("start",10);
		 query.setInteger("end",20);
		 //execute the Query
		 list=query.list();
		 //prorcess result
		 list.forEach(row->{
			 for(Object val:row){
				 System.out.print(val+" ");
			 }//for
			 System.out.println();
		 });*/
			
/*		//prepare SQLQuery object	
		 query=ses.createSQLQuery(ALL_EMPS);
		 //set param values
		 query.setInteger("start",10);
		 query.setInteger("end",20);
		 //map with Entity class
		 query.addEntity(Employee.class);
		 //execute the query
		 list1=query.list();
		 //process the resultt
		 list1.forEach(e->{
			 System.out.println(e.getEid()+" "+e.getFirstName()+" "+e.getLastName()+" "+e.getEmail());
		 });
*/    
	/* //Prepare SQLQuery obj (Scalar Query)
		query=ses.createSQLQuery(ALL_EMPS_BY_EMAIL);
		//set param values
		query.setString("dmn","%gmail.com");
		//map colums to Hibernate Data types
		query.addScalar("EID",StandardBasicTypes.INTEGER);
		query.addScalar("EMAIL",StandardBasicTypes.STRING);
		//execute the query
		
		list=query.list();
		//process result
		list.forEach(row->{
			for(Object val:row){
				System.out.print(val+"-->"+val.getClass());
			}
			System.out.println();
		});
		*/
      query=ses.createSQLQuery(EMPS_COUNT);
      query.addScalar("count(*)",StandardBasicTypes.INTEGER);
      list2=query.list();
       empCount=list2.get(0);
      System.out.println("Emp counnt :::"+empCount);
		
		
		
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
