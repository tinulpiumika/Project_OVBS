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
import javax.servlet.http.HttpSession;

@WebServlet("/searchServlet")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();    //creating printWriter to add script values to JSP
		response.setContentType("text/html");
		
		
		String searchKeyword = request.getParameter("search");    //get user input values
		int filter = Integer.parseInt(request.getParameter("filter"));
		
		
		//creating a session to store keyword
		HttpSession session = request.getSession(); 
		session.setAttribute("key", searchKeyword);
		
		
		
		
		List<Video> slist = null;
		
		videoUtil v =  new videoUtil(); 
		slist = v.searchVideo(searchKeyword, filter);
		
		request.setAttribute("slist", slist);
		if(slist != null) {
			RequestDispatcher dis = request.getRequestDispatcher("searchFound.jsp");
			dis.forward(request, response);   //pass the values to searchFound
		}
		else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Your search keyword did not match any video discription');");
			out.println("location='videoResult.jsp'");
			out.println("</script>");
		}
		
		
		
	}

}