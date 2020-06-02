package com.nt.service;

import com.nt.dto.EmployeeDTO;
import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dao.EmployeeDAOImpl;

public class EmployeeService implements EmployeeMGTService {
private EmployeeDAO dao;


	public EmployeeService(EmployeeDAO dao) {
	
	this.dao = dao;
}

	public String generateResults(EmployeeDTO dto)throws Exception {
		int total=0;
		float avg=0.0f;
		String result=null;
		EmployeeBO bo=null;
		
		int cnt=0;
		//b.logic to calculate
		total=dto.getM1()+dto.getM2()+dto.getM3();
		avg=total/3.0f;
		if(avg<40) {
			result="fail";
		}
		else {
			result="pass";
		}
		
		//prepare BO class
		bo=new EmployeeBO();
		bo.setSno(dto.getSno());
		bo.setSname(dto.getSname());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		//use DAO
		
		cnt=dao.insert(bo);
		if(cnt==0) {
			return "Registration Failed";
			
		}
		else
			return "Registration Succeded ";
		
		
		
	}//generateResults

	
}
