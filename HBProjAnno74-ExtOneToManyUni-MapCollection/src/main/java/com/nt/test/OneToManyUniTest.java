package com.nt.test;

import com.nt.dao.OneToManyDAO;
import com.nt.dao.OneToManyDAOFactory;
import com.nt.utility.HibernateUtil;

public class OneToManyUniTest {

	public static void main(String[] args) {
	  OneToManyDAO dao=null;
		// get DAO
	  dao=OneToManyDAOFactory.getInstance();
	  
	  //invoke method
	  dao.saveDataUsingPerson();
	 
	  
	  //close session factory
	  HibernateUtil.closeSessionFactory();
	}//main
}//class
