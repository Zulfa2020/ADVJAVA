package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/errorurl")
public class ErrorServlet extends HttpServlet {
	

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		/*
		 //include header content 
		 
		RequestDispatcher rd=null,rd1=null,rd2=null;
		
		rd1=req.getRequestDispatcher("/headurl");
    	rd1.include(req,res);
    	*/
    	
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");

		//display error
		
		pw.println("<h1> <center>INTERNAL PROBLEM-->TRY AGAIN</center></h1>");
	       pw.println("<br> <a href='input.html'>Try Again </a>");
	       /*
	       //foooter content
	       rd2=req.getRequestDispatcher("/footer.html");
	     	rd2.include(req,res);
	     	*/
            pw.close();
            
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
