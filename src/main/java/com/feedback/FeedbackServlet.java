package com.feedback;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();	 //creating printWriter to add script values to JSP
		response.setContentType("text/html");
		
		
		String feedback = request.getParameter("feedback");      //get user feedback
		String id = request.getParameter("videoID");			//get hidden input values
		int vid = Integer.parseInt(id);
		
		
		
		//get userName from the session
		HttpSession session = request.getSession(); 
		String UN = (String) session.getAttribute("usernameDet");
		
		//creating session to redirect
		session.setAttribute("vid", id);
		
		
		//pass the value to model class feedbackUtil
		FeedbackUtil f = new FeedbackUtil();
		boolean outcome = f.insertFeedback(feedback, vid, UN);
		
		if (outcome == true) {
			out.println("<script type='text/javascript'>");
			out.println("alert('Feedback Submitted');");
			out.println("location='redirect.jsp'");
			out.println("</script>");
						

		}
		else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Submission Failed');");
			out.println("location='VideoPlayer.jsp'");
			out.println("</script>");

		}
		
		
	}

}
