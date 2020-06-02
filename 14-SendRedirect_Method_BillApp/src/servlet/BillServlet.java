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

@SuppressWarnings("serial")
@WebServlet("/billurl")
public class BillServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		PrintWriter pw=null;
		String name=null;
		Float price=0.0f;
		Float bamt=0.0f;
		Float qty=0.0f;
		//ServletContext sc1=null;
		//ServletContext sc2=null;
		//RequestDispatcher rd=null;
		
		pw=res.getWriter();
		res.setContentType("text/html");
		name=req.getParameter("t1");
		price=Float.parseFloat(req.getParameter("t2"));
		qty=Float.parseFloat(req.getParameter("t3"));
		//calculate bill amount
		bamt=price*qty;
		if(bamt>=5000) {
			
		res.sendRedirect("/DiscountApp/discurl?bill="+bamt+"&iname="+name);
		
		}
		else {
			pw.println("<br><b> Item Name:"+name+"</b>");
			pw.println("<br><b> Price:"+price+"</b>");
			pw.println("<br><b> Qty:"+qty+"</b>");
			pw.println("<br><b> Bill Amt="+bamt+"</b>");
		}
		pw.println("<br><h1 style=color:#049372><a href='input.html'>Home</a></h1>");
		
		pw.close();
		
		
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
