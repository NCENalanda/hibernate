package com.nt.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.jdbc.ReturningWork;

import com.nt.utility.HibernateUtil;

public class AuthenticationDAOImpl2 implements AuthenticationDAO {
 private static final String CALL_PROCEDURE="{call P_AUTHENTICATION(?,?,?)}";
	@Override
	public String authenticate(String user, String pass) {
		Session ses=null;
		String result=null;
		//get Session object
		ses=HibernateUtil.getSession();
		try{
		//call Pl/SQL procure through Callback interface
		result=ses.doReturningWork(con->{
				 CallableStatement cs=null;
				   String result1=null;
					//write CallableStatement obj based JDBC code
					cs=con.prepareCall(CALL_PROCEDURE);
					//register OUT params with jdbc types
					cs.registerOutParameter(3,Types.VARCHAR);
					//set values to IN params
					cs.setString(1,user);
					cs.setString(2,pass);
					//execute PL/SQL Procedure
					cs.execute();
					//get result from out param
					result1=cs.getString(3);
					return result1;
			}//execute(-)
		);//method call
		
		}//try
		catch(HibernateException he){
			he.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			HibernateUtil.closeSession(ses);
		}
		return result;
	}//autthenticate(-,-)
}//outerclass
