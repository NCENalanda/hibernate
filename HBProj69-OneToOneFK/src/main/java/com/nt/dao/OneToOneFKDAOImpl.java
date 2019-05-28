package com.nt.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Passport;
import com.nt.domain.Person;
import com.nt.utility.HibernateUtil;

public class OneToOneFKDAOImpl implements OneToOneFKDAO {

	@Override
	public void saveData() {
		Session ses=null;
		Person p1=null,p2=null;
		Passport passport=null;
		Transaction tx=null;
		boolean flag=false;
		//get SEssion
	    ses=HibernateUtil.getSession();
	    //prepare objs
	    p1=new Person();
	    p1.setPname("raja");
	    p1.setAge(30);
	    p1.setAddrs("hyd");
	    
	    p2=new Person();
	    p2.setPname("ramakrisha");
	    p2.setAge(25);
	    p2.setAddrs("vizag");
	    
	    passport=new Passport();
	    passport.setCountry("india");
	    passport.setDob(new Date(92,10,14));
	    passport.setExpiryDate(new Date(122,10,13));
	    //map parent to child
	    passport.setPersonDetails(p1);
	    try{
	      tx=ses.beginTransaction();
	        ses.save(p2);
	        ses.save(passport);
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
	    		System.out.println("objects are saved (c->p)");
	    	}
	    	else{
	    		tx.rollback();
	    		System.out.println("objects are not saved (c->p)");
	    	}
	    //close session	
	      HibernateUtil.closeSession(ses);		
	    }//finally
	}//method

	@Override
	public void loadDataUsingPassport() {
		Session ses=null;
		Query query=null;
		List<Passport> list=null;
		//get SEssion
		ses=HibernateUtil.getSession();
		//prepare Query
		query=ses.createQuery("from Passport");
		 try{
			list=query.list();
			list.forEach(pp->{
				System.out.println("child-->"+pp.getPpNo()+" "+pp.getCountry()+" "+pp.getDob()+" "+pp.getExpiryDate()+" ");
				Person per=pp.getPersonDetails();
				System.out.println("parent-->"+per.getPid()+" "+per.getPname()+" "+per.getAge()+" "+per.getAddrs());
			});
		    }
		    catch(HibernateException he){
		    	throw he;
		    }
		    catch(Exception e){
		    	throw e;
		    }
		    finally{
		    //close session	
		      HibernateUtil.closeSession(ses);		
		    }//finally
	}//method
}//class
