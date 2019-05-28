package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.domain.InsurancePolicy;

public class Level2CacheTest {

	public static void main(String[] args) {
		SessionFactory factory=null;
		Session ses=null;
		InsurancePolicy policy=null;
		//get Session object
		factory=new Configuration().configure("/com/nt/cfgs/hibernate.cfg.xml").buildSessionFactory();
		//get SEssion
		ses=factory.openSession();
		//get Object/Load object
		
		//get from DB and keeps in L2,L1 caches
		policy=ses.get(InsurancePolicy.class, 1001);
		System.out.println(policy.getPolicyId()+" "+policy.getPolicyName()+" "+policy.getTenure()+" "+policy.getPremium());
	   //get from L1Cache	
		policy=ses.get(InsurancePolicy.class, 1001);
		System.out.println(policy.getPolicyId()+" "+policy.getPolicyName()+" "+policy.getTenure()+" "+policy.getPremium());
		
		ses.evict(policy); //removes from L1 cache
		
	   //get from L2Cache and keeps in L1 cache	
		policy=ses.get(InsurancePolicy.class, 1001);
		System.out.println(policy.getPolicyId()+" "+policy.getPolicyName()+" "+policy.getTenure()+" "+policy.getPremium());
		
		ses.clear(); //removes from L1 cache
		
	   //get from L2Cache and keeps in L1 cache	
		policy=ses.get(InsurancePolicy.class, 1001);
		System.out.println(policy.getPolicyId()+" "+policy.getPolicyName()+" "+policy.getTenure()+" "+policy.getPremium());
		
		ses.evict(policy); // removes from L1 cache
		try{
		Thread.sleep(3000); //removes from L2 cache
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		//gets from DB and keeps L2Cache , L1 cache	
		policy=ses.get(InsurancePolicy.class, 1001);
		System.out.println(policy.getPolicyId()+" "+policy.getPolicyName()+" "+policy.getTenure()+" "+policy.getPremium());
		
		
		//close objs
		ses.close();
		factory.close();
	}//main
}//class
