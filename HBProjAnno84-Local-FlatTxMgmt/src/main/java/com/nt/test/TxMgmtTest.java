package com.nt.test;

import com.nt.dao.AccountDAO;
import com.nt.dao.AccountDAOFactory;
import com.nt.utility.HibernateUtil;

public class TxMgmtTest {

	public static void main(String[] args) {
		AccountDAO dao=null;
		// get DAO
		dao=AccountDAOFactory.getInstance();
		
		if(dao.transferMoney(101, 1044, 600)){
			System.out.println("Money Transferred(Tx committed)");
		}
		else{
			System.out.println("Money not Transferred(Tx rolled back)");
		}
		
		HibernateUtil.closeSessionFactory();
	}//main
}//class
