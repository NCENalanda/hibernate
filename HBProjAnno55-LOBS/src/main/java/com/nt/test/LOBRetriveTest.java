package com.nt.test;

import org.hibernate.LobHelper;
import org.hibernate.engine.jdbc.env.spi.LobCreatorBuilder;

import com.nt.dao.LOBDAO;
import com.nt.dao.LOBDAOFactory;
import com.nt.domain.Employee;
import com.nt.utility.FileUtility;
import com.nt.utility.HibernateUtil;

public class LOBRetriveTest {

	public static void main(String[] args) {
		LOBDAO dao=null;
		Employee emp=null;
		java.sql.Clob clob=null;
		java.sql.Blob blob=null;
		//get DAO
		dao=LOBDAOFactory.getInstance();
		//invoke methods
		try{
		 emp=dao.loadData(1);
		 clob=emp.getEresume();
		 blob=emp.getEphoto();
		 System.out.println(emp.getEid()+"  "+emp.getEname()+" "+emp.getEaddrs());
		 System.out.println(FileUtility.createFileFromClob(clob, "resume1.txt"));
		 System.out.println(FileUtility.createFileFromBlob(blob, "javababa.jpg"));
		 
		}
		catch(Exception e){
			System.out.println("Problem in saving ");
			e.printStackTrace();
		}
		//close SEssion factory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
