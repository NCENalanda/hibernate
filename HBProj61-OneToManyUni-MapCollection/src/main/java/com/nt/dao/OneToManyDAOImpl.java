package com.nt.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
	public void saveData()throws Exception {
		Session ses=null;
		boolean flag=false;
		Transaction tx=null;
		User user=null;
		Map<String,PhoneNumber> map=null;
		PhoneNumber ph1=null,ph2=null;
		//get Session
		ses=HibernateUtil.getSession();
		try{
		 tx=ses.beginTransaction();
		  //prepare Parent obj
		 user=new User();
		 user.setFirstName("jani");
		 user.setAddrs("hyd");
		 //prepare Collection of Child objs
		 ph1=new PhoneNumber();
		 ph1.setPhone(20000000);
		 ph1.setNumberType("secret");
		 ph1.setProvider("bsnl");
		 
		 ph2=new PhoneNumber();
		 ph2.setPhone(311111111);
		 ph2.setNumberType("secret2");
		 ph2.setProvider("jio");
		 map=new HashMap();
		 map.put("daycalls",ph1);
		 map.put("ngtcalls",ph2);
		 //add childs to parent
		 user.setPhones(map);
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
	public void deleteOnePhoneNumberOfAUser() {
		Session ses=null;
		boolean flag=false;
		Transaction tx=null;
		User user=null;
		Map<String,PhoneNumber> childs=null;
		//get Session
		ses=HibernateUtil.getSession();
		//Load a Parent
		user=ses.get(User.class,1);
		//get All Childs of a Parent
		childs=user.getPhones();
		try{
		  tx=ses.beginTransaction();
		    childs.remove("ngtcalls");
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
				System.out.println("One child from collection of childs is deleted");
			}
			else{
				tx.rollback();
				System.out.println("One child from collection of childs is not deleted");
			}
			//close session
			HibernateUtil.closeSession(ses);
		}
	}//method
	
	/*@Override
	public void makingOrphanPhoneNumberAsChildPhoneNumberToAParent() {
		Session ses=null;
		User user=null;
		PhoneNumber ph=null;
		List<PhoneNumber> childs=null;
		boolean flag=false;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//Load Parent
		user=ses.get(User.class,1);
		//Load Orphan Child obj from DB s/w
		ph=ses.get(PhoneNumber.class,311111111L);
		//get all childs of parent
		childs=user.getPhones();
		try{
			  tx=ses.beginTransaction();
			  childs.add(ph);
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
					System.out.println("User has adopted orphan PhoneNumber");
				}
				else{
					tx.rollback();
					System.out.println("Adoption of orphan failed");
				}
				//close session
				HibernateUtil.closeSession(ses);
			}
	}//method
*/	
}//class
