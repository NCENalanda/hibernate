package com.nt.delegate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;

import com.nt.dao.StudentLibraryOperationsDAO;
import com.nt.dao.StudentLibraryOperationsDAOFactory;
import com.nt.domain.LibraryMembership;
import com.nt.domain.Student;
import com.nt.dto.LibraryMembershipDTO;
import com.nt.dto.StudentDTO;
import com.nt.errors.InsertOperationProblemException;
import com.nt.errors.InternalProblemException;
import com.nt.errors.StudentRemovalProblemException;

public class AcademicOperationsBusinessDelegate {

	public List<StudentDTO> getAllStudentWithTheirLibraryMemberships()throws InternalProblemException{
		StudentLibraryOperationsDAO dao=null;
		List<Student> listStuds=null;
		List<StudentDTO> listStudDTOs=null;
		StudentDTO stDTO=null;
		LibraryMembership lib=null;
		LibraryMembershipDTO libDTO=null;
		//get DAO
		dao=StudentLibraryOperationsDAOFactory.getInstance();
		//use DAO
		try{
		 listStuds=dao.loadAllStudentsWithTheirLibraryMembershipDetails();	
		 //convert ListStudent to ListStudentDTO 
		 listStudDTOs=new ArrayList();
		 for(Student st:listStuds){
			 //get Each DTO class object
			 stDTO=new StudentDTO();
			 stDTO.setSid(st.getSid());
			 stDTO.setName(st.getName());
			 stDTO.setAddress(st.getAddress());
			 //Get Each LibraryMembership object
			 lib=st.getLibraryDetails();
			 libDTO=new LibraryMembershipDTO();
			 libDTO.setLid(lib.getLid());
			 libDTO.setDoj(lib.getDoj());
			 stDTO.setLibraryDetails(libDTO);
			 //add each DTO to ListDTO
			 listStudDTOs.add(stDTO);
		 }//for
		 return listStudDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	
	public String removeStudentWithLibraryMembership(int sid)throws StudentRemovalProblemException{
		StudentLibraryOperationsDAO dao=null;
		int count=0;
		//get DAO
		dao=StudentLibraryOperationsDAOFactory.getInstance();
		try{
		  count=dao.deleteDataUsingStudent(sid);
		  if(count==0)
			  return "Student and his LibraryMembership is not deleted";
		  else
			  return "Student and his LibraryMembership is  deleted";
		}
		catch(HibernateException he){
			throw new StudentRemovalProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new StudentRemovalProblemException(e.getMessage());
		}
	}//method
	
	public String addStudentWithLibrary(String name,String addrs)throws InsertOperationProblemException,InternalProblemException{
		StudentLibraryOperationsDAO dao=null;
		Student st=null;
		LibraryMembership lib=null;
		int sid=0;
		//use dAO
		dao=StudentLibraryOperationsDAOFactory.getInstance();
		//prepare Student,LibraryMembership objs
		st=new Student();
		st.setName(name); st.setAddress(addrs);
		lib=new LibraryMembership();
		lib.setDoj(new Date());
		st.setLibraryDetails(lib);
		lib.setStudentDetails(st);
		//invoke method
		try{
		 sid=dao.saveDataUsingStudent(st);
		}
		catch(HibernateException he){
			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return " student and Library Details are inserted with::"+sid;
	}//method
}//class
