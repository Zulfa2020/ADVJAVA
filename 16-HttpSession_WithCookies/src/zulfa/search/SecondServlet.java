package zulfa.search;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/surl")
public class SecondServlet extends HttpServlet{
	@Override
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	
	PrintWriter pw=null;
	String skills=null;
	int exp=0;
	HttpSession ses=null;
	
	
	pw=res.getWriter();
	res.setContentType("text/html");
	
	skills=req.getParameter("skills");
	exp=Integer.parseInt(req.getParameter("exp"));
	
	ses=req.getSession(false);
	
	ses.setAttribute("skills",skills);
	ses.setAttribute("exp",exp);
	
	
	
	
	pw.println("<body bgcolor='cyan'>");
	pw.println("<form action="+res.encodeUrl("turl")+" method='post'>");
	
	//pw.println("<form action='turl' method='post'>");
	pw.println("<b>Expected Salary:</b><input type='text' name='expsal'>");
	pw.println("<br><b>Location:</b><input type='text' name='location'>");
	
	pw.println("<br><input type='submit' value='Register'>");
	pw.println("</form>");
	pw.println("</body>");
	
	
	
	pw.close();
}
	@Override
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	doGet(req,res);
}
}


