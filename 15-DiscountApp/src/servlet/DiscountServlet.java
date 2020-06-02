package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/discurl")
public class DiscountServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		float disc=0.0f;
		float finalamt=0.0f;
		float amt=0.0f;
		String name=null;
		
		
		amt=Float.parseFloat(req.getParameter("bill"));
		name=req.getParameter("iname");
	     //calculate discount
		disc=amt*0.2f;
		finalamt=amt-disc;
		
		//display bill details
		pw.println("<br><h4><b> Item Name: "+name+"</b></h4>");
		pw.println("<br><h4><b> Item Bill Amt: "+amt+"</b></h4>");
		pw.println("<br><h4><b> Discount: "+disc+"</b></h4>");
		pw.println("<br><h4><b> FinalAmt: "+finalamt+"</b></h4>");
		
		pw.println("<br><a href='/SendRedirect_Method_BillApp/input.html'>Home</a>");
		
		pw.close();
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
