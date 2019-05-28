package com.nt.test;

import com.nt.dao.OneToManyDAO;
import com.nt.dao.OneToManyDAOFactory;
import com.nt.utility.HibernateUtil;

public class OneToManyBiTest {

	public static void main(String[] args) {
		OneToManyDAO dao=null;
		//get DAO
		dao=OneToManyDAOFactory.getInstance();
		
		//invoke methods
		try{
			//dao.saveDataUsingUser();
			//dao.saveDataUsingPhoneNumber();
			dao.loadDataUsingUser();
			//dao.loadDataUsingPhoneNumber();
			//dao.deleteAllPhoneNumbersOfAUser();
			//dao.deleteAllPhoneNumbersAndTheirUserUsingPhoneNumber();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		     //close SessionFactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
