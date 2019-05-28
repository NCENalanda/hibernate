package com.nt.test;

import com.nt.dao.OneToManyDAO;
import com.nt.dao.OneToManyDAOFactory;
import com.nt.utility.HibernateUtil;

public class OneToManyUniTest {

	public static void main(String[] args) {
		OneToManyDAO dao=null;
		//get DAO
		dao=OneToManyDAOFactory.getInstance();
		//invoke methods
		try{
			dao.saveData();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		/*try{
		  dao.loadData();	
		}
		catch(Exception e){
			e.printStackTrace();
		}*/
		
		 //close SessionFactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
