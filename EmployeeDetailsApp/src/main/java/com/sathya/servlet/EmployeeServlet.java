package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//Step 1: Read the form data
		int empId = Integer.parseInt(request.getParameter("empId"));
		String empName = request.getParameter("empName");
		Double empSal = Double.parseDouble(request.getParameter("empSal"));
		
		//Step 2: Process the form data
		double hra,da, pf,grossSal;
		if(empSal>=50000)
		{
			hra=0.30*empSal;
			da=0.10*empSal;
			pf=0.06*empSal;
		}
		else if(empSal<50000 && empSal>25000)
		{
			hra=0.20*empSal;
			da=0.05*empSal;
			pf=0.03*empSal;			
		}
		else
		{
			hra=0.10*empSal;
			da=0.03*empSal;
			pf=0.02*empSal;				
		}
		grossSal=empSal+hra+da-pf;
		
		
		//Step 3: Render the response to Client
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<bgcolor=grey>");
		writer.println("Employee ID : "+empId+"<br>");
		writer.println("Employee Name : "+empName+"<br>");
		writer.println("Employee Basic Salary : "+empSal+"<br>");
		writer.println("HRA Amount : "+hra+"<br>");
		writer.println("DA Amount : "+da+"<br>");
		writer.println("PF Amount : "+pf+"<br>");
		writer.println("Gross Salary : "+grossSal+"<br>");
		writer.println("</html>");
	}

}
