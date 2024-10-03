package com.TechM.in.CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class procedureOUt {
	
	
	private static final String URL = "jdbc:mysql://localhost:3306/advancejava";

	private static final String USERNAME = "root";

	private static final String PASSWORD = "root";
	private static final String Procedure = "call getBookData()";

	// private static final String sql="insert into books values(105,'navin',500)";
	public static void main(String[] args) throws Exception {
		

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	Statement statement = con.createStatement();
	
		



	con.close();
	}

}
