package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/states")
public class States extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String statesindia[]= {"AP","TS","KN","PN"};
		String statesUS[]= {"MI","OR","CA","NY"};
		String stateskenya[]= {"NE","CE","MB","WE"};
		String country=null;
	country=req.getParameter("country");
	
		
		pw=res.getWriter();
		res.setContentType("text/html");
		
		if(country.contentEquals("india")) {
			pw.println("States="+Arrays.toString(statesindia));
		}
		else if(country.contentEquals("us")) {
			pw.println("States="+Arrays.toString(statesUS));
		}
		else {
			pw.println("States="+Arrays.toString(stateskenya));
		}
		pw.println();
		pw.println("<a href='state.html'>HOME</a>");
		pw.close();
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
