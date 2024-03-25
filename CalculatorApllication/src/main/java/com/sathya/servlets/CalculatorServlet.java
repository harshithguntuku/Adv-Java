package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Step 1: Read the form data
		int num1,num2;
		num1 = Integer.parseInt(request.getParameter("first"));
		num2 = Integer.parseInt(request.getParameter("second"));
		String operation = request.getParameter("operation");
		
		//Step 2: Process the form data
		int result=0;
		switch(operation)
		{
			case "+" : result = num1+num2;break;
			case "-" : result = num1-num2;break;
			case "*" : result = num1*num2;break;
			case "/" : result = num1/num2;break;
			case "%" : result = num1%num2;break; 
		}
		
		//Step3: Render the response to the client
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<body bgcolor=pink>");
		writer.println("<p> Your Result : "+result+"</p>");
		writer.println("</body>");
		writer.println("</html>");
	}

}
