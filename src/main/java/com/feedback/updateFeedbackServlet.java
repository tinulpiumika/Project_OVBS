package com.feedback;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/updateFeedbackServlet")
public class updateFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();		//creating printWriter to add script values to JSP
		response.setContentType("text/html");
		
		String feedbackUpdate = request.getParameter("feedbackUpdate");    //get hidden input from front end
		int feedbackID = Integer.parseInt(request.getParameter("fId"));
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
		
		

		if(check.equals(username) ) {			//validating the user from front end
			
			FeedbackUtil f = new FeedbackUtil();	
			outcome = f.updateFeedback(feedbackID, feedbackUpdate);   //pass the value to model class feedbackUtil	
		}

		
		
		//getOutcome(outcome);
		
		if (outcome == true) {
			out.println("<script type='text/javascript'>");
			out.println("alert('Update Successful');");
			out.println("location='redirect.jsp'");
			out.println("</script>");
						

		}
		else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Unable to update');");
			out.println("location='redirect.jsp'");
			out.println("</script>");

		}
	}

}
