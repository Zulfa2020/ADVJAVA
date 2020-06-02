package servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
	PrintWriter pw=null;
	pw=res.getWriter();
	res.setContentType("text/html");
//read form data
ss=req.getParameter("ss");

//display
pw.println("<b><a href='https://www.google.com/search?q="+ss+"'>Go to Google </a><b><br>");

	pw.println("<b><a href='https://www.bing.com/search?q="+ss+"'>Go to Bing </a><b>");
	pw.close();
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
