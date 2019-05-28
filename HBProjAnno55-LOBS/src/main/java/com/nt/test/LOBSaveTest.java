package com.nt.test;

import org.hibernate.LobHelper;
import org.hibernate.engine.jdbc.env.spi.LobCreatorBuilder;

import com.nt.dao.LOBDAO;
import com.nt.dao.LOBDAOFactory;
import com.nt.domain.Employee;
import com.nt.utility.FileUtility;
import com.nt.utility.HibernateUtil;

public class LOBSaveTest {

	public static void main(String[] args) {
		LOBDAO dao=null;
		Employee emp=null;
		byte bytes[]=null;
		java.sql.Blob blob=null;
		LobHelper helper=null;
		int id=0;
		//get DAO
		dao=LOBDAOFactory.getInstance();
		//prepare Domain class objects
		emp=new Employee();
		emp.setEname("raja");
		emp.setEaddrs("hyd");
		//use DAO method
		try{
		id=dao.saveData(emp,"c:/Users/nareshit/Desktop/james.jpg",
					         "c:/Users/nareshit/Desktop/resume.txt");
		 System.out.println("emp saved with "+id);
		}
		catch(Exception e){
			System.out.println("Problem in saving ");
			e.printStackTrace();
		}
		//close SEssion factory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
