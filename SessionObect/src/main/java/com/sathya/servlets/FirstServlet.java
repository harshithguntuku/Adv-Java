package com.sathya.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Get Form data
		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age")); 
		
		//Create session object
		HttpSession session = request.getSession(); 
		
		//Setting the data into Session object
		session.setAttribute("username", username);
		session.setAttribute("age", age);

		//Response to fill next form
		RequestDispatcher dispatcher = request.getRequestDispatcher("second.html");
		dispatcher.forward(request, response);
		
	}

}
