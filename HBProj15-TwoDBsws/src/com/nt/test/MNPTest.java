package com.nt.test;

import com.nt.service.MobileNumberPortabilityService;
import com.nt.service.MobileNumberPortabilityServiceFactory;
import com.nt.utility.MysqlHibernateUtil;
import com.nt.utility.OracleHibernateUtil;

public class MNPTest {

	public static void main(String[] args) {
		MobileNumberPortabilityService service=null;
	  //get Service class object
		service=MobileNumberPortabilityServiceFactory.getInstance();
	  //use service
		System.out.println(service.performMNP(9999999999L));
		//close factories
	  OracleHibernateUtil.closeSessionFactory();
	  MysqlHibernateUtil.closeSessionFactory();
	}//main
}//class
