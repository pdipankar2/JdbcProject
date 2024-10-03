package com.TechM.in.hike;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
//this program we implemented logic for java side 
//to increase hike for employe form every emp one update quary will be execute to update salary with hike
//if we have 1lk record in  the table then 1lk times update quary witll be execute 
//if we have 1cr then 1cr times update quary will execute it will decrease performance of the application 
//to overcome that problem we can used bellow aproch
public class EmpSalaryHike {
	
	

	private static final String URL = "jdbc:mysql://localhost:3306/advancejava";

	private static final String USERNAME = "root";

	private static final String PASSWORD = "root";
	private static final String sql="se6lect * from employe";
	//Not recomentded this logic
	private static final String sql_sal_update="update employe  set  salary=? where id=?";
	
	public static void main(String[] args) throws Exception {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Salary Hike:-");
		double hike = s.nextDouble();
		
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
		Statement statement = con.createStatement();
		
		ResultSet rs = statement.executeQuery(sql);
		
		PreparedStatement preparedStatement = con.prepareStatement(sql_sal_update);
		
		
		while (rs.next()) {
			
			int empId = rs.getInt("id");
			
			double existingsalary = rs.getDouble("salary");
			
			double newSal=existingsalary + (existingsalary*hike)/100;
			
			preparedStatement.setDouble(1,newSal);
			preparedStatement.setInt(2,empId);
			preparedStatement.executeUpdate();
			
		}
		
		System.out.println("salary updated ");
		con.close();
		
	}


}
