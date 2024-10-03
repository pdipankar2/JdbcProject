package com.jtc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MultipleRecordRetrive {

	private static final String URL = "jdbc:mysql://localhost:3306/advancejava";

	private static final String USERNAME = "root";

	private static final String PASSWORD = "root";
	// private static final String sql="insert into books values(105,'navin',500)";
	private static final String sql = "select *  from books";

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		Statement statement = con.createStatement();

		ResultSet rs = statement.executeQuery(sql);

		//while loop will be execute untill record is avail able
		
		while (rs.next()) {

			System.out.println(rs.getInt("bookid"));
			System.out.println(rs.getString("bookName"));
			System.out.println(rs.getInt("bookPrice"));

		}

		con.close();

	}

}
