package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.EmployeeBO;

public class EmployeeDAOImpl  implements EmployeeDAO  {
private static final String STUDENT_INSERT_QUERY="INSERT INTO STUDENT VALUES(?,?,?,?,?)"; 
	public int insert(EmployeeBO bo){
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		
	try{
	//create initialcontext
		ic=new InitialContext();
		//get Datasource object through lookup operation
	ds=(DataSource) ic.lookup("java/comp/env/dsjndi");
	//get connection from JDBC con pool
	con=ds.getConnection();
	//create preparedstatement object
	ps=con.prepareStatement(STUDENT_INSERT_QUERY);
	//set values to query params
	ps.setInt(1, bo.getSno());
	ps.setString(2, bo.getSname());
	ps.setInt(3, bo.getTotal());
	ps.setFloat(4, bo.getAvg());
	ps.setString(5, bo.getResult());
	//execute query
	result=ps.executeUpdate();
	
	
	}//try
	catch(SQLException se) {
		se.printStackTrace();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		try {
			if(ps!=null)
		ps.close();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		try {
			if(con!=null)
		con.close();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		
	}//finally
	return result;
	}//insert
	
}//class
