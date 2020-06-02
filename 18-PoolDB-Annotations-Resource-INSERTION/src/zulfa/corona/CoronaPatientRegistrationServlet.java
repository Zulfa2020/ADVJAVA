package zulfa.corona;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

//@WebServlet("/registrationurl")
@WebServlet(urlPatterns ="/coronaurl",loadOnStartup = 1,name = "corona")
public class CoronaPatientRegistrationServlet extends HttpServlet {
	 @Resource(name="dsjndi")
	private DataSource ds;
	 private static  final String  INSERT_CORONA_QUERY="INSERT INTO CORONA_PATIENTS VALUES(PATID_SEQ.NEXTVAL,?,?,?,?)";
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String patName=null,location=null,hospital=null;
		int age=0;
		Connection con=null;
		PreparedStatement ps=null;
		ServletConfig cg=null;
		int count=0;
	    //get PrintWriter
		pw=res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data
		patName=req.getParameter("patName");
		location=req.getParameter("location");
		age=Integer.parseInt(req.getParameter("patAge"));
		hospital=req.getParameter("hospital");
		try {
			//get Pooled JDBC con object
			con=ds.getConnection();
			//create JDBC PreparedStatement object
			ps=con.prepareStatement(INSERT_CORONA_QUERY);
			//set values to query params
			ps.setString(1, patName);
			ps.setInt(2, age);
			ps.setString(3, location);
			
			ps.setString(4, hospital);
			//execute the query
			count=ps.executeUpdate();
			//process the result
			if(count==0)
				pw.println("<h1 style='color:red;text-align:center'>Registration failed </h1>");
			else
				pw.println("<h1 style='color:green;text-align:center'>Registration succeded </h1>");
			
			
		}
		catch(SQLException se) {
			se.printStackTrace();
			pw.println("<h1 style='color:red;text-align:center'>Registration failed </h1>");
		}
		catch(Exception e) {
			e.printStackTrace();
			pw.println("<h1 style='color:red;text-align:center'>Unknow Problems </h1>");
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
					con.close(); //releases the jdbc con obj back to jdbc con pool
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			pw.println("<h1><a href='register.html'>home</a></h1>");
			
			try {
				if(pw!=null)
					pw.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}//finally
		
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
	
	
}//class