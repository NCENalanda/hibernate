package com.nt.test;

import org.hibernate.HibernateException;

import com.nt.dao.MToMDAO;
import com.nt.dao.MToMDAOFactory;
import com.nt.utility.HibernateUtil;

public class MToMTest {

	public static void main(String[] args) {
		MToMDAO dao=null;
		//get DAO
		dao=MToMDAOFactory.getInstance();
		
		//dao.saveDataUsingProgrammer();
		dao.saveDataUsingProjects();
		
		//close session factory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
