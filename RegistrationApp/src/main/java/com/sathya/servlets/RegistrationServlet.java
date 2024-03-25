package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Step1: Read the form data
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String gender=request.getParameter("gender");
		
		String dob=request.getParameter("dob");
		Long phone=Long.parseLong(request.getParameter("phone"));
		String mail=request.getParameter("mail");
		
		String country=request.getParameter("country");
		String[] quals =request.getParameterValues("qualification");
		
		String[] langs =request.getParameterValues("languages");
		String comments=request.getParameter("comments");

		//Step2: Process the data
		String q=String.join(",", quals);
		String l=String.join(",",langs);
		
		//Step3: Render the data
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<h2>Registered Successfully</h2>");
		writer.println("Username : "+username+"<br>");
		writer.println("Password : "+password+"<br>");
		writer.println("Gender : "+gender+"<br>");
		writer.println("DOB : "+dob+"<br>");
		writer.println("Phone number : "+phone+"<br>");
		writer.println("Email : "+mail+"<br>");
		writer.println("Country : "+country+"<br>");
		writer.println("Qualification : "+q+"<br>");
		writer.println("Language : "+l+"<br>");
		writer.println("Comments : "+comments+"<br>");		
		writer.println("</body>");
		writer.println("</html>");
	}

}
