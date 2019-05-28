package com.nt.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.PhoneNumber;
import com.nt.domain.User;
import com.nt.utility.HibernateUtil;

public class OneToManyDAOImpl implements OneToManyDAO {

	@Override
	public void saveDataUsingUser()throws Exception {
		Session ses=null;
		boolean flag=false;
		Transaction tx=null;
		User user=null;
		Set<PhoneNumber> set=null;
		PhoneNumber ph1=null,ph2=null;
		//get Session
		ses=HibernateUtil.getSession();
		try{
		 tx=ses.beginTransaction();
		  //prepare Parent obj
		 user=new User();
		 user.setFirstName("Ivanka Trump");
		 user.setAddrs("USA-HYD");
		 //prepare Collection of Child objs
		 ph1=new PhoneNumber();
		 ph1.setPhone(200000007);
		 ph1.setNumberType("secret");
		 ph1.setProvider("AT&T");
		 
		 ph2=new PhoneNumber();
		 ph2.setPhone(311111111);
		 ph2.setNumberType("secret2");
		 ph2.setProvider("Vodafone");
		 //add parent to childs
		 ph1.setUser(user);
		 ph2.setUser(user);
		 //add childs to parent
		 set=new HashSet();
		 set.add(ph1);set.add(ph2);
		 user.setPhones(set);
		 
		 //save obj (parent-child)
		 ses.save(user);
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
			if(flag==true){
				tx.commit();
				System.out.println("Parent-Child objs are saved");
			}
			else{
			  tx.rollback();
			  System.out.println("Parent-Child objs are not saved");
			}
			//close session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
	@Override
	public void saveDataUsingPhoneNumber()throws Exception {
		Session ses=null;
		boolean flag=false;
		Transaction tx=null;
		User user=null;
		Set<PhoneNumber> set=null;
		PhoneNumber ph1=null,ph2=null;
		//get Session
		ses=HibernateUtil.getSession();
		try{
		 tx=ses.beginTransaction();
		  //prepare Parent obj
		 user=new User();
		 user.setFirstName("milana");
		 user.setAddrs("USA");
		 //prepare Collection of Child objs
		 ph1=new PhoneNumber();
		 ph1.setPhone(300000007);
		 ph1.setNumberType("secret");
		 ph1.setProvider("Vodafone");
		 
		 ph2=new PhoneNumber();
		 ph2.setPhone(811111111);
		 ph2.setNumberType("secret2");
		 ph2.setProvider("VeriZone");
		 //add parent to childs
		 ph1.setUser(user);
		 ph2.setUser(user);
		 //add childs to parent
		 set=new HashSet();
		 set.add(ph1);set.add(ph2);
		 user.setPhones(set);
		 
		 //save obj (child-parent)
		  ses.save(ph1);
		  ses.save(ph2);
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
			if(flag==true){
				tx.commit();
				System.out.println("Parent-Child objs are saved");
			}
			else{
			  tx.rollback();
			  System.out.println("Parent-Child objs are not saved");
			}
			//close session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method

	
	
	@Override
	public void loadDataUsingUser() throws Exception {
		Session ses=null;
		Query query=null;
		List<User> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		try{
		 //prepare query
		 query=ses.createQuery("from User");
		 //execute Query
		 list=query.list();
		 
		 //process the List
		 list.forEach(user->{
			 Set<PhoneNumber> childs=null;
			 System.out.println("parent::-->"+user.getUserId()+" "+user.getFirstName()+" "+user.getAddrs());
			 childs=user.getPhones();
			
			 childs.forEach(ph->{
				 System.out.println("child::-->"+ph.getPhone()+" "+ph.getNumberType()+" "+ph.getProvider());
			 });
			 System.out.println("-----------------------");
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
	public void loadDataUsingPhoneNumber() throws Exception {
		Session ses=null;
		Query query=null;
		List<PhoneNumber> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		try{
		 //prepare query
		 query=ses.createQuery("from PhoneNumber");
		 //execute Query
		 list=query.list();
		 //process the List
		 list.forEach(ph->{
			 System.out.println("child-->"+ph.getPhone()+" "+ph.getNumberType()+" "+ph.getProvider());
			//get Associated Parent
			 User user=ph.getUser();
			 System.out.println("Parent-->"+user.getUserId()+" "+user.getFirstName()+" "+user.getAddrs());
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
		
	}
	
	@Override
	public void deleteAllPhoneNumbersOfAUser() throws Exception {
		Session ses=null;
		User user=null;
		Set<PhoneNumber> childs=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//load parent
		user=ses.get(User.class,2);
		//get all childs
		childs=user.getPhones();
		try{
		  tx=ses.beginTransaction();
		   // childs.removeAll(childs)
		  childs.clear();
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
			if(flag){
				tx.commit();
				System.out.println("All child of a Parent are deleted");
			}
			else{
				tx.rollback();
				System.out.println("All childs of parent are not deleted ");
			}
		 //close session
			HibernateUtil.closeSession(ses);
		}//finally
		
	}//method
	
	@Override
	public void deleteAllPhoneNumbersAndTheirUserUsingPhoneNumber() throws Exception {
		Session ses=HibernateUtil.getSession();
		User user=null;
		Set<PhoneNumber> childs=null;
		Transaction tx=null;
		boolean flag=false;
		Query query=null;
		List<PhoneNumber> list;
		//get Session
		//ses=HibernateUtil.getSession();
		//loads childs and their parents
		query=ses.createQuery("from PhoneNumber where user.userId=:id");
		query.setInteger("id",4);
		//execute the Query
		list=query.list();
		try{
		  tx=ses.beginTransaction();
		   list.forEach(ph->{
			   ses.delete(ph);
		   });
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
			if(flag){
				tx.commit();
				System.out.println("All childs and its Parent are deleted");
			}
			else{
				tx.rollback();
				System.out.println("All childs and its parent are not deleted ");
			}
		 //close session
			HibernateUtil.closeSession(ses);
		}//finally
		
	}
	
	
}//class
