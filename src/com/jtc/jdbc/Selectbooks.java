package com.jtc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Selectbooks {

	private static final String URL = "jdbc:mysql://localhost:3306/advancejava";

	private static final String USERNAME = "root";

	private static final String PASSWORD = "root";
	// private static final String sql="insert into books values(105,'navin',500)";
	private static final String sql = "select *  from books where bookid=102";

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		Statement statement = con.createStatement();

		ResultSet rs = statement.executeQuery(sql);
		if (rs.next()) {

			int i = rs.getInt("bookid");

			String string = rs.getString("bookName");
			int i1 = rs.getInt("bookPrice");
			System.out.println(i);
			System.out.println(string);

			System.out.println(i1);

		} else {
			System.out.println("record not available");
		}
		
		ResultSetMetaData metaData = rs.getMetaData();

		System.out.println(metaData.getColumnCount());
		
		
		con.close();

	}

}
