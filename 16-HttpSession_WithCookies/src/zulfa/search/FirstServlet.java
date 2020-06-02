package zulfa.search;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/furl")
public class FirstServlet extends HttpServlet{
@SuppressWarnings("deprecation")
@Override
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	
	PrintWriter pw=null;
	String name=null,addrs=null;
	int age=0;
	HttpSession ses=null;
	
	
	pw=res.getWriter();
	res.setContentType("text/html");
	
	name=req.getParameter("name");
	addrs=req.getParameter("addrs");
	age=Integer.parseInt(req.getParameter("age"));
	
	ses=req.getSession();
	
	ses.setAttribute("name",name);
	ses.setAttribute("addrs",addrs);
	ses.setAttribute("age",age);
	
	
	
	pw.println("<body bgcolor='lightblue'>");
	pw.println("<form action="+res.encodeUrl("surl")+" method='post'>");
	
	//pw.println("<form action='surl' method='post'>");
	pw.println("<b>Expreince:</b><input type='text' name='exp'>");
	pw.println("<br><b>Skills:</b><Select name='skills'>");
	pw.println("<option value=''>---select an option---</option>");
	pw.println("<option value='Java'>JAVA</option>");
	pw.println("<option value='Html'>HTML</option>");
	pw.println("<option value='Php'>PHP</option>");
	pw.println("<option value='Devops'>DeVoPS</option>");
	pw.println("</Select>");
	pw.println("<br><input type='submit' value='Continue'>");
	pw.println("</form>");
	pw.println("</body>");
	
	
	
	pw.close();
}
@Override
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	doGet(req,res);
}
}