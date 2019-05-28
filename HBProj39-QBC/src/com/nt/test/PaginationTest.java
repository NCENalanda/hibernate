package com.nt.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.Type;

import com.nt.domain.Product;
import com.nt.utility.HibernateUtil;

public class PaginationTest {

	public static void main(String[] args) {
		Session ses=null;
		Criteria criteria=null;
		List<Product> list=null;
		Query query=null;
		SQLQuery query1=null;
		//get Session
		ses=HibernateUtil.getSession();
	/*	//create Criteria object (Pagination)
		criteria=ses.createCriteria(Product.class);
		criteria.setFirstResult(12);
		criteria.setMaxResults(3);
		list=criteria.list();
		list.forEach(p->{
			System.out.println(p.getPid()+" "+p.getPname()+" "+p.getPrice()+" "+p.getQty());
		});*/
		/*//create HQL Query (pagination)
		query=ses.createQuery("from Product");
		query.setFirstResult(0);
		query.setMaxResults(3);
		list=query.list();
		list.forEach(p->{
			System.out.println(p.getPid()+" "+p.getPname()+" "+p.getPrice()+" "+p.getQty());
		});*/
		//create Native SQL Query(pagination)
		query1=ses.createSQLQuery("select * from Product");
		query1.setFirstResult(0);
		query1.setMaxResults(3);
		query1.addEntity(Product.class);
		list=query1.list();
		list.forEach(p->{
			System.out.println(p.getPid()+" "+p.getPname()+" "+p.getPrice()+" "+p.getQty());
		});
		
		
		//close Object
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
	}//main
}//class

/*orginal SQL Query for pagination
 * SQL> select rownum ,pid,pname from(select rownum as r,pid,pname from Product)where r>=4 and r<=6;
 */
