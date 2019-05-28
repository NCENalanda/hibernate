package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;
import com.nt.service.StudentServiceImpl;

public class StudentControllerServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String sname=null;
        int m1=0,m2=0,m3=0;
        StudentDTO dto=null;
        StudentService service=null;
        String result=null;
        RequestDispatcher rd=null;
		//read form data
        sname=req.getParameter("sname");
        m1=Integer.parseInt(req.getParameter("m1"));
        m2=Integer.parseInt(req.getParameter("m2"));
        m3=Integer.parseInt(req.getParameter("m3"));
        //create DTO class object
        dto=new StudentDTO();
        dto.setSname(sname);
        dto.setM1(m1);
        dto.setM2(m2);
        dto.setM3(m3);
        //create Serviceclass object
        service=new StudentServiceImpl();
        try{
        //use service
        result=service.generateResult(dto);
        }
        catch(Exception e){
        	req.setAttribute("errMsg",e.getMessage());
        	rd=req.getRequestDispatcher("/error.jsp");
        	rd.forward(req,res);
        	return;
        }
        //keep result in request scope
        req.setAttribute("resultMsg",result);
        //forward to show_result.jsp
		rd=req.getRequestDispatcher("/show_result.jsp");
		rd.forward(req,res);
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 doGet(req,res);
	}//doPost(-,-)
}//class
