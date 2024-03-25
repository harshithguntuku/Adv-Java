package com.sathya.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class ProcedureExecutionEx {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Harshith","welcome");
		
//		//Example 1 Getting Salary of employee by giving empId as input
//		//Call the Procedure
//		CallableStatement callableStatement = connection.prepareCall("{call getSal(?,?)}");
//		
//		//set the input data
//		callableStatement.setInt(1, 1003);
//		
//		//register one variable to store output
//		callableStatement.registerOutParameter(2, Types.FLOAT);
//		
//		//execute the procedure the output will be stored in registered parameter
//		callableStatement.executeUpdate();
//		
//		//Print the output
//		System.out.println(callableStatement.getFloat(2));
		
		//Example 2: Getting All Employee details by giving empId as input
		//call the Procedure
		CallableStatement callableStatement = connection.prepareCall("{call getDetails(?,?,?,?)}");
		
		//Set the input data
		callableStatement.setInt(1, 1002);
//		callableStatement.setInt(1, 1003);
		
		//register 3 variables to store the output
		callableStatement.registerOutParameter(2, Types.INTEGER);
		callableStatement.registerOutParameter(3, Types.VARCHAR);
		callableStatement.registerOutParameter(4, Types.FLOAT);
		
		//execute
		callableStatement.executeUpdate();
		
		//Print output
		System.out.println(callableStatement.getInt(2));
		System.out.println(callableStatement.getString(3));
		System.out.println(callableStatement.getFloat(4));
		
		connection.close();
	}

}
