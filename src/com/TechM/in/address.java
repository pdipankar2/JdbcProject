package com.TechM.in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class address {

	private static final String URL = "jdbc:mysql://localhost:3306/advancejava";

	private static final String USERNAME = "root";

	private static final String PASSWORD = "root";
	private static final String emp_insert = "insert into  employe1 values(?,?,?)";

	private static final String add_insert = "insert into  emp_address values(?,?,?,?)";

	//transection example
	
	public static void main(String[] args) throws Exception {

		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		PreparedStatement pstmt = con.prepareStatement(emp_insert);
		// set auto commit
		con.setAutoCommit(false);
		
		try {
			pstmt.setInt(1, 104);
			pstmt.setString(2, "tarik");
			pstmt.setDouble(3, 1024.00);

			pstmt.executeUpdate();

			pstmt = con.prepareStatement(add_insert);

			pstmt.setString(1, "kolkata");
			pstmt.setString(2, "TG");
			pstmt.setString(3, "India");
			pstmt.setInt(4, 104);

			pstmt.executeUpdate();
			con.commit();
			System.out.println("record inserted successfullly");
		} catch (Exception e) {
			// TODO: logic to roll back 
			con.rollback();
			System.out.println("failed to execute");
		}

		

		con.close();
		System.out.println("record inserted...........");
	}
}
