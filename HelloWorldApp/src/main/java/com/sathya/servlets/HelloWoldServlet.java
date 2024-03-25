package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hari")
public class HelloWoldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter writer=response.getWriter();
		
		response.setContentType("text/html");
		writer.println("<h1>Welcome to Sathya Tech</h1>");
		writer.println("<h2>Advance java first program</h2>");
		writer.println("<h3>Servlets first program</h3>");
		writer.println("<h3>Ratan sir classes</h3>");
		
	}	

}


