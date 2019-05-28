package com.nt.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.PhoneNumber;
import com.nt.domain.User;
import com.nt.utility.HibernateUtil;

public class OneToManyDAOImpl implements OneToManyDAO {

	
	@Override
	public void loadDataUsingUserAndJoins() throws Exception {
	   final String HQL_JOINS_QUERY="select u.userId,u.firstName,u.addrs,ph.phone,ph.numberType,ph.provider from User u inner join u.phones ph ";	
		Session ses=null;
		Query query=null;
		List<Object[]> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		try{
		 //prepare query
		 query=ses.createQuery(HQL_JOINS_QUERY);
		 //execute Query
		 list=query.list();
		 //process the List
		 list.forEach(row->{
			for(Object val:row){
				System.out.print(val+"   ");
			}
			System.out.println("\n--------");
		 });
		 
		}//try
		catch(HibernateException he){
			throw he;
		}
		catch(Exception e){
			throw e;
		}
		finally{
			//close Session
			HibernateUtil.closeSession(ses);
		}
	}//method
	
	@Override
	public void loadDataUsingPhoneNumberAndJoins() throws Exception {
		 final String HQL_JOINS_QUERY="select ph.phone,ph.numberType,ph.provider,u.userId,u.firstName,u.addrs from PhoneNumber ph full join ph.user u ";
		Session ses=null;
		Query query=null;
		List<Object[]> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		try{
		 //prepare query
		 query=ses.createQuery(HQL_JOINS_QUERY);
		 //execute Query
		 list=query.list();
		 //process the List
		 list.forEach(row->{
			 for(Object val:row){
				 System.out.print(val+"  ");
		   }
			 System.out.println();
		 });
		 
		}//try
		catch(HibernateException he){
			throw he;
		}
		catch(Exception e){
			throw e;
		}
		finally{
			//close Session
			HibernateUtil.closeSession(ses);
		}
		
	}//method
	
	@Override
	public void loadDataUsingPhoneNumberAndJoins1() throws Exception {

		// final String HQL_JOINS_QUERY="select ph.phone,ph.numberType,ph.provider,u.userId,u.firstName,u.addrs from PhoneNumber ph full join ph.user u ";
		final String HQL_JOINS_QUERY="select ph from PhoneNumber ph inner join fetch ph.user u";
		Session ses=null;
		Query query=null;
		List<PhoneNumber> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		try{
		 //prepare query
		 query=ses.createQuery(HQL_JOINS_QUERY);
		 //execute Query
		 list=query.list();
		 //process the List
		 list.forEach(ph->{
			System.out.println("child-->"+ph.getPhone()+" "+ph.getNumberType()+" "+ph.getProvider());
			//get Associated user
			User user=ph.getUser();
			System.out.println("parent-->"+user.getUserId()+" "+user.getFirstName()+" "+user.getAddrs());
		 });
		 
		}//try
		catch(HibernateException he){
			throw he;
		}
		catch(Exception e){
			throw e;
		}
		finally{
			//close Session
			HibernateUtil.closeSession(ses);
		}
		
	}//method
    
	@Override
	public void loadDataUsingUserAndQBCWithFetchMode() throws Exception {
		Session ses=null;
		Criteria criteria=null;
		List<User> list=null;
		
		//get Session
		ses=HibernateUtil.getSession();
		try{
		 //create Criteria Object
		criteria=ses.createCriteria(User.class);
		 //set FetchMode
		 criteria.setFetchMode("phones",FetchMode.DEFAULT);
		 list=criteria.list();
		 list.forEach(user->{
			 System.out.println("parent-->"+user.getUserId()+" "+user.getFirstName()+" "+user.getAddrs());
			 Set<PhoneNumber>  childs=user.getPhones();
			 childs.forEach(ph->{
				 System.out.println("Child--->"+ph.getPhone()+" "+ph.getNumberType()+" "+ph.getProvider());
			 });
		 });
		}//try
		catch(HibernateException he){
			throw he;
		}
		catch(Exception e){
			throw e;
		}
		finally{
			//close Session
			HibernateUtil.closeSession(ses);
		}
	}//method
	
}//class
