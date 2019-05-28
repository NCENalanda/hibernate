package com.nt.dao;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.LobHelper;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Employee;
import com.nt.utility.FileUtility;
import com.nt.utility.HibernateUtil;

public class LOBDAOImpl implements LOBDAO {

	@Override
	public int saveData(Employee emp,String photoFilePath,String resumeFilePath) throws Exception {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		LobHelper helper=null;
		int idVal=0;
		byte bytes[]=null;
		String  fileContent=null;
		java.sql.Clob clob=null;
		java.sql.Blob blob=null;
		//get Session
		ses=HibernateUtil.getSession();
		//get LobHelper object
		helper=ses.getLobHelper();
		//create java.sql.Clob,Blob objs
		bytes=FileUtility.getBytesArrayFromFile(photoFilePath);
		blob=helper.createBlob(bytes);
		
		fileContent=FileUtility.readFileAsString(resumeFilePath);
		clob=helper.createClob(fileContent);
		//set blob,clob objs to Domain class obj
		emp.setEphoto(blob);
		emp.setEresume(clob);
		
		try{
		 tx=ses.beginTransaction();
		  idVal=(int)ses.save(emp);
		 flag=true;
		}
		catch(HibernateException he){
			flag=false;
			throw he;
		}
		catch(Exception e){
			flag=false;
			throw e;
		}
		finally{
			if(flag==true)
				tx.commit();
			else
				tx.rollback();
			HibernateUtil.closeSession(ses);
		}
		return idVal;
	}//saveData(-)
	
	@Override
	public Employee loadData(int eid) throws Exception {
		Session ses=null;
		Employee emp=null;
		//get Session
		ses=HibernateUtil.getSession();
		try{
			emp=ses.get(Employee.class,eid);
		}
		catch(HibernateException he ){
			throw he;
		}
		catch(Exception e){
			throw e;
		}
		finally{
			HibernateUtil.closeSession(ses);
		}
		
		return emp;
	}
	
}//class
