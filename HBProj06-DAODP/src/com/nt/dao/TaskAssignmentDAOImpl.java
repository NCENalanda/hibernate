package com.nt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.TaskAssignment;
import com.nt.utility.HibernateUtil;

public class TaskAssignmentDAOImpl implements TaskAssignmentDAO {

	@Override
	public int saveTask(TaskAssignment task) {
		Transaction tx=null;
		Session ses=null;
		int id=0;
		//get Session
		ses=HibernateUtil.getSession();
		try{
		 tx=ses.beginTransaction();
		  id=(int) ses.save(task);
		 tx.commit(); 
		}
		catch(Exception e){
			tx.rollback();
		}
		HibernateUtil.closeSession(ses);
		return id;
	}//saveTask(-)
	
	 
		


	@Override
	public TaskAssignment getTask(int taskId) {
		Session ses=null;
		TaskAssignment task=null;
		//get Session
		ses=HibernateUtil.getSession();
		//get Object
		task=ses.get(TaskAssignment.class,taskId);
		HibernateUtil.closeSession(ses);
		return task;
	}//method





	@Override
	public int updateTask(int taskId, String remarks) {
		Session ses=null;
		TaskAssignment task=null;
		Transaction tx=null;
		//get Session
		ses=HibernateUtil.getSession();
		//get Object
		task=ses.get(TaskAssignment.class, taskId);
		if(task!=null){
			try{
		      tx=ses.beginTransaction();
		       task.setRemarks(remarks);
		      tx.commit();
		      HibernateUtil.closeSession(ses);
		      return 1;
			}
			catch(Exception e){
				tx.rollback();
				return 0;
			}
		}//if
		else{
			return 0;		
		}
	}//method
}//class
