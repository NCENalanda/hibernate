package com.nt.generators;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomRandomIdGenerator implements IdentifierGenerator {

	public CustomRandomIdGenerator() {
		System.out.println("CustomRandomIdGenerator::0-param constructor");
	}
	
	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		System.out.println("CustomRandomIdGenerator::generate(-,-)");
		Random rad=null;
		int idVal=0;
		//generate psuedo Random number as Id value
		rad=new Random();
		idVal=rad.nextInt(100000);
		return idVal;
	}

}
