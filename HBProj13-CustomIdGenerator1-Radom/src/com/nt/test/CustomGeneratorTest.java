package com.nt.test;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.LuckyDrawCupon;
import com.nt.utility.HibernateUtil;

public class CustomGeneratorTest {

	public static void main(String[] args) {
		Session ses=null;
		LuckyDrawCupon cupon=null,cupon1=null;
		int idVal=0,idVal1=0;
		Transaction tx=null;
		boolean flag=false;
		// Get session
		ses=HibernateUtil.getSession();
		//save object
		try{
         tx=ses.beginTransaction();			
		 cupon=new LuckyDrawCupon();
		 cupon.setCustomerName("raja");
		 cupon.setBillNo(3456);
		 cupon.setBillAmt(8900);
		 cupon.setPurchaseDate(new Date());
		 
		 cupon1=new LuckyDrawCupon();
		 cupon1.setCustomerName("raja");
		 cupon1.setBillNo(3456);
		 cupon1.setBillAmt(8900);
		 cupon1.setPurchaseDate(new Date());
		 //save object
		 idVal=(int)ses.save(cupon);
		 idVal1=(int)ses.save(cupon1);
		 System.out.println("Generated Idval::"+idVal);
		 System.out.println("Generated Idval1:::"+idVal1);
		 flag=true;
		}
       catch(HibernateException he){
    	   flag=false;
    	   he.printStackTrace();
       }
	  catch(Exception  e){
		  flag=false;
		  e.printStackTrace();
	  }
	 finally{
		 if(flag==false){
			 tx.rollback();
			 System.out.println("Object not saved");
		 }
		 else{
			 tx.commit();
			 System.out.println("Object is saved");
		 }
		 //close  objs
		 HibernateUtil.closeSession(ses);
		 HibernateUtil.closeSessionFactory();
	 }//finally
	}//main
}//class
