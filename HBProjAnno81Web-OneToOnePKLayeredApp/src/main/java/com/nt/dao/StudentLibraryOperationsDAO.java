package com.nt.dao;

import java.util.List;

import com.nt.domain.Student;

public interface StudentLibraryOperationsDAO {
	public List<Student> loadAllStudentsWithTheirLibraryMembershipDetails();
	public int  deleteDataUsingStudent(int sid);
	//public int deleteOnlyLibaryMemebership(int lid);
	public  int saveDataUsingStudent(Student st);

}
