package com.TechM.in.dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class IncreaseSalBasedonDept {

	private static final String URL = "jdbc:mysql://localhost:3306/advancejava";

	private static final String USERNAME = "root";

	private static final String PASSWORD = "root";
	private static final String sql = "select * from employe";

	// in the above code all the salary will be updated at one short bcz business
	// logic will be exedcuted at databases
	//in the above program depertment wise hike will be decided for every dept we need to execute one update quary
	//if we have 500 dept in company then our java program should communicate with database for 500time for every query it is not 
	//recomended bcx every time quary will heat database thats why performance will be redused thats whi it is not recomended 
	//if we have so many databased call from java then network calls wiil be in crease program and database
	//to avoide this problem we can used procedure in datababase with business logic
	public static void main(String[] args) throws Exception {
		
		
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Hike_securiy:-");
		double Sec_hike = s.nextDouble();		
		
		
		System.out.println("Enter Hike Hr:-");
		double Hr_hike = s.nextDouble();		
		
		System.out.println("Enter Hike Admin:-");
		double Admin_hike = s.nextDouble();	
		
		System.out.println("Enter Hike RND:-");
		double RND_hike = s.nextDouble();	
		
		System.out.println("Enter Hike Salse:-");
		double Salse_hike = s.nextDouble();	
		
		
		
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
		
		String sql_sal_update="update employe set salary=salary+(salary+?)/100 where depertment=?";

		
		PreparedStatement preparedStatement = con.prepareStatement(sql_sal_update);
		
	
		preparedStatement.setDouble(1, Sec_hike);
		preparedStatement.setString(2,"securiy");
	    preparedStatement.executeUpdate();
		
	    
		preparedStatement.setDouble(1, Hr_hike);
		preparedStatement.setString(2,"Hr");
	    preparedStatement.executeUpdate();
	    
	    
		preparedStatement.setDouble(1, Admin_hike);
		preparedStatement.setString(2,"Admin");
		preparedStatement.executeUpdate();
	    
		preparedStatement.setDouble(1, RND_hike);
		preparedStatement.setString(2,"RND");
		preparedStatement.executeUpdate();
	    
	    
		preparedStatement.setDouble(1, Salse_hike);
		preparedStatement.setString(2,"Salse");
		preparedStatement.executeUpdate();
	    
	    
	    System.out.println("salary updated ");
		con.close();
		
	}

}
