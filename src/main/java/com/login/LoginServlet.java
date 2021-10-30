package com.login;

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


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();   //creating printWriter to add script values to JSP
		response.setContentType("text/html");
		
		String username = request.getParameter("username");    //get value from user
		String password = request.getParameter("password");
		boolean isTrue;
		
		
		//create session to store userName
		
		HttpSession session = request.getSession();
		session.setAttribute("usernameDet", username);    //to use in different packages
		
		
		Singleton usernameSession = Singleton.getInstance(username);    //create object to store session
		
		
		session.setAttribute("username", usernameSession); //to use in any JSP file
		
		
		UserDbUtil u =  new UserDbUtil();
		
		isTrue = u.validate(username, password);
		
		if (isTrue == true) {
			List<User> ulist = u.getUser(username);
			request.setAttribute("ulist", ulist);
			
			RequestDispatcher dis = request.getRequestDispatcher("userhome.jsp");
			dis.forward(request, response);
		} else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Your username or password is incorrect');");
			out.println("location='login.jsp'");
			out.println("</script>");
		}
		
	}

}
