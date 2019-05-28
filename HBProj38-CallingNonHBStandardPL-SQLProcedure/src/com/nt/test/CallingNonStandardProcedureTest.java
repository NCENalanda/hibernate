package com.nt.test;

import com.nt.dao.AuthenticationDAO;
import com.nt.dao.AuthenticationDAOFactory;
import com.nt.utility.HibernateUtil;

public class CallingNonStandardProcedureTest {

	public static void main(String[] args) {
		AuthenticationDAO dao=null;
		String result=null;
		//get DAO
		dao=AuthenticationDAOFactory.getInstance();
		//invoke the method
		result=dao.authenticate("raja","rani1");
		System.out.println("Result===>"+result);
		
		//close session factory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
