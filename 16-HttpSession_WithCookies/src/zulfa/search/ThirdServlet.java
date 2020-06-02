package zulfa.search;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@WebServlet("/turl")
public class ThirdServlet extends HttpServlet{
	private static final String INSERT_QUERY="INSERT INTO NAUKRI_INFO VALUES(JSID_SEQ.NEXTVAL,?,?,?,?,?,?,?)";
	@Resource(name="dsjndi")
	private DataSource ds;
	@Override	
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	
	PrintWriter pw=null;
	String location=null,name=null,addrs=null,skills=null;
	int expsal=0,exp=0,age=0;
	HttpSession ses=null;
	Connection con=null;
	PreparedStatement ps=null;
	int count=0;
	
	
	pw=res.getWriter();
	res.setContentType("text/html");
	
	location=req.getParameter("location");
	expsal=Integer.parseInt(req.getParameter("expsal"));
	
	ses=req.getSession(false);
	
	name=(String) ses.getAttribute("name");
	addrs=(String) ses.getAttribute("addrs");
	skills=(String) ses.getAttribute("skills");
	age=(Integer) ses.getAttribute("age");
	exp=(Integer) ses.getAttribute("exp");
	
	try {
	con=ds.getConnection();
	ps=con.prepareStatement(INSERT_QUERY);
	ps.setString(1,name);
	ps.setString(2,addrs);
	ps.setInt(3,age);
	ps.setInt(4,exp);
	ps.setString(5,skills);
	ps.setInt(6,expsal);
	ps.setString(7,location);
	
    count=ps.executeUpdate();
    if(count==0) {
    	pw.println("<h1 style='color:red;text-align:center'>Registration failed</h1>");
	    
    }
    else {
    	pw.println("<h1 style='color:red;text-align:center'>Registration Succeeded </h1>");
	    
    }
    	
	}
    catch(SQLException se) {
		se.printStackTrace();
		pw.println("<h1 style='color:red;text-align:center'>Registration failed</h1>");
	    
	}
	catch(Exception e) {
		e.printStackTrace();
		pw.println("<h1 style='color:red;text-align:center'>Internal Problem </h1>");
	    
	}
	finally {
		try {
			if(con!=null)
				con.close();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		try {
			if(ps!=null)
				ps.close();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
	}
	pw.println("<h3 style='color:red;text-align:center'><b>User Information </b>"+"</h3>"+"<br>");
    
	 pw.println("<b>Name: </b>"+name+"<br>");
	    pw.println("<b>Address: </b>"+addrs+"<br>");
	    pw.println("<b>Age: </b>"+age+"<br>");
	    pw.println("<b>Exprience: </b>"+exp+"<br>");
	    pw.println("<b>Skills: </b>"+skills+"<br>");
	    pw.println("<b>Salary: </b>"+expsal+"<br>");
	    pw.println("<b>Location: </b>"+location+"<br>");
	    pw.println();
	    
	    	
	
	
	pw.println("<br><br><a href='input.html'>Home</a>");
	pw.close();
}
@Override
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	doGet(req,res);
}
}




  