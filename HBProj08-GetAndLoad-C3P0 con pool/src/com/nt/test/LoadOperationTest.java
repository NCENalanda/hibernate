package com.nt.test;

import java.util.Arrays;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.domain.IInsurancePolicy;
import com.nt.domain.InsurancePolicy;



public class LoadOperationTest {

	public static void main(String[] args) {
		SessionFactory factory=null;
		Session ses=null;
		//InsurancePolicy policy=null;
		IInsurancePolicy ipolicy=null;
		//create SessionFactory
		factory=new Configuration().configure("/com/nt/cfgs/hibernate.cfg.xml").buildSessionFactory();
		//create Session 
		ses=factory.openSession();
		//load object
		try{
		ipolicy=ses.load(InsurancePolicy.class,1001);
		System.out.println(ipolicy.getPolicyId()+" "+ipolicy.getPolicyName()+" "+ipolicy.getTenure()+" "+ipolicy.getPremium());
		}
		catch(ObjectNotFoundException onfe){
			System.out.println("Record not found");
		}

		//close objs
		ses.close();
		factory.close();
		
		

	}

}
