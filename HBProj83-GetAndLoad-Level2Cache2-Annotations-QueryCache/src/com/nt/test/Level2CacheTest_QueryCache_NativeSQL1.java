package com.nt.test;

import java.util.List;

import org.hibernate.Cache;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.domain.InsurancePolicy;

public class Level2CacheTest_QueryCache_NativeSQL1 {

	public static void main(String[] args) {
		SessionFactory factory=null;
		Session ses=null;
		InsurancePolicy policy=null;
		List<Object[]> list=null;
		SQLQuery query=null;
		//get Session object
		factory=new Configuration().configure("/com/nt/cfgs/hibernate.cfg.xml").buildSessionFactory();
		//get SEssion
		ses=factory.openSession();
        //prepare SQL Query
		query=ses.createSQLQuery("select * from Insurance_policy");
		//query.addEntity(InsurancePolicy.class);
		query.setCacheable(true);
		//query.setCacheRegion("region1");
		
		list=query.list();
		
		for(Object row[]:list){
			for(Object val:row){
				System.out.print(val+" ");
			}
			System.out.println();
		}
		
		
		System.out.println("-------------------------");
		list=query.list();
		for(Object row[]:list){
			for(Object val:row){
				System.out.print(val+" ");
			}
			System.out.println();
		}
		
		
				
		//close objs
		ses.close();
		factory.close();
	}//main
}//class
