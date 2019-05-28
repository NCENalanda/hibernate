package com.nt.test;

import java.util.List;

import com.nt.dao.PaymentDAO;
import com.nt.dao.PaymentDAOFactory;
import com.nt.domain.ChequePayment;
import com.nt.domain.Payment;
import com.nt.utility.HibernateUtil;

public class AnnotationInhMappingTest {

	public static void main(String[] args) {
		PaymentDAO dao=null;
		List<Payment> list1=null;
		List<ChequePayment> list2=null;
		//get DAO
		dao=PaymentDAOFactory.getInstance();
		//invoke methods
		try{
		  dao.saveData();
		  System.out.println("Objects saved");
		}
		catch(Exception e){
			 System.out.println("Objects not saved-->");
			 e.printStackTrace();
		}
		/*try{
		 list1=dao.loadDataUsingPayment();
		 list1.forEach(p->{
			 System.out.println(p.getTxId()+" "+p.getAmount()+" "+p.getTxDate());
		 });
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("----------------------");
		try{
			 list2=dao.loadDataUsingChequePayment();
			 list2.forEach(c->{
				 System.out.println(c.getTxId()+" "+c.getAmount()+" "+c.getTxDate()+" "+c.getChequeNumber()+" "+c.getChequeType());
			 });
			}
			catch(Exception e){
				e.printStackTrace();
			}
			System.out.println("----------------------");*/
		HibernateUtil.closeSessionFactory();
	}//main
	
}//class
