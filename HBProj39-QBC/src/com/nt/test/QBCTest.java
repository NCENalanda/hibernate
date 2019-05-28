package com.nt.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;

import com.nt.domain.Product;
import com.nt.utility.HibernateUtil;

public class QBCTest {

	public static void main(String[] args) {
		Session ses=null;
		Criteria criteria=null;
		List<Product> list=null;
		Criterion cond1=null,cond2=null,cond3=null,andCond=null,orCond=null;
		Order order=null;
		//get Session
		ses=HibernateUtil.getSession();
		/*//create Criteria Object
		criteria=ses.createCriteria(Product.class);
		//execute logic
		list=criteria.list();
		//Process the results
		list.forEach(p->{
			System.out.println(p.getPid()+" "+p.getPname()+" "+p.getPrice()+" "+p.getQty());
		});*/
		/*//create Criteria object
		criteria=ses.createCriteria(Product.class);
		//create Criterion Object
		cond1=Restrictions.between("price",8000.0f, 100000.0f);
		//add Criterion object
		criteria.add(cond1);
		//execute QBC logic
		list=criteria.list();
		// process the result
		list.forEach(p->{
			System.out.println(p.getPid()+" "+p.getPname()+" "+p.getPrice()+" "+p.getQty());
		});*/
		
		/*//create Criteria object
		criteria=ses.createCriteria(Product.class);
		//prepare cond1
		cond1=Restrictions.ge("price",8000.0f);
		cond2=Restrictions.le("qty",10);
		//add conditions
		criteria.add(cond1);
		criteria.add(cond2);
		//execute QBC logic
		list=criteria.list();
		//process the Result
		list.forEach(p->{
			System.out.println(p.getPid()+" "+p.getPname()+" "+p.getPrice()+" "+p.getQty());
		});*/
		
		/*//create Criteria object
		criteria=ses.createCriteria(Product.class);
		//prepare cond1
		cond1=Restrictions.ge("price",8000.0f);
		cond2=Restrictions.le("qty",10);
		//add conditions
		cond3=Restrictions.or(cond1,cond2);
		criteria.add(cond3);
		//execute QBC logic
		list=criteria.list();
		//process the Result
		list.forEach(p->{
			System.out.println(p.getPid()+" "+p.getPname()+" "+p.getPrice()+" "+p.getQty());
		});*/
		
	/*	//create Criteria object
		criteria=ses.createCriteria(Product.class);
		//prepare conditions
		cond1=Restrictions.ge("pid",10);
		cond2=Restrictions.le("pid",100);
		
		andCond=Restrictions.and(cond1,cond2);
		
		cond3=Restrictions.in("pname","table","chair","golden table");
		
		orCond=Restrictions.or(andCond,cond3);
		criteria.add(orCond);
		//execute QBC logic
		list=criteria.list();
		list.forEach(p->{
			System.out.println(p.getPid()+" "+p.getPname()+" "+p.getPrice()+" "+p.getQty());
		});*/
		//create Criteria object
		/*criteria=ses.createCriteria(Product.class);
		cond1=Restrictions.ilike("pname","TaBLE");
		criteria.add(cond1);
		//execute QBC logic
		list=criteria.list();
		list.forEach(p->{
			System.out.println(p.getPid()+" "+p.getPname()+" "+p.getPrice()+" "+p.getQty());
		});*/
		
		/*//create Criteria object
		criteria=ses.createCriteria(Product.class);
		Map<String,Object> map=new HashMap();
		map.put("pid",1022);
		map.put("pname","table");
		map.put("price",8000.0f);
		//prepare cond
		cond1=Restrictions.allEq(map);
		//add Condition
		criteria.add(cond1);
		//execute logic
		list=criteria.list();
		//process the result
		list.forEach(p->{
			System.out.println(p.getPid()+" "+p.getPname()+" "+p.getPrice()+" "+p.getQty());
		});
*/
		//prepare Criteria Object
		criteria=ses.createCriteria(Product.class);
		//prepare condition (Criterion Object)
		cond1=Restrictions.sqlRestriction(" PRICE>=? and PRICE<=?",
				                         new Object[]{8000.0f,100000.0f},
				                         new Type[]{StandardBasicTypes.FLOAT,
				                        		    StandardBasicTypes.FLOAT});
		//add Condition
		criteria.add(cond1);
		//prepare Order obj
		//order=Order.asc("pid");
		order=Order.desc("pid");
		//add Order
		criteria.addOrder(order);
		
		//execute Query
		list=criteria.list();
		//process the Result
		list.forEach(p->{
			System.out.println(p.getPid()+" "+p.getPname()+" "+p.getPrice()+" "+p.getQty());
		});
		
		
		
		
		//close Object
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
	}//main
}//class
