package com.nt.dao;

public interface MToODAO {
	public void  saveDataUsingEmployee();
	public  void listDataUsingEmployee();
	public void addNewEmployeetoExistingDept();
	public void transferEmpFromOneDeptToAnotherDept();
    public void deleteAllEmployeesAndItsDepartment();
    public void deleteOneEmployeeFromDepartment();
    public void deleteOneEmployeeFromDepartmentWithHQL();
}
