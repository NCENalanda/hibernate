package com.nt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.nt.domain.Product;
import com.nt.utility.HibernateUtil;

public class PaginationProductDAOImpl implements PaginationProductDAO {

	@Override
	public long rowCount() {
		Session ses=null;
		Criteria criteria=null;
		Projection p1=null;
		List<?>  list=null;
		long count=0l;
		//get Session
		ses=HibernateUtil.getSession();
		//create Criteria
		criteria=ses.createCriteria(Product.class);
		//create Projection
		p1=Projections.rowCount();
		//add Projection obj Criteria
		criteria.setProjection(p1);
		//execute QBC
		list=criteria.list();
		//Process List
		count=(Long)list.get(0);
		return count;
	}

	@Override
	public List<Product> getProducts(int startPos, int pageSize) {
		Session ses=null;
		Criteria criteria=null;
		List<Product> list=null;
		//get Session
		ses=HibernateUtil.getSession();
		//create Criteria
		criteria=ses.createCriteria(Product.class);
		//perform pagination
		criteria.setFirstResult(startPos);
		criteria.setMaxResults(pageSize);
		//execute QBC
		list=criteria.list();
		return list;
	}//getProducts(-,-)
}//class
