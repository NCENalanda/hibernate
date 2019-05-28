package com.nt.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;

import com.nt.domain.Product;
import com.nt.utility.HibernateUtil;

public class QBCProjectionsTest {

	public static void main(String[] args) {
		Session ses=null;
		Criteria criteria=null;
        List<Object[]> list=null;	
        List<Object> list1=null;
		Criterion cond1=null;
		Order order=null;
		Projection p1=null,p2=null;
		ProjectionList pList=null;
		Object row[]=null;
		//get Session
		ses=HibernateUtil.getSession();
		/*//create Criteria Object
		criteria=ses.createCriteria(Product.class);
		//prepare Projections
		p1=Projections.property("pid");
		p2=Projections.property("pname");
		//add Projectiosn to ProjectionList
		pList=Projections.projectionList();
		pList.add(p1); pList.add(p2);
		//add ProjectionList to criteria
		criteria.setProjection(pList);
		//prepared Criterion Object(cond)
		cond1=Restrictions.between("pid",1000, 1500);
		//add Cond
		criteria.add(cond1);
		//Prepare Order
		order=Order.asc("pid");
		//add Order
	    criteria.addOrder(order);
		//execute QBC
		list=criteria.list();
		//process collection
		list.forEach(row->{
			for(Object val:row){
				System.out.print(val+" ");
			}
			System.out.println();
		});
		*/
		
		//create Cretieria Object
		/*criteria=ses.createCriteria(Product.class);
		// prepare and Projection object
		p1=Projections.property("pname");
		criteria.setProjection(p1);
		//execute QBC logic
		list1=criteria.list();
		//process result
		list1.forEach(System.out::println);*/
		
	/*	//create Criteria Object
		criteria=ses.createCriteria(Product.class);
		//Prepare Projection
		p1=Projections.rowCount();
		//add Projection
		criteria.setProjection(p1);
		
		//execute QBC loigc
		list1=criteria.list();
		//process the result
		System.out.println(list1.get(0)+"---->"+list1.get(0).getClass());
		*/
		
		//create Criteria object
		criteria=ses.createCriteria(Product.class);
		//create Projections
		p1=Projections.max("price");
		p2=Projections.min("price");
		//add Projections to ProjectionList
		pList=Projections.projectionList();
		pList.add(p1); pList.add(p2);
		//add ProjectionList to Criteria object
		criteria.setProjection(pList);
		//execute QBC
		list=criteria.list();
		row=list.get(0);
		System.out.println("max price:::"+row[0]+"--->"+row[0].getClass());
		System.out.println("min price:::"+row[1]+"--->"+row[1].getClass());
		
		
		//close Object
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
	}//main
}//class
