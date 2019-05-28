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

public class Level2CacheTest_QueryCache_NativeSQL {

	public static void main(String[] args) {
		SessionFactory factory=null;
		Session ses=null;
		InsurancePolicy policy=null;
		List<InsurancePolicy> list=null;
		SQLQuery query=null;
		//get Session object
		factory=new Configuration().configure("/com/nt/cfgs/hibernate.cfg.xml").buildSessionFactory();
		//get SEssion
		ses=factory.openSession();
        //prepare SQL Query
		query=ses.createSQLQuery("select * from Insurance_policy");
		query.addEntity(InsurancePolicy.class);
		query.setCacheable(true);
		//query.setCacheRegion("region1");
		
		list=query.list();
		list.forEach(ip->{
			System.out.println(ip.getPolicyId()+"  "+ip.getPolicyName()+" "+ip.getPremium()+" "+ip.getTenure());
		});
		
		ses.clear();
		
		System.out.println("-------------------------");
		list=query.list();
		list.forEach(ip->{
			System.out.println(ip.getPolicyId()+"  "+ip.getPolicyName()+" "+ip.getPremium()+" "+ip.getTenure());
		});
		ses.clear();
		
		try{
		Thread.sleep(3000);
		}
		catch(Exception e){ e.printStackTrace(); }
		
		System.out.println("-------------------------");
		list=query.list();
		list.forEach(ip->{
			System.out.println(ip.getPolicyId()+"  "+ip.getPolicyName()+" "+ip.getPremium()+" "+ip.getTenure());
		});
		ses.clear();
		Cache cache=factory.getCache();
		cache.evictDefaultQueryRegion();
		System.out.println("-------------------------");
		
		list=query.list();
		list.forEach(ip->{
			System.out.println(ip.getPolicyId()+"  "+ip.getPolicyName()+" "+ip.getPremium()+" "+ip.getTenure());
		});
		
		//close objs
		ses.close();
		factory.close();
	}//main
}//class
