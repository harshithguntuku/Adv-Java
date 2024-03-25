package com.sathya.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDao 
{
	
// For Table creation create a method
	public int createProduct1Table()
	{
		
	}
//  For Table creation	
//	public static void main(String args[]) throws SQLException
//	{
//		Connection connection = DbConnection.createConnection();
//		Statement statement = connection.createStatement();
//		String q1 = "create table product1(proId number, proName varchar2(30), proPrice number)";
//		
//		int res1 = statement.executeUpdate(q1);
//		System.out.println("Table created successfully: "+res1);
//		
//		connection.close();
//		System.out.println("Connection closed successfully");
//	}
	
	public int saveProduct(Product product) //This method is for saving employee details
	{
		//Declare the resources
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int count=0;
	
	try
	{
		//Get the connection
		connection = DbConnection.createConnection();
		
		//Create PreparedStatement object
		preparedStatement = connection.prepareStatement("insert into product1 values(?,?,?)");
		
		//Read the data from pro object and set to parameters
		
		preparedStatement.setInt(1,product.getProId());
		preparedStatement.setString(2, product.getProName());
		preparedStatement.setDouble(3, product.getProPrice());
		count=preparedStatement.executeUpdate();
		
	}
	
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	
	finally
	{
		//before release connection check the connection is present or not
		try {
		if(connection!=null)
			connection.close();
		
		if(preparedStatement!=null)
			preparedStatement.close();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	return count;
	}
}

	

