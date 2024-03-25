package com.sathya.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GenerateNumberServlet")
public class GenerateNumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Step 1: Read the form data
		int num1,num2;
		num1 = Integer.parseInt(request.getParameter("first"));
		num2 = Integer.parseInt(request.getParameter("last"));
		String operation = request.getParameter("operation");
		
		//Step 2: Process the form data
		StringBuffer sb=new StringBuffer();
		
		switch(operation)
		{
			case "even" :
				for(int i=num1;i<=num2;i++)
				{
					if(i%2==0)
					{
						sb.append(i+ " ");	
					}
				}
				;break;
				
			case "odd" :
				for(int i=num1;i<=num2;i++)
				{
					if(i%2==1)
					{
						sb.append(i+" ");
					}
				}
				;break;
				
			case "prime" :
				int count;
				for(int i=num1;i<=num2;i++)
				{
					count=0;
					for(int j=2;j<=i;j++)
					{
						if(i%j==0)
						{
							count++;
						}
					}
					if(count==1)
					{
						sb.append(i+" ");
					}
					
				}
				;break;

			case "perfect" :
				int sum;
				for(int i=num1;i<=num2;i++)
				{
					sum=0;
					for(int j=1;j<i;j++)
					{
						if(i%j==0)
						{
							sum=sum+j;
						}
					}
					if(sum==i)
					{
						sb.append(i+" ");
					}
					
				}
				;break;
				
				
			case "strong" :
				int n,temp1,rem,sum1,fact;
				for(int i=num1;i<=num2;i++)
				{
					temp1=i;
					n=i;
					sum1=0;
					while(temp1>0)
					{
						rem=temp1%10;
						fact=1;
						for(int j=1;j<=rem;j++)
						{
							fact=fact*j;
						}
						sum1=fact+sum1;
						temp1=temp1/10;
					}
					if(sum1==n)
					{
						sb.append(n+" ");
					}
				}
			
				;break;
				
	
		}
		
		//Step3: Render the response to the client
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<body bgcolor=yellow>");
		writer.println("<h4> Your Result : </h4>");
		writer.println("<p>"+operation+" numbers in between "+num1+" to "+num2+" are "+sb);
		writer.println("</body>");
		writer.println("</html>");
	}

}
