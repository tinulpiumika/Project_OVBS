package com.video;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/displayVideoServlet")
public class displayVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();  	//creating printWriter to add script values to JSP
		response.setContentType("text/html");
		
		
		int id = Integer.parseInt(request.getParameter("vidId"));   //get hidden input values
		
		List<VideoFeedback> videoDet = null;
		
		videoUtil v =  new videoUtil(); 
		videoDet = v.getVideo(id);
		
		request.setAttribute("videoDet", videoDet);
		if(videoDet != null) {
			RequestDispatcher dis = request.getRequestDispatcher("VideoPlayer.jsp");
			dis.forward(request, response);  //forward values to videoPlayer
		}
		else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Unable to access the video');");
			out.println("location='videoResult.jsp'");
			out.println("</script>");
		}
		
		
	}

}
