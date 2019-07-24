package com.revature.projectdemo;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		double sqrtvalue = Math.sqrt(4.0);

		out.println("<html><body><h1 align='center'>Hello World Servlet</h1>" + "<br align='center'>The square root of 4.0 is: " + sqrtvalue + "</br>" 
					+ "</body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
    }

	public HelloWorld() {
		super();
	}
}