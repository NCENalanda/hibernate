package com.nt.generators;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomTMCSequneceIdGenerator implements IdentifierGenerator {
   private static final String GET_CUSTID_FROM_SEQ="SELECT TMC_CUSTID_SEQUENCE.NEXTVAL FROM DUAL";
	@Override
	public Serializable generate(SessionImplementor ses, Object domain) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int val=0;
		try{
        //get JDBC Connection	
		con=ses.connection();
		//create PreparedStatement obj
		ps=con.prepareStatement(GET_CUSTID_FROM_SEQ);
		//execute Sequence and get results
		rs=ps.executeQuery();
		//get sequence value from ResultSet
		if(rs.next()){
			val=rs.getInt(1);
		}
		if(val<=9)
			return "TMC000"+val;
		else if(val<=99)
			return "TMC00"+val;
		else if(val<=999)
			return "TMC0"+val;
		else 
			return "TMC"+val;
		
		}
		catch(SQLException se){
			se.printStackTrace();
			return "Problem  in IDGeneation";
		}
		catch(Exception e){
			e.printStackTrace();
			return "Problem in IDGeneration";
		}
	}//generate(-,-)
}//class..
