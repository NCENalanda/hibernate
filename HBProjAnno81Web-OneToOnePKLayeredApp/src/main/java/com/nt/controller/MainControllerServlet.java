package com.nt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.delegate.AcademicOperationsBusinessDelegate;
import com.nt.dto.StudentDTO;
import com.nt.errors.InsertOperationProblemException;
import com.nt.errors.InternalProblemException;
import com.nt.errors.StudentRemovalProblemException;

@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       String pval=null;
       AcademicOperationsBusinessDelegate delegate=null;
       List<StudentDTO> listStudDTOs=null;
       RequestDispatcher rd=null;
       String studWithLibRemovalMsg=null;
       String sname=null,saddrs=null;
       String insertResult=null;
       
		//read additional req param value
      pval=req.getParameter("operation");
      if(pval.equalsIgnoreCase("link1")){
    	delegate=new AcademicOperationsBusinessDelegate();
    	try{
    	listStudDTOs=delegate.getAllStudentWithTheirLibraryMemberships();
    	req.setAttribute("listStudsDTO",listStudDTOs);
    	rd=req.getRequestDispatcher("list_studs.jsp");
    	rd.forward(req,res);
    	}
    	catch(InternalProblemException ipe){
    		req.setAttribute("errMsg",ipe.getMessage());
    		rd=req.getRequestDispatcher("/error.jsp");
    		rd.forward(req,res);
    	}
      }//if
      else if(pval.equalsIgnoreCase("link2")){
    	  //use Delegage
    	  delegate=new AcademicOperationsBusinessDelegate();
    	  try{
    	  studWithLibRemovalMsg=delegate.removeStudentWithLibraryMembership(Integer.parseInt(req.getParameter("sid")));
    	  req.setAttribute("studWithLibRemovalMsg", studWithLibRemovalMsg);
    	 
    	  listStudDTOs=delegate.getAllStudentWithTheirLibraryMemberships();
      	  req.setAttribute("listStudsDTO",listStudDTOs);
       	rd=req.getRequestDispatcher("list_studs.jsp");
        	rd.forward(req,res);

    	  }
    	  catch(StudentRemovalProblemException sepe){
    		req.setAttribute("errMsg",sepe.getMessage());
      		rd=req.getRequestDispatcher("/error.jsp");
      		rd.forward(req,res); 
    	  }
    	  catch (InternalProblemException ipe) {
    		  req.setAttribute("errMsg",ipe.getMessage());
      		rd=req.getRequestDispatcher("/error.jsp");
      		rd.forward(req,res);
   	    	}
    	  catch(Exception e){
    		  req.setAttribute("errMsg",e.getMessage());
        		rd=req.getRequestDispatcher("/error.jsp");
        		rd.forward(req,res); 
    	  }
      }//else if
      else if(pval.equalsIgnoreCase("register")){
    	  sname=req.getParameter("stname");
    	  saddrs=req.getParameter("staddrs");
    	//use Delegage
    	  delegate=new AcademicOperationsBusinessDelegate();
    	  try{
    	  insertResult=delegate.addStudentWithLibrary(sname, saddrs);
          req.setAttribute("insertMsg",insertResult);
          
          listStudDTOs=delegate.getAllStudentWithTheirLibraryMemberships();
          req.setAttribute("listStudsDTO",listStudDTOs);
          
         	rd=req.getRequestDispatcher("list_studs.jsp");
          	rd.forward(req,res);

    	  }
    	  catch(InsertOperationProblemException iop){
    		  req.setAttribute("errMsg",iop.getMessage());
        		rd=req.getRequestDispatcher("/error.jsp");
        		rd.forward(req,res); 
    	  }
    	  catch(InternalProblemException ipe){
    		  req.setAttribute("errMsg",ipe.getMessage());
      		rd=req.getRequestDispatcher("/error.jsp");
      		rd.forward(req,res); 
    	  }
    	  catch(Exception e){
    		  req.setAttribute("errMsg",e.getMessage());
        		rd=req.getRequestDispatcher("/error.jsp");
        		rd.forward(req,res);   
    	  }
    	  
      }
      
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)
}//class
