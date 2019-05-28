package com.nt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.Product;
import com.nt.utility.HibernateUtil;

public class HQLSelectTest {
  private static final String HQL_GET_ALL_PRODUCTS="from Product";
  //private static final String HQL_GET_ALL_PRODUCTS_BY_PRICE_RANGE="from Product where price>=? and price<=?";
  private static final String HQL_GET_ALL_PRODUCTS_BY_PRICE_RANGE="from Product where price>=?0 and price<=?1";
  //private static final String HQL_GET_ALL_PRODUCT_BY_PID="from Product where  pid>=:start and pid<=:end";
  private static final String HQL_GET_ALL_PRODUCT_BY_PID="from Product where  pid>=? and pid<=:end";
  private static final String HQL_GET_PRODUCTS_BY_NAMES="from Product where pname in(:name1,:name2)";	
  private static final String HQL_GET_PRODUCTS_BY_QTY="select pid,pname from Product where qty>=:count";
  private static final String HQL_GET_PRODUCTS_NAME="select pname  from Product where pid>=:id";
  private static final String HQL_GET_ALL_PRODUCTS1="select pid,pname,price,qty from Product";
  private static final String HQL_GET_MAX_PRICE="SELECT MAX(price) FROM Product";
  private static final String HQL_GET_PRODUCT_BY_MAX_QTY="from Product where qty=(select max(qty) from Product)";
  public static void main(String[] args) {
		Session ses=null;
		Query query=null;
		List<Product> list1=null,list2=null,list3=null;
		List<Object[]> list5=null;
		Iterator<Product> it=null;
		Iterator<Object[]> it1=null;
		Product p=null;
		Object row[]=null;
		List<String> list6=null;
		List<Double> list7=null;
		
		
		// Get Session
		ses=HibernateUtil.getSession();
		try{
/*		//prepare Query
		 query=ses.createQuery(HQL_GET_ALL_PRODUCTS);	
		 //execute Query
		 list1=query.list();
		 //Process the ResultSet
		 for(Product p:list1){
			 System.out.println(p.getPid()+" "+p.getPname()+" "+p.getPrice()+" "+p.getQty());
		 }//for

		 list1.forEach(p->{
			 System.out.println(p.getPid()+" "+p.getPname()+" "+p.getPrice()+" "+p.getQty());
		 });
*/	
	/*	//prepare Query
		 query=ses.createQuery(HQL_GET_ALL_PRODUCTS_BY_PRICE_RANGE);
		//set Query param values
		 query.setFloat(0,5000.0f);
		 query.setFloat(1,10000.0f);
		 query.setFloat("0",5000.0f);
		 query.setFloat("1",6000.0f);
		 //execute Query
		 list2=query.list();
		 //process the list
		 list2.forEach(p->{
			 System.out.println(p.getPid()+" "+p.getPname()+" "+p.getPrice()+" "+p.getQty());
		 });
	*/
/*		query=ses.createQuery(HQL_GET_ALL_PRODUCT_BY_PID);
		//setting name param values
		query.setInteger("start",1000);
		query.setInteger("end",2000);
		//execute query
		list3=query.list();
		//process the List
		list3.forEach(p->{
			 System.out.println(p.getPid()+" "+p.getPname()+" "+p.getPrice()+" "+p.getQty());
		});
*/
		/*	query=ses.createQuery(HQL_GET_ALL_PRODUCT_BY_PID);
			//setting name param values
			query.setInteger(0,1000);
			query.setInteger("end",2000);
			//execute query
			list3=query.list();
			//process the List
			list3.forEach(p->{
				 System.out.println(p.getPid()+" "+p.getPname()+" "+p.getPrice()+" "+p.getQty());
			});*/
		
		/*query=ses.createQuery(HQL_GET_PRODUCTS_BY_NAMES);
		//set param values
		query.setString("name1","lucky chair");
		query.setString("name2","telescope");*/
		//execute Query
/*		it=query.iterate();
		//process Iterator
		while(it.hasNext()){
			p=it.next();
			System.out.println(p.getClass());
			System.out.println(p.getPid());
			Thread.sleep(10000);
		}
*/
		/*list3=query.list();
		list3.forEach(p1->{
			System.out.println(p1.getClass());
			System.out.println(p1.getPid()+" "+p1.getPname()+" "+p1.getPrice()+" "+p1.getQty());
		});*/
		
	/*	//prepare HQL Query
		query=ses.createQuery(HQL_GET_PRODUCTS_BY_QTY);
		///set param value
		query.setInteger("count",10);
		//execute Query
		//list5=query.list();
		//process the result
		/*for(Object row[]:list5){
			for(Object val:row){
				System.out.print(val+" ");
			}
			System.out.println();
		}*/
		
		/*list5.forEach(row->{
			for(Object val:row){
				System.out.print(val+" ");
			}
			System.out.println();
		});*/
		
		/*it1=query.iterate();
		while(it1.hasNext()){
			row=it1.next();
		  for(Object val:row){
			  System.out.print(val+" ");
		  }
		  System.out.println();
		}*/
		
	  // Retriveing Sepcific Single Col vlaue from Db table 	
		//prpeare HQL Query
		/*query=ses.createQuery(HQL_GET_PRODUCTS_NAME);
		query.setInteger("id",1000);
		list6=query.list();
		list6.forEach( s->{
			System.out.println(s);
		});*/
			
       //prepare Query
		/*query=ses.createQuery(HQL_GET_ALL_PRODUCTS1);
		list5=query.list();
		for(Object row1[]:list5){
			for(Object val:row1){
				System.out.print(val+"  ");
			}//for
			System.out.println();
		}//for
*/		
		/*query=ses.createQuery(HQL_GET_MAX_PRICE);
		list7=query.list();
		double maxPrice=(double)list7.get(0);
		System.out.println("Max price value::"+list7.get(0));
		System.out.println("Max price type::"+list7.get(0).getClass());
		*/
			
		/*query=ses.createQuery(HQL_GET_PRODUCT_BY_MAX_QTY);
		list1=query.list();
		if(list1!=null){
		  p=list1.get(0);
		   System.out.println(p.getPid()+" "+p.getPname()+" "+p.getPrice()+" "+p.getQty());
		}
			*/
		 }//try
		catch(HibernateException he){
			he.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			//close objs
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally
	}//main
}//class
