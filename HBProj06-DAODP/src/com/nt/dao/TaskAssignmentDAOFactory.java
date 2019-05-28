package com.nt.dao;

public class TaskAssignmentDAOFactory {
	
	public static TaskAssignmentDAO getInstance(){
		return new TaskAssignmentDAOImpl();
	}

}
