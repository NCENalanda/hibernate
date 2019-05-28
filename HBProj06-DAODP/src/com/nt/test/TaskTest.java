package com.nt.test;

import java.util.Date;

import com.nt.dao.TaskAssignmentDAO;
import com.nt.dao.TaskAssignmentDAOFactory;
import com.nt.domain.TaskAssignment;
import com.nt.utility.HibernateUtil;

public class TaskTest {

	public static void main(String[] args) {
		TaskAssignmentDAO dao=null;
		TaskAssignment task=null;
		int updateStatus=0;
		//get DAO
		dao=TaskAssignmentDAOFactory.getInstance();
		//invoke method
		/*task=new TaskAssignment();
		task.setTaskName("CURD Operations");
		task.setAssignedDate(new Date());
		task.setSubmissionDate(new Date(117,10,16));
		task.setRemarks("POC");
		System.out.println("Task Id::"+dao.saveTask(task));
		*/
		task=dao.getTask(1);
		System.out.println("task details"+task.getTaskId()+" "+task.getTaskName()+" "+task.getAssignedDate()+" "+task.getSubmissionDate()+" "+task.getRemarks());
		
		updateStatus=dao.updateTask(1,"POC111");
		if(updateStatus==0)
			System.out.println("Task not found/not updated");
		else
			System.out.println("taks found and updated");
		
		//close SessionFactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
