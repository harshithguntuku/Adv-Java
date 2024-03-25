package com.sathya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcEx1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Step1: Load the Driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loaded Successfully");
		
		//Step2: Create the connection
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Harshith","welcome");
		System.out.println("Connection created successfully");
		
		//Step3: Static query execution
		
		Statement statement = connection.createStatement();
		String q1="create table emp(id number, name varchar2(30), salary number)";
		
		int res1=statement.executeUpdate(q1);
		System.out.println("Table created successfully: "+res1);
		
		String q2="drop table emp";
		int res2=statement.executeUpdate(q2);
		System.out.println("Table droped successfully: "+res2);
		
		//Step4: Close the connection
		connection.close();
		System.out.println("Connection closed successfully");
	}

}
