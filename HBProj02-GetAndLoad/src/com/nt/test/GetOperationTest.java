package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.domain.InsurancePolicy;

public class GetOperationTest {

	public static void main(String[] args) {
		SessionFactory factory=null;
		Session ses=null;
		InsurancePolicy policy=null;
		//get Session object
		factory=new Configuration().configure("/com/nt/cfgs/hibernate.cfg.xml").buildSessionFactory();
		//get SEssion
		ses=factory.openSession();
		//get Object/Load object
		policy=ses.get(InsurancePolicy.class, 1001);
		
		if(policy!=null){
			System.out.println(policy.getPolicyId()+"  "+policy.getPolicyName()+" "+policy.getTenure()+"  "+policy.getPremium());
		}
		else{
			System.out.println("Object not found");
		}
		//close objs
		ses.close();
		factory.close();
	}//main
}//class
