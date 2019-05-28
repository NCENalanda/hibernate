package com.nt.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Person;
import com.nt.domain.Viechle;
import com.nt.utility.HibernateUtil;

public class OneToManyDAOImpl implements OneToManyDAO {

	@Override
	public void saveDataUsingPerson() {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Person per=null;
		List<Viechle> childs=null;
		Viechle viechle1=null,viechle2=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prpeare objs
		per=new Person();
		per.setPname("kamal");
		per.setAddrs("hyd");
		
		viechle1=new Viechle();
		viechle1.setRegNo(929999000L);
		viechle1.setType("7-wheeler");
		viechle1.setDor(new Date(120,10,10));
		viechle1.setChasisNo("1245AF43L");
		
		viechle2=new Viechle();
		viechle2.setRegNo(443365699000L);
		viechle2.setType("5-wheeler");
		viechle2.setDor(new Date(115,10,10));
		viechle2.setChasisNo("1945543L");
		
		childs=new ArrayList();
		childs.add(viechle1); childs.add(viechle2);
		//set childs to parent
		per.setViechles(childs);
		
		try{
		 tx=ses.beginTransaction();
		 ses.save(per);
		 flag=true;
		}
		catch(HibernateException he){
			
		  throw he;
		}
		catch(Exception e){
			throw e;
		}
		finally{
			if(flag==true){
				tx.commit();
				System.out.println("Objects are saved");
			}
			else{
				tx.rollback();
				System.out.println("Objects are not saved");	
			}
         //close SEssion
			HibernateUtil.closeSession(ses);
		}//finally
	}//method
	
 }//class
