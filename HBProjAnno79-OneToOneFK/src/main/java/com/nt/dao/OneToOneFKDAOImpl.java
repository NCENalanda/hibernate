package com.nt.dao;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.FlightPassenger;
import com.nt.domain.FlightTicket;
import com.nt.utility.HibernateUtil;

public class OneToOneFKDAOImpl implements OneToOneFKDAO {

	@Override
	public void saveDataUsingFlightPassenger() {
		Session ses=null;
		boolean flag=false;
		Transaction tx=null;
		FlightTicket ticket=null;
		FlightPassenger passenger=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prpeare objects
		ticket=new FlightTicket();
		ticket.setFlightNo("AI3456");
		ticket.setDoj(new Date());
		ticket.setSeatNo(10);
		ticket.setSource("hyd");
		ticket.setDestination("Delhi");
		
		passenger=new FlightPassenger();
		passenger.setAadharNo(345677788L);
		passenger.setAge(30);
		passenger.setMobileNo(9999999);
		passenger.setName("raja");
		//map p-->c & c--->p
		passenger.setTicket(ticket);
		ticket.setPassenger(passenger);
		try{
		 tx=ses.beginTransaction();	
		   ses.save(passenger);
		 flag=true;
		}
		catch(HibernateException he){
			flag=false;
			throw he;
		}
		catch(Exception e){
			flag=false;
			throw e;
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("Objects are saved");
			}
			else{
				tx.rollback();
				System.out.println("Objects are  not saved");
			}
			HibernateUtil.closeSession(ses);
		}//finally
	}//method

	@Override
	public void saveDataUsingFlightTicket() {
		Session ses=null;
		boolean flag=false;
		Transaction tx=null;
		FlightTicket ticket=null;
		FlightPassenger passenger=null;
		//get Session
		ses=HibernateUtil.getSession();
		//prpeare objects
		ticket=new FlightTicket();
		ticket.setFlightNo("IG3456");
		ticket.setDoj(new Date());
		ticket.setSeatNo(11);
		ticket.setSource("vizag");
		ticket.setDestination("BBSR");
		
		passenger=new FlightPassenger();
		passenger.setAadharNo(455677788L);
		passenger.setAge(29);
		passenger.setMobileNo(8888889);
		passenger.setName("rani");
		//map p-->c & c--->p
		passenger.setTicket(ticket);
		ticket.setPassenger(passenger);
		try{
		 tx=ses.beginTransaction();	
		   ses.save(ticket); //c-->p
		 flag=true;
		}
		catch(HibernateException he){
			flag=false;
			throw he;
		}
		catch(Exception e){
			flag=false;
			throw e;
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("Objects are saved");
			}
			else{
				tx.rollback();
				System.out.println("Objects are  not saved");
			}
			HibernateUtil.closeSession(ses);
		}//finally


	}

}
