package com.nt.test;

import com.nt.dao.OneToOneFKDAO;
import com.nt.dao.OneToOneFKDAOFactory;
import com.nt.utility.HibernateUtil;

public class OneToOneFkTest {
	public static void main(String[] args) {
		OneToOneFKDAO dao=null;
		//get DAO
		dao=OneToOneFKDAOFactory.getInstance();
		//save objs
		//dao.saveDataUsingFlightPassenger();
		dao.saveDataUsingFlightTicket();
		
		
		//close objs
		HibernateUtil.closeSessionFactory();
		
	}//main
}//class
