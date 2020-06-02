package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.EmployeeDTO;
import com.nt.vo.EmployeeVO;
import com.nt.service.EmployeeMGTService;
import com.nt.service.EmployeeService;

@SuppressWarnings("serial")
@WebServlet("/empurl")
public class EmployeeController extends HttpServlet {
	private EmployeeMGTService service;
	
	
	public EmployeeController(EmployeeMGTService service) {
		
		this.service = service;
	}

 
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
		EmployeeVO vo=null;
		String no=null,name=null,m1=null,m2=null,m3=null;
		EmployeeDTO dto=null;
		String result=null;
        PrintWriter pw=null;
        ServletOutputStream sos=null;
        
        //read form data
        no=req.getParameter("no");
        name=req.getParameter("name");
        m1=req.getParameter("m1");
        m2=req.getParameter("m2");
        m3=req.getParameter("m3");        
		
		//create VO class object having form data
        vo=new EmployeeVO();
        vo.setSno(no);
        vo.setSname(name);
        vo.setM1(m1);
        vo.setM2(m2);
        vo.setM3(m3);
        
        //convert VO class object to DTO class object
        dto=new EmployeeDTO();
        dto.setSno(Integer.parseInt(vo.getSno()));
        dto.setSname(vo.getSname());
        dto.setM1(Integer.parseInt(vo.getM1()));
        dto.setM2(Integer.parseInt(vo.getM2()));
        dto.setM3(Integer.parseInt(vo.getM3()));
        
        //Use service class 
        result=service.generateResults(dto);
        
			
			 //display results 
			   sos=res.getOutputStream();
			    pw=res.getWriter();
			  res.setContentType("text/html"); 
			  pw.println("<h1>Result"+result+"</h1");
			 //add hyperlink
			       
        pw.println("<a href='form.html'>Home</a>");
       //close stream
        pw.close();
        
       }
		catch(Exception e) {
			e.printStackTrace();
		}
 }//doGet()

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost()

}//class
