package com.nt.test;

import java.util.List;

import com.nt.dao.BankAccountDAO;
import com.nt.dao.BankAccountDAOFactory;
import com.nt.domain.BankAccount;
import com.nt.utility.HibernateUtil;

public class CallingProcedureTest {

	public static void main(String[] args) {
		BankAccountDAO dao=null;
		List<BankAccount> list=null;
		//get dAO
		dao=BankAccountDAOFactory.getInstance();
		//invoke method
		list=dao.getAccountHoldersByBalanceRange(1000,6000);
		//display the reuslts
		list.forEach(System.out::println);
		
		//close SessionFactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
