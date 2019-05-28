package com.nt.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.domain.LibraryMembership;
import com.nt.domain.Student;
import com.nt.utility.HibernateUtil;

public class StudentLibraryOperationsDAOImpl implements StudentLibraryOperationsDAO {
 private static final String HQL_GET_ALL_STUDENTS_WITH_LIBRARY_DETAILS="from  Student";
	@Override
	public List<Student> loadAllStudentsWithTheirLibraryMembershipDetails() {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<Student> listStuds = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ALL_STUDENTS_WITH_LIBRARY_DETAILS);
		try {
			listStuds = query.list();
		} // try
		catch (HibernateException he) {
			flag = false;
			throw he;
		} catch (Exception e) {
			flag = false;
			throw e;
		} finally {
			// close Session
			HibernateUtil.closeSession();
		} // finally
		return listStuds;
	}//method
	
	@Override
	public int deleteDataUsingStudent(int sid) {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		int count=0;
		Student st=null;
		//load Pearent obj
		st=ses.get(Student.class,sid);
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 ses.delete(st);
         count=1;		
		}//try
		catch(HibernateException he){
			count=0;
			throw he;
		}
		catch(Exception e){
			count=0;
			throw e;
		}
		finally{
			if(count==1){
				tx.commit();
			}
			else{
				tx.rollback();
			}
		 //close Session
			HibernateUtil.closeSession();
		}//finally	
		return count;
	}//method
	
	
/*	@Override
	public int deleteOnlyLibaryMemebership(int lid) {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
        Query query=null;
        int count=0;
		//load Pearent obj
		query=ses.createQuery("delete from LibraryMembership where lid=:id");
		query.setInteger("id",3);
		try{
		 tx=ses.beginTransaction();
		 count=query.executeUpdate();
          flag=true;			
		}//try
		catch(HibernateException he){
			flag=false;
			throw he;
		}
		catch(Exception e){
			flag=false;
			throw e;
		}
		finally{
			if(flag){
				tx.commit();
				System.out.println("Only Child Obj is deleted::"+count);
			}
			else{
				tx.rollback();
				System.out.println("Only child is not deleted");
			}
		 //close Session
			HibernateUtil.closeSession();
		}//finally
		return 1;
	}//method
*/
	
	@Override
	public int saveDataUsingStudent(Student st) {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 idVal=(int)ses.save(st);
          flag=true;			
		}//try
		catch(HibernateException he){
			flag=false;
			throw he;
		}
		catch(Exception e){
			flag=false;
			throw e;
		}
		finally{
			if(flag){
				tx.commit();
				
			}
			else{
				tx.rollback();
			}
		 //close Session
			HibernateUtil.closeSession();
		}//finally
		return idVal;
	}//method
	

}
