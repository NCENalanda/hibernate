package com.nt.test;

import java.util.List;

import com.nt.dao.PersonDetailsDAO;
import com.nt.dao.PersonDetailsDAOFactory;
import com.nt.domain.JobDetails;
import com.nt.domain.PersonDetails;
import com.nt.utility.HibernateUtil;

public class ComponentMappingTest {

	public static void main(String[] args) {
		PersonDetailsDAO dao=null;
		PersonDetails details=null;
		JobDetails job=null;
		List<PersonDetails> list1=null;
		List<Object[]> list2=null;
		//get DAO
		dao=PersonDetailsDAOFactory.getInstance();
		/* //prpeare Domain class objs
		job=new JobDetails();
		job.setDesg("HR");
		job.setCompany("HCL");
		job.setSalary(20000);
		job.setDeptNo(1002);
		details=new PersonDetails();
		details.setPname("ramesh");
		details.setPjob(job);
		//invoke method
		System.out.println("Person id::"+dao.savePersonDetails(details));
		*/
		/*list1=dao.getAllPersonDetails();
		list1.forEach(p->{
			JobDetails jd=null;
			jd=p.getPjob();
			System.out.println("person-->"+p.getPid()+" "+p.getPname());
			System.out.println("JobDetais-->"+jd.getDesg()+" "+jd.getCompany()+" "+jd.getSalary()+" "+jd.getDeptNo());
		});
*/		
		//invoke method
		list2=dao.getPersonDetailsByDesg("HR");
		list2.forEach(row->{
			for(Object val:row){
				System.out.print(val+" ");
			}
			System.out.println();
		});
		//close Session Factory
		HibernateUtil.closeSessionFactory();
	}//main
}//class
