package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=null;
		String name=null, gen=null,address=null, qlfy=null,ms=null,time=null,dob=null,color=null,mail=null;
		int age=0;
		String month=null,week=null,furl=null;
		long mobileNo=0;
		
		
		
		pw=res.getWriter();
		res.setContentType("text/html");
		
		name=req.getParameter("name");
		gen=req.getParameter("gen");
		address=req.getParameter("address");
		qlfy=req.getParameter("qlfy");
		ms=req.getParameter("ms");
		if(ms==null) {
			ms="single";
		}
		String crs[]=req.getParameterValues("crs");
		if(crs==null) {
			pw.println("you are super lazy");
		}
		String hb[]=req.getParameterValues("hb");
		age=Integer.parseInt(req.getParameter("age"));
		
		color=req.getParameter("color");
		mobileNo=Long.parseLong(req.getParameter("mobileNo"));
		mail=req.getParameter("mail");
		furl=req.getParameter("furl");
		dob=req.getParameter("dob");
		week=req.getParameter("week");
		month=req.getParameter("month");
		time=req.getParameter("time");
		
		
		if(gen.equalsIgnoreCase("M")) {
		       if(age<=10) {
				pw.println("master "+name+" you are a baby boy");
			}
		    else if(age<=20) {
			pw.println("mr. "+name+" you are a teenage boy");
		     }
		      if(age<=40) {
			pw.println("mr. "+name+" you are a young man");
		   }
		   else if(age<=50) {
			pw.println("mr. "+name+" you are a middle-aged man");
	       	}
	        	else {
			pw.println("mr. "+name+" you are a old man");
			
		     }
			
		      }//if
       else if(gen.equalsIgnoreCase("F")){
		       	if(age<=10) {
		     		pw.println("master "+name+" you are a baby girl");
		          	}
		      else if(age<=20) {
		    	  if(ms.equalsIgnoreCase("married")) {
		    		  
		    		  pw.println("mrs "+name+" you are a married teenage girl");
				        
		    	  }
		    	  else {
			         pw.println("miss "+name+" you are a teenage girl");
		       }
		      }
	       	else if(age<=40) { 
	       	 if(ms.equalsIgnoreCase("married")) {
	    		  
	    		  pw.println("mrs "+name+" you are a married young woman");
			        
	    	  }
	    	  else {
	       	
			pw.println("miss "+name+" you are a young woman");
		         } 
	       	}
		   else if(age<=50) {
			   if(ms.equalsIgnoreCase("married")) {
		    		  
		    		  pw.println("mrs "+name+" you are a married middle-aged woman");
				        
		    	  }
		    	  else {
		   
			        pw.println("miss "+name+" you are a middle-aged woman");
		     }
		   }
		    else {
		    	 if(ms.equalsIgnoreCase("married")) {
		    		  
		    		  pw.println("mrs "+name+" you are a married old woman");
				        
		    	  }
		    	  else {
		    
			pw.println("miss "+name+" you are a old woman");
			
		       }
		    }
		}//else
		pw.println("<br>   Name="+name);
		pw.println("<br>   Age="+age);
		pw.println("<br> Gender="+gen);
		pw.println("<br>   Address="+address);
		pw.println("<br> 	Qualification="+qlfy);
		pw.println("<br>   Courses="+Arrays.toString(crs));
		pw.println("<br>    Hobbies="+Arrays.toString(hb));
		pw.println("<br>   MaritalStatus="+ms);
		pw.println("<br>   Color="+color);
		
		pw.println("<br>   MobileNo="+mobileNo);
		pw.println("<br>   Email="+mail);
		pw.println("<br>   Url="+furl);
		pw.println("<br>   Dob="+dob);
		pw.println("<br>   Week="+week);
		pw.println("<br>   Month="+month);
		pw.println("<br>   Time="+time);
		
		

		pw.println();
		pw.println("<br> <a href='form.html'><img src='images.jfif'></a>");
		pw.close();
		
		

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
