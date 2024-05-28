package com.tap;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class EmployeeBO {
	static final String url = "jdbc:mysql://localhost:3306/satish";
	static final  String username = "root";
	static final  String password ="Sasu@1209";
	static final String Insert_Query = "INSERT into 'employees' ('id','name','email','department','salary') values (?,?,?,?,?)";
	private Connection connection;
	private PreparedStatement statement;
	
	public EmployeeBO()
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection(url,username,password);
		}
		catch(ClassNotFoundException | SQLException | NumberFormatException e)
		{
			e.printStackTrace();
		}
		
	}
		
	public  int save(Employee e)
	{
		try {
	
		statement=connection.prepareStatement(Insert_Query);
		statement.setInt(1, e.getId());
		statement.setString(2, e.getName());
		statement.setString(3, e.getEmail());
		statement.setString(4, e.getDepartment());
		statement.setInt(5, e.getSalary());
		
		int i = statement.executeUpdate();
		return i;
		
						
		}
		catch(SQLException | NumberFormatException e1)
		{
			e1.printStackTrace();
		}
		return 0;
	
		
		
	}

}
