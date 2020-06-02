package servlet;

import javax.servlet.http.*;
import javax.sql.DataSource;
import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.servlet.*;
import java.io.*;


import java.sql.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet(value="/dburl")
public class PoolServlet extends HttpServlet {
	@Resource(name="dsjndi")
	private DataSource ds;
@Override
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
	

		Connection con;
		PreparedStatement ps;
		ResultSet rs=null;
		String tabname=null;
		ResultSetMetaData rsmd=null;
		int colno=0;
		Statement st=null;
		PrintWriter pw=null;
		pw=res.getWriter();
	    res.setContentType("text/html");
	//read form data
	    tabname=req.getParameter("table");
	    //jdbc code
	    try {
	    	//get con obj from jdbc con pool
	    	con=ds.getConnection();
	    	//create statement object
	    	st=con.createStatement();
	    	//send and execute sql query
	    	rs=st.executeQuery("select * from "+tabname);
	    	//get result set metadata
	    	rsmd=rs.getMetaData();
	    	//print column names
	    	colno=rsmd.getColumnCount();
	    	pw.println("<table border='1' bgcolor='blue'>");
	    	pw.println("<tr bgcolor='lightpink' >");
	    	for(int i=1;i<=colno;++i) {
	    		pw.println("<th>"+rsmd.getColumnLabel(i)+"</th>");
	    		}
	    	pw.println("</tr>");
 //process the result set
	  while(rs.next()) {
		  pw.println("<tr>");
		  for(int i=1;i<=colno;++i) {
	    		pw.println("<td>"+rs.getString(i)+"</td>");
	    		}
	    	pw.println("</tr>");
	    	
		}
	  pw.println("</table>");
	  
	  pw.println("<br> <a href='input.html'>Try Again </a>");
	//close JDBC objects
	  rs.close();
	  st.close();
	  con.close();
	  
	}//try

	catch(Exception e) {
       RequestDispatcher rd=req.getRequestDispatcher("/errorurl");
       rd.forward(req,res);
	}
	    //close streams
	    pw.close();
}//doGet

public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
	doGet(req,res);
  }//doPost
}//class
