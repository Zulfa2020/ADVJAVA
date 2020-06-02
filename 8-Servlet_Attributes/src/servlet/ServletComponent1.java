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

@WebServlet("/comp1")
public class ServletComponent1 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		HttpSession ses=null;
		RequestDispatcher rd=null;
		ServletContext sc=null;
		
		pw=res.getWriter();
		res.setContentType("text/html");
		//create request attribute
		req.setAttribute("att1", "val1");
		//create session attribute
		ses=req.getSession();
		ses.setAttribute("att2","val2");
		//create servletcontext attribbute
		sc=getServletContext();
	   sc.setAttribute("att3","val3");
	   
	   //forward request to ServletComp2 
	   rd=req.getRequestDispatcher("/s2url");
	   rd.forward(req, res);
	   
	   pw.close();
	}
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
