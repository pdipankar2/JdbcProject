package com.jtc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc1 {
	
	private static final String URL="jdbc:mysql://localhost:3306/advancejava";
	
	private static final String USERNAME="root";

	private static final String PASSWORD="root";
	private static final String sql="";
	
	public static void main(String[] args) throws Exception {
		
		//1   Load the driver;
		Class.forName("com.mysql.cj.jdbc.Driver");

	//2  get database connecton
	//	DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava","root","root");
	
	Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	System.out.println(con);
	//3  create statement
	Statement statement = con.createStatement();
	
	// 4 Execute quary
	
	int rowset=statement.executeUpdate("insert into books values(102,'arun',500)");
	 
	//5 process result 
	
	System.out.println("Record inserted:-"+rowset);
	// 6 colose connection 
	
	con.close();
	
	
	}
	

}
