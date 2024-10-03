package com.jtc.jdbc.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class prepare {

	private static final String URL = "jdbc:mysql://localhost:3306/advancejava";

	private static final String USERNAME = "root";

	private static final String PASSWORD = "root";
	private static final String sql = "insert into books values(?,?,?)";

	// private static final String sql="insert into books values(105,'navin',500)";
	public static void main(String[] args) throws Exception {
		
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Book ID:-");
		int id = s.nextInt();
		
		
		
		System.out.println("Enter Book Name:-");
		String v = s.next();
		
		
		
		System.out.println("Enter Book Price:-");
		int p = s.nextInt();
		
		

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	
	
		

		PreparedStatement prepareStatement = con.prepareStatement(sql);

		prepareStatement.setInt(1, id);
		prepareStatement.setString(2, v);
		prepareStatement.setInt(3, p);
		
		int i = prepareStatement.executeUpdate();
		System.out.println(i);
		con.close();
		
		
	}
}
