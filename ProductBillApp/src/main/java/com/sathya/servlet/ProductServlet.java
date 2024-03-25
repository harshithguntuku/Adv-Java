package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		Step 1: Read the form data
		int proId = Integer.parseInt(request.getParameter("proId"));
		String proName = request.getParameter("proName");
		double proPrice=Double.parseDouble(request.getParameter("proPrice"));
		int proQuantity=Integer.parseInt(request.getParameter("proQuantity"));

//		Step 2:Process the data	
		double discount, totalBill;
		double netAmount;
		
		totalBill=proPrice*proQuantity;

		if(totalBill>1000 && totalBill<5000)
		{
			discount=0.05*totalBill;
			netAmount=totalBill-discount;
		}
		
		else if(totalBill>5000 && totalBill<10000)
		{
			discount=0.10*proPrice;
			netAmount=totalBill-discount;
		}
		
		else if(totalBill>10000)
		{
			discount=0.15*proPrice;
			netAmount=totalBill-discount;
		}
		
		else
		{
			discount =0;
			netAmount=totalBill;
		}
		
//		Step 3: Render the response 
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("Product ID : "+proId+"<br>");
		writer.println("Product Name : "+proName+"<br>");
		writer.println("Product Price : "+proPrice+"<br>");
		writer.println("Product Quantity : "+proQuantity+"<br>");
		writer.println("Total bill : "+totalBill+"<br>");
		writer.println("Discount : "+discount+"<br>");
		writer.println("Net Amount to Pay : "+netAmount+"<br>");
		

		writer.println("</html>");
	}


}
