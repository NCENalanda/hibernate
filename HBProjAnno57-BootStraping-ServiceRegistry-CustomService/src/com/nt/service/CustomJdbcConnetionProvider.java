package com.nt.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

public class CustomJdbcConnetionProvider implements ConnectionProvider {

	@Override
	public boolean isUnwrappableAs(Class arg0) {
		System.out.println("isUnwrappledAs(-)");
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) {
		System.out.println("unwrap(-)");
		return null;
	}

	@Override
	public void closeConnection(Connection con) throws SQLException {
		System.out.println("closeConnection(-)");
	   con.close();

	}

	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("getConnection(-)");
		Connection con=null;
		try{
		//register jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//establish the connection
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "manager");
		}
		catch(SQLException se){
			throw se;
		}
		catch(ClassNotFoundException cnf){
			cnf.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}

	@Override
	public boolean supportsAggressiveRelease() {
		System.out.println("supportsAggressiveRelease()");
		return false;
	}

}
