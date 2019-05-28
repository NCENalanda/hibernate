package com.nt.test;
import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.hibernate.type.Type;

import com.nt.domain.BankAccount;


public class ContextualSessionClient1 {
	public static void main(String args[]) {
		SessionFactory factory = new Configuration().configure("/com/nt/cfgs/hibernate.cfg.xml").buildSessionFactory();
		Transaction tx=null;
		Session ses1=null,ses2=null;
		
		try{
		 ses1 = factory.getCurrentSession();
		tx=ses1.beginTransaction();
		BankAccount account=ses1.get(BankAccount.class,32L);
		System.out.println(account.getAcno()+" "+account.getHolderName());
		
		
		 ses2 = factory.getCurrentSession();
		BankAccount account1=ses2.get(BankAccount.class,32L);
		System.out.println(account1.getAcno()+" "+account1.getHolderName());
		
		System.out.println(ses1.hashCode()+"  "+ses2.hashCode());
		tx.commit();
		
		}
		catch(Exception e){
			 e.printStackTrace();
		  }
	    finally{
	      factory.close();
	    }
	}// main
}// class
