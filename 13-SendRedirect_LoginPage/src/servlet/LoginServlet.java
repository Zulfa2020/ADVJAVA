package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/loginurl")
public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name=req.getParameter("name");
		String pass=req.getParameter("pwd");
		
		
		if(name.equals("zulfa") && pass.equals("zulfacade")) {
			HttpSession session=req.getSession();
			session.setAttribute("username",name);
			
			res.sendRedirect("welcome.jsp");
			
	    }
		else {
			res.sendRedirect("login.jsp");
			
		}
		
	}
public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
