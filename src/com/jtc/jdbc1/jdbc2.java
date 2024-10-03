package com.jtc.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbc2 {

	private static final String URL = "jdbc:mysql://localhost:3306/advancejava";

	private static final String USERNAME = "root";

	private static final String PASSWORD = "root";
	// private static final String sql="insert into books values(105,'navin',500)";
	private static final String sql = "delete from books where bookid=102";

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
		Statement statement = con.createStatement();

		int update = statement.executeUpdate(sql);
		
		// System.out.println("record inserted:-"+update);
		System.out.println("record deleted:-" + update);

		
		
		con.close();

	}

}
