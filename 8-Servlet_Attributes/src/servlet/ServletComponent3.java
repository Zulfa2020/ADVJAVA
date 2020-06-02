package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/comp3")
public class ServletComponent3 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		HttpSession ses=null;
		RequestDispatcher rd=null;
		ServletContext sc=null;
		
		pw=res.getWriter();
		res.setContentType("text/html");
		
		//read and display request attribute
		pw.println("<br><b> ServletComp3:(att1) Value ="+req.getAttribute("att1"));
		//read and display session attribute
		ses=req.getSession();
		pw.println("<br><b> ServletComp3:(att2) Value ="+req.getAttribute("att2"));
		//read and display servletcontext attribute
		sc=req.getServletContext();
		pw.println("<br><b> ServletComp3:(att3) Value ="+req.getAttribute("att3"));
		
		
	}
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
