package com.nt.dao;

import com.nt.domain.Employee;

public interface LOBDAO {
	public int saveData(Employee emp,String photoFilePath,String resumeFilePath)throws Exception;
    public Employee loadData(int eid)throws Exception;
}
