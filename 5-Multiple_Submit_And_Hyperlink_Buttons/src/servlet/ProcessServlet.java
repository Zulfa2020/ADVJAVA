package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ProcessServlet extends HttpServlet {
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException,NullPointerException {
	PrintWriter pw=null;
	String pval=null;
	int val1=0,val2=0;
	pw=res.getWriter();
	res.setContentType("text/html");
	
	pval=req.getParameter("s1");
	//writing logic
		
		
   if(pval.equalsIgnoreCase("link2")) {
			
		pw.println("SYSYTEM PROPERTIES::"+System.getProperties());
		}
   else if(pval.equalsIgnoreCase("link1")) {
		pw.println("SYSYTEM DATE::"+new Date());
	}
		
	else if(pval.equalsIgnoreCase("add")) {
		val1=Integer.parseInt(req.getParameter("t1"));
		val2=Integer.parseInt(req.getParameter("t2"));
	
		pw.println("ADD::"+(val1+val2));
	}
	else if(pval.equalsIgnoreCase("sub")) {
		val1=Integer.parseInt(req.getParameter("t1"));
		val2=Integer.parseInt(req.getParameter("t2"));
	
		pw.println("SUB::"+(val1-val2));
	}
	else if(pval.equalsIgnoreCase("div")) {
		val1=Integer.parseInt(req.getParameter("t1"));
		val2=Integer.parseInt(req.getParameter("t2"));
	
		pw.println("DIV::"+(val1/val2));
	}
	else {
		val1=Integer.parseInt(req.getParameter("t1"));
		val2=Integer.parseInt(req.getParameter("t2"));
	
		pw.println("MUL::"+(val1*val2));
	}
    pw.println(" <br> <a href='process.html'>HOME</a>");
	pw.close();
	

}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
