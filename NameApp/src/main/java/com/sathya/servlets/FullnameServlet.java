package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FullnameServlet")
public class FullnameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		Step 1: Read the form data
		String firstname = request.getParameter("firstname");
		String middlename = request.getParameter("middlename");

		String lastname = request.getParameter("lastname");

		
//		Step 2: process the form data
		String name;
		if(firstname.equals("Harshith") && middlename.equals("") && lastname.equals("Guntuku"))
		{
			name="Harshith Guntuku";
		}
		
		else
		{
			name="Invalid Name";
		}
		
//		Step 3: Render the response to the Client
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<h1>Full Name</h1>"+name);
		writer.println("</html>");
	}

}