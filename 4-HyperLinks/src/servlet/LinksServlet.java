package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String link=null;
	
		
		pw=res.getWriter();
		res.setContentType("text/html");
		
		link=req.getParameter("s1");
		if(link.equalsIgnoreCase("link1")) {
			Locale locales1[]=Locale.getAvailableLocales();
		for(Locale lc:locales1) {
			pw.println(lc.getDisplayLanguage()+"<br>");
		}
		}
		else if(link.equalsIgnoreCase("link2")) {
			Locale locales1[]=Locale.getAvailableLocales();
		for(Locale lc:locales1) {
			pw.println(lc.getDisplayCountry()+"<br>");
		}
		}
		else
			pw.println("Date and Time"+new Date());
		
		
		pw.println(" <br> <a href='link.html'>HOME</a>");
		pw.close();

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
