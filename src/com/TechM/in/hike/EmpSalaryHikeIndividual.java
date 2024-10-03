package com.TechM.in.hike;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
//in the above code all the salary will be updated at one short bcz business logic will be exedcuted at databases

public class EmpSalaryHikeIndividual {
	
	

	private static final String URL = "jdbc:mysql://localhost:3306/advancejava";

	private static final String USERNAME = "root";

	private static final String PASSWORD = "root";
	private static final String sql="select * from employe";
	//in the above code all the salary will be updated at one short bcz business logic will be exedcuted at databases
	//
	public static void main(String[] args) throws Exception {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Salary Hike:-");
		double hike = s.nextDouble();
		
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
		Statement statement = con.createStatement();
		
		 String sql_sal_update="update employe set salary=salary+(salary+?)/100";

		ResultSet rs = statement.executeQuery(sql);
		
		PreparedStatement preparedStatement = con.prepareStatement(sql_sal_update);
		
		preparedStatement.setDouble(1, hike);
		
		preparedStatement.executeUpdate();
		
		System.out.println("salary updated ");
		con.close();
		
	}


}
