package com.nt.test;

import com.nt.dao.OneToOneDAO;
import com.nt.dao.OneToOneDAOFactory;
import com.nt.utility.HibernateUtil;

public class OneToOnePKTest {
	public static void main(String[] args) {
		OneToOneDAO dao=null;
		//get DAO
		dao=OneToOneDAOFactory.getInstance();
		try{
		//invoke methods
		dao.saveDataUsingStudent();
		 dao.saveDataUsingLibraryMembership();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//close SessionFactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
