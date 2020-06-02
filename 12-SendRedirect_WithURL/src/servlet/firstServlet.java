package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/firsturl")
public class firstServlet extends HttpServlet {
	
	//@SuppressWarnings("null")
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	String ss=null;
	String eng=null;
	String url=null;
	 RequestDispatcher rd=null;
	 //read form data
	ss=req.getParameter("ss");
	eng=req.getParameter("en");
	//prepare url with query
	if(eng.equalsIgnoreCase("google")) {
		url="https://www.google.com/search?q="+ss;
	}
	else if(eng.equalsIgnoreCase("bing")) {
		url="https://www.bing.com/search?q="+ss;
	 } 
		
	res.sendRedirect(url);
     rd=req.getRequestDispatcher("input.html");
     rd.include(req,res);
	
	//pw.close();
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
