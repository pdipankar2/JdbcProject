package com.TechM.in.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class batch {

	private static final String URL = "jdbc:mysql://localhost:3306/advancejava";

	private static final String USERNAME = "root";

	private static final String PASSWORD = "root";

	// private static final String sql="insert into books values(105,'navin',500)";
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		Statement statement = con.createStatement();

		
		
		statement.addBatch("insert into books values(202,'ppt',1600)");
		statement.addBatch("insert into books values(201,'cgpt',1800)");
		statement.addBatch("insert into books values(203,'atm',1200)");
		statement.addBatch("insert into books values(204,'cat',1400)");

		int[] batch = statement.executeBatch();
		System.out.println("record effected"+batch.length);;
		
		con.close();
		System.out.println("execution compleated");
	}

}
