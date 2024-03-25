package com.sathya.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// Entering details class
public class EmployeeDao {

	public int save(Employee emp) //This method is for saving employee details
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
		preparedStatement = connection.prepareStatement("insert into emp values(?,?,?)");
		
		//Read the data from emp object and set to parameters
		
		preparedStatement.setInt(1,emp.getEmpId());
		preparedStatement.setString(2, emp.getEmpName());
		preparedStatement.setDouble(3, emp.getEmpSalary());
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



//This method is for getting details of particular empId
	public Employee findbyId(int empId)
	{
		Employee employee=null;
		//try with resource
		try(Connection connection = DbConnection.createConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("select * from emp where empId=?"))
		{
			//Set the data to the parameter
			preparedStatement.setInt(1, empId);
			
			//execute the query
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				//Reading the data from ResultSet setting to the Employee
				
				employee = new Employee();
				employee.setEmpId(resultSet.getInt(1));
				employee.setEmpName(resultSet.getString(2));
				employee.setEmpSalary(resultSet.getDouble(3));
				
			}
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
				return employee;	
	}



//This class has deletebyId method 
	public int deletebyId(int empId)
	{
		int count=0;
		//try with resource
		try(Connection connection = DbConnection.createConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("delete from emp where empId=?"))
		{
			//Set the data to the parameter
			preparedStatement.setInt(1, empId);
			
			//execute the query
			 count = preparedStatement.executeUpdate();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
				return count;
		
	}


// This method is uesd for deteleting emp details by using empSalary
	public int deletebySal(double empSalary)
	{
		int count=0;
		//try with resource
		try(Connection connection = DbConnection.createConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("delete from emp where empSalary>?"))
		{
			//Set the data to the parameter
			preparedStatement.setDouble(1, empSalary);
			
			//execute the query
			 count = preparedStatement.executeUpdate();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
				return count;
		
	}



	//This class has findAll method which is used to print all the employees
	public List<Employee> findAll()
	{
		List<Employee> emps=new ArrayList<>();
		try(Connection connection=DbConnection.createConnection();
			Statement statement=connection.createStatement())
		{
			ResultSet resultSet=statement.executeQuery("select * from emp");
			
			while(resultSet.next())
			{
				Employee emp=new Employee();
				emp.setEmpId(resultSet.getInt(1));
				emp.setEmpName(resultSet.getString(2));
				emp.setEmpSalary(resultSet.getDouble(3));
				emps.add(emp);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return emps;
	}




	//This class has UpdateAll() method which is used to update the salary of the employees who have greater than particular salary
	public int updateSalary(double currentSalary, double incSalary)
	{
		int count=0;
		try(Connection connection=DbConnection.createConnection();
			Statement statement=connection.createStatement();
			PreparedStatement preparedStatement = connection.prepareStatement("update emp set empSalary = empSalary + ? where empSalary > ?"))
		{
			preparedStatement.setDouble(1, incSalary);
			preparedStatement.setDouble(2, currentSalary);
			count = preparedStatement.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return count;
	}
}

