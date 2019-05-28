package com.nt.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.StandardBasicTypes;

import com.nt.domain.Product;
import com.nt.utility.HibernateUtil;

public class ProductDAOImpl implements ProductDAO {
	
	@Override
	public List<Product> getProductsByPriceRange(float startRange, float endRange) {
		Session ses=null;
		Query query=null;
		List<Product> list=null;
       //get Session	
		ses=HibernateUtil.getSession();
		try{
		 //get Accesss to Named Native SQL query
		query=ses.getNamedQuery("CALL_FX");
		//set param values
		query.setFloat(0,startRange);
		query.setFloat(1,endRange);
		//execute Query (calling PL/SQL function)
		list=query.list();
		return list;	
		}
		catch(HibernateException he){
			he.printStackTrace();
			return null;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally{
			HibernateUtil.closeSession(ses);
		}
	}//method
}//class
