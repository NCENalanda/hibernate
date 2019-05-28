package com.nt.test;

import com.nt.dao.OneToOneFKDAO;
import com.nt.dao.OneToOneFKDAOFactory;
import com.nt.utility.HibernateUtil;

public class OneToOneFKTest {

	public static void main(String[] args) {
		OneToOneFKDAO dao=null;
		//get DAO
		dao=OneToOneFKDAOFactory.getInstance();
		//invoke methods
		//dao.saveData();
		dao.loadDataUsingPassport();
		
		//close SEssionFactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
