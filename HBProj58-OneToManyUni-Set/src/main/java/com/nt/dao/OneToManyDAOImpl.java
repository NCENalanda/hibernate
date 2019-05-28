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
	public void saveData()throws Exception {
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
		 user.setFirstName("jani");
		 user.setAddrs("hyd");
		 //prepare Collection of Child objs
		 ph1=new PhoneNumber();
		 ph1.setPhone(10000000);
		 ph1.setNumberType("secret");
		 ph1.setProvider("bsnl");
		 
		 ph2=new PhoneNumber();
		 ph2.setPhone(211111111);
		 ph2.setNumberType("secret2");
		 ph2.setProvider("jio");
		 set=new HashSet();
		 set.add(ph1);set.add(ph2);
		 //add childs to parent
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
	public void saveDataWithPersist()throws Exception {
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
		 user.setUserId(101);
		 user.setFirstName("jani1");
		 user.setAddrs("hyd1");
		 //prepare Collection of Child objs
		 ph1=new PhoneNumber();
		 ph1.setPhone(20000000);
		 ph1.setNumberType("personal");
		 ph1.setProvider("bsnl");
		 
		 ph2=new PhoneNumber();
		 ph2.setPhone(311111111);
		 ph2.setNumberType("office");
		 ph2.setProvider("jio");
		 set=new HashSet();
		 set.add(ph1);set.add(ph2);
		 //add childs to parent
		 user.setPhones(set);
		 //save obj (parent-child)
		 ses.persist(user);
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
	public void loadData() throws Exception {
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
			 //childs.size(); 
			 System.out.println(childs.isEmpty());
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
	public void addPhoneNumberToExistingUser() throws Exception {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		User user=null;
		PhoneNumber ph=null;
		Set<PhoneNumber> childs=null;
		//get Session 
		ses=HibernateUtil.getSession();
		try{
		  tx=ses.beginTransaction();
		  //load existing Parent
		  user=ses.get(User.class,1);
		  //create New Child
		  ph=new PhoneNumber();
		  ph.setNumberType("secret");
		  ph.setPhone(7777777L);
		  ph.setProvider("uninor");
		  //get Existing childs of parent
		  childs=user.getPhones();
		  //add New PhoneNumber obj to collection
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
				System.out.println("New PhoneNumber is added to Existing User");
			}
			else{
			  tx.rollback();
			  System.out.println("New PhoneNumber is not added to Existing User");
			}
			//close session
			HibernateUtil.closeSession(ses);
		}//finally
		
	}//method
	
	@Override
	public void deleteOnePhoneNumberOfAUser() throws Exception {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		User user=null;
		PhoneNumber ph=null;
		Set<PhoneNumber> childs=null;
		//get Session 
		ses=HibernateUtil.getSession();
		//load parent obj
		user=ses.get(User.class, 4);
		//get All childs of a Parent
		childs=user.getPhones();
		//Load Child obj that u want to delete
		ph=ses.get(PhoneNumber.class,7777777L);
        //delete one child from Collection of childs		
		try{
		  tx=ses.beginTransaction();
		   childs.remove(ph);
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
				System.out.println("One child from Collection of childs belonging to a parent is deleted ");
			}
			else{
				tx.rollback();
				System.out.println("One child from Collection of childs belonging to a parent is not deleted ");
			}
		 //close session
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
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
		user=ses.get(User.class,3);
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
	public void deleteUserAndHisPhoneNumbers() throws Exception {
		Session ses=null;
		User user=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//load parent
		user=ses.get(User.class,5);
		//delte parent its associated childs
		try{
		  tx=ses.beginTransaction();
		   ses.delete(user);
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
				System.out.println("A Parent and its childs are deleted");
			}
			else{
				tx.rollback();
				System.out.println("A Parent and its childs are not deleted");
			}
		 //close session
			HibernateUtil.closeSession(ses);
		}//finally
		
	}//method
	
	@Override
	public void transferPhoneNumberFromOneUserToAnotherUser() throws Exception {
       Session ses=null;
       Transaction tx1=null,tx2=null;
       boolean flag1=false,flag2=false;
       User srcUser=null,destUser=null;
       Set<PhoneNumber> srcUserChilds=null,destUserChilds=null;
       PhoneNumber ph=null;
		//get Session
       ses=HibernateUtil.getSession();
       //Load Source parent
       srcUser=ses.get(User.class,1);
     //Load Dest User
       destUser=ses.get(User.class,4);
       //Load SoruceUser Phones
       srcUserChilds=srcUser.getPhones();
       destUserChilds=destUser.getPhones();
       //Load PhoneNumber obj that u want to transfer
       ph=ses.get(PhoneNumber.class, 7777777L);
       try{
    	 tx1=ses.beginTransaction();
    	 srcUserChilds.remove(ph);
    	flag1=true;
       }
       catch(HibernateException he){
			flag1=false;
			throw he;
		}
		catch(Exception e){
			flag1=false;
			throw e;
		}
		finally{
			if(flag1){
				tx1.commit();
				System.out.println("PhoneNumber is deleted from Source User");
			}
			else{
				tx1.rollback();
				System.out.println("PhoneNumber is not deleted from source User");
			}
		}//finally
       try{
      	 tx2=ses.beginTransaction();
      	 destUserChilds.add(ph);
      	flag2=true;
         }
         catch(HibernateException he){
  			flag2=false;
  			throw he;
  		}
  		catch(Exception e){
  			flag2=false;
  			throw e;
  		}
  		finally{
  			if(flag2){
  				tx2.commit();
  				System.out.println("PhoneNumber is added  to Dest User");
  			}
  			else{
  				tx2.rollback();
  				System.out.println("PhoneNumber is not added to Dest User");
  			}
  		}//finally
       
	}//method
	
	@Override
	public void changePhoneNumberProviderOfAUser() {
		Session ses=null;
		Set<PhoneNumber> childs=null;
		User user=null;
		Transaction tx=null ;
		boolean flag=false;
		
		//get Session
		ses=HibernateUtil.getSession();
		//Load parent
		user=ses.get(User.class, 1);
		//get childs
		childs=user.getPhones();
		try{
		 tx=ses.beginTransaction();	
		childs.forEach(ph->{
			if(ph.getPhone()==211111111L){
				ph.setProvider("mtnl");
			}
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
	  				System.out.println("PhoneNumber is moved another provider");
	  			}
	  			else{
	  				tx.rollback();
	  				System.out.println("PhoneNumber is not moved to another Provider");
	  			}
	  		}//finally
	}//method
}//class
