package com.nt.dao;

import com.nt.domain.TaskAssignment;

public interface TaskAssignmentDAO {
	
	public int saveTask(TaskAssignment task);
	public TaskAssignment getTask(int taskId);
	public int updateTask(int taskId,String remarks);

}
