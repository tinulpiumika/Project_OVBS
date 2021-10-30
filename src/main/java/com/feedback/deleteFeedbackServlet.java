package com.feedback;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/deleteFeedbackServlet")
public class deleteFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();		//creating printWriter to add script values to JSP
		response.setContentType("text/html");
		
		
		int feedbackID = Integer.parseInt(request.getParameter("fId"));     //get hidden input from front end
		String username = request.getParameter("fuser");
		String id = request.getParameter("videoID");
		

		
		boolean outcome = false;
		
		//get userName from the session
		HttpSession session = request.getSession(); 
		String check = (String)session.getAttribute("usernameDet");
		
		if(check == null) {
			check = " ";
		}

		
		//creating session to redirect
		session.setAttribute("vid", id);
		
		

		if(check.equals(username) ) {     //2nd validation of user from session
			
			FeedbackUtil f = new FeedbackUtil();
			outcome = f.deleteFeedback(feedbackID);   //pass the value to model class feedbackUtil	
			
		}

		
		
		//getOutcome(outcome);
		
		if (outcome == true) {
			out.println("<script type='text/javascript'>");
			out.println("alert('Delete Successful');");
			out.println("location='redirect.jsp'");
			out.println("</script>");
						

		}
		else {
			out.println("<script type='text/javascript'>");
			out.println("alert('delete Failed');");
			out.println("location='redirect.jsp'");
			out.println("</script>");

		}
	}



}
