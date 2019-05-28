package com.nt.service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dao.StudentDAOImpl;
import com.nt.dto.StudentDTO;

public class StudentServiceImpl implements StudentService {

	@Override
	public String generateResult(StudentDTO dto) {
		int total=0;
		float avg=0.0f;
		String result=null;
		StudentDAO dao=null;
		int id=0;
		StudentBO bo=null;
		
		//write b.logic (calc total,avg,result)
		total=dto.getM1()+dto.getM2()+dto.getM3();
		avg=total/3.0f;
		if(avg<35)
			result="fail";
		else
			result="pass";
		//prepare having persistable data
		bo=new StudentBO();
		bo.setSname(dto.getSname());
		bo.setTotal(total); bo.setAvg(avg);bo.setResult(result);
		//create DAO class object
		dao=new StudentDAOImpl();
		//use DAO
		id=dao.insert(bo);
		return result+" for student Id::"+id;
	}

}
