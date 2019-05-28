package com.nt.dao;

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
		Set<Viechle> childs=null;
		Viechle viechle1=null,viechle2=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prpeare objs
		per=new Person();
		per.setPname("ramesh");
		per.setAddrs("hyd");
		
		viechle1=new Viechle();
		viechle1.setRegNo(9339999000L);
		viechle1.setType("3-wheeler");
		viechle1.setDor(new Date(120,10,10));
		viechle1.setChasisNo("1255AF43L");
		
		viechle2=new Viechle();
		viechle2.setRegNo(43565699000L);
		viechle2.setType("8-wheeler");
		viechle2.setDor(new Date(115,10,10));
		viechle2.setChasisNo("19AF5543L");
		
		childs=new HashSet();
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
	
	@Override
	public void loadDataUsingPerson() {
		Session ses=null;
		Transaction tx=null;
		List<Person> list=null;
		Query query=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare query
		query=ses.createQuery("from Person");
		try{
		//execute query
		list=query.list();
		list.forEach(p->{
			System.out.println("parent-->"+p.getPid()+" "+p.getPname()+" "+p.getAddrs());
			Set<Viechle> childs=p.getViechles();
			childs.forEach(v->{
				System.out.println("child-->"+v.getRegNo()+"  "+v.getChasisNo()+" "+v.getType()+" "+v.getDor());
			});
		});
		}//try
		finally{
			
			//close session
			HibernateUtil.closeSession(ses);
		}
	}//method
	
	@Override
	public void loadDataUsingPersonWithQBC() {
		Session ses=null;
		Transaction tx=null;
		List<Person> list=null;
		Criteria criteria=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare Criteria
		criteria=ses.createCriteria(Person.class);
		try{
		//execute query
		list=criteria.list();
		list.forEach(p->{
			System.out.println("parent-->"+p.getPid()+" "+p.getPname()+" "+p.getAddrs());
			Set<Viechle> childs=p.getViechles();
			childs.forEach(v->{
				System.out.println("child-->"+v.getRegNo()+"  "+v.getChasisNo()+" "+v.getType()+" "+v.getDor());
			});
		});
		}//try
		finally{
			
			//close session
			HibernateUtil.closeSession(ses);
		}
	}//method
	
	@Override
	public void deleteOneViechleOfAPerson() {
		Session ses=null;
		Transaction tx=null;
		boolean flag=false;
		Person per=null;
		Set<Viechle> childs=null;
		Viechle viechle=null;
		//get Session
		ses=HibernateUtil.getSession();
		//Load Parent object
		per=ses.get(Person.class, 1);
		//get childs
		childs=per.getViechles();
		//Load Specific child from Cache
		viechle=ses.get(Viechle.class,9999999000L);
		try{
			 tx=ses.beginTransaction();
			    childs.remove(viechle);
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
					System.out.println("One child from collection of childs is removed");
				}
				else{
					tx.rollback();
					System.out.println("One child from collection of childs is not removed");	
				}
	         //close SEssion
				HibernateUtil.closeSession(ses);
			}//finally
	}//method
}//class
