package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
@WebServlet("/poolurl")
public class PoolServlet extends HttpServlet {
	@Resource(name="dsjndi")
	private DataSource ds;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Connection con;
		PreparedStatement ps;
		ResultSet rs=null;
		String tabname=null;
		ResultSetMetaData rsmd=null;
		int colno=0;
		Statement st=null;
		RequestDispatcher rd=null,rd1=null,rd2=null;
		PrintWriter pw=null;
		pw=res.getWriter();
	    res.setContentType("text/html");
	//read form data
	    tabname=req.getParameter("table");
	    //jdbc code
	    try {
	    	//include header content 
	    	rd1=req.getRequestDispatcher("/headurl");
	    	rd1.include(req,res);
	    	
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
	    	//process result set
	    	
	    	
	    	
	    	
	   
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
	  //include footer content
	  rd2=req.getRequestDispatcher("/footer.html");
  	rd2.include(req,res);
  	
	//close JDBC objects
	  rs.close();
	  st.close();
	  con.close();
	  
	}//try

	catch(Exception e) {
       rd=req.getRequestDispatcher("/errorurl");
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
