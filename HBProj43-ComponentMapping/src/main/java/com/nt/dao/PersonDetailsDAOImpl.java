package com.nt.dao;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.PersonDetails;
import com.nt.utility.HibernateUtil;

public class PersonDetailsDAOImpl implements PersonDetailsDAO {

	@Override
	public int savePersonDetails(PersonDetails details) {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		//get Sesion
		ses=HibernateUtil.getSession();
		try{
		 tx=ses.beginTransaction();
		 idVal=(int)ses.save(details);
		 flag=true;
		}
		catch(HibernateException he){
			he.printStackTrace();
			flag=false;
		}
		catch(Exception e){
			e.printStackTrace();
			flag=false;
		}
		finally{
			if(flag==true){
				tx.commit();
			}
			else{
				tx.rollback();
			}
			HibernateUtil.closeSession(ses);
		}
		return idVal;
	}//method
	
	@Override
	public List<PersonDetails> getAllPersonDetails() {
		Session ses=null;
		List<PersonDetails> list=null;
		Query query=null;
		//get Session
		ses=HibernateUtil.getSession();
		try{
		 query=ses.getNamedQuery("GET_ALL_PERSONDETAILS");
		 list=query.list();
		}
		catch(HibernateException he){
			he.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}//method
	
	@Override
	public List<Object[]> getPersonDetailsByDesg(String desg) {
		Session ses=null;
		List<Object[]> list=null;
		Query query=null;
		//get Session
		ses=HibernateUtil.getSession();
		try{
			//get Named Query
		 query=ses.getNamedQuery("GET_ALL_PERSONDETAILS_BY_DESG");
		 //set param values
		 query.setString("position",desg);
		 //execute QBC
		 list=query.list();
		}
		catch(HibernateException he){
			he.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}//method
}//class
