package com.video;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VideoServlet")
public class VideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//PrintWriter out = response.getWriter();
		//response.setContentType("text/html");
		
			videoUtil v =  new videoUtil(); 
			List<Video> vlist = v.getAllVideo();      //get most recent video available
			request.setAttribute("vlist", vlist);
			
			RequestDispatcher dis = request.getRequestDispatcher("videoResult.jsp");
			dis.forward(request, response);

}
}
