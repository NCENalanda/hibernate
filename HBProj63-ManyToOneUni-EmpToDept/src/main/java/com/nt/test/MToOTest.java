package com.nt.test;

import com.nt.dao.MToODAO;
import com.nt.dao.MToODAOFacatory;
import com.nt.utility.HibernateUtil;

public class MToOTest {

	public static void main(String[] args) {
		MToODAO dao=null;
		//get DAO
		dao=MToODAOFacatory.getInstance();
		//invoke methods
		//dao.saveDataUsingEmployee();
		//dao.listDataUsingEmployee();
		//dao.addNewEmployeetoExistingDept();
		//dao.transferEmpFromOneDeptToAnotherDept();
		//dao.deleteAllEmployeesAndItsDepartment();
		//dao.deleteOneEmployeeFromDepartment();
		dao.deleteOneEmployeeFromDepartmentWithHQL();
		
		
		//close SessionFactory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
