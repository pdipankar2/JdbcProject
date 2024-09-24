package com.TechM.in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Employe {

	private static final String URL = "jdbc:mysql://localhost:3306/advancejava";

	private static final String USERNAME = "root";

	private static final String PASSWORD = "root";

	//private static final String sql = "insert into  employe  values(105,'Kanak','acs@12mail.com',45000.00,'Salse','F','Kolkata')";

	private static final String sql="select * from employe";
	
	public static void main(String[] args) throws Exception {

		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		Statement createStatement = con.createStatement();
		
		//int executeUpdate = createStatement.executeUpdate(sql);
		ResultSet rs = createStatement.executeQuery(sql);
		
		while (rs.next()) 
			
		 {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));

			System.out.println(rs.getDouble(4));
			System.out.println(rs.getString(5));
			System.out.println(rs.getString(6));
			System.out.println(rs.getString(7));



		}
		
		//System.out.println(executeUpdate);
		System.out.println("record updated ");
		
		
		
		con.close();

	}

}
