package com.jtc.jdbc.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Prepar {

	private static final String URL = "jdbc:mysql://localhost:3306/advancejava";

	private static final String USERNAME = "root";

	private static final String PASSWORD = "root";

	// private static final String sql="insert into books values(105,'navin',500)";
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
		String sql = "insert into books values(?,?,?)";
		
		PreparedStatement prepareStatement = con.prepareStatement(sql);

		prepareStatement.setInt(1, 501);
		prepareStatement.setString(2, "Aws");
		prepareStatement.setInt(3, 900);

		int count = prepareStatement.executeUpdate();
		System.out.println(count);

		con.close();

	}
}