package com.jtc.jdbc.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
//this task we have conditional base serarch operation  to achive this requirment  we give the quary is dynamacialy 
//if user dont give price  execute the quary like 		StringBuilder builder = new StringBuilder("select * from books");
 //if user give the price we can give this bellow 
public class SelectBook {
	private static final String URL = "jdbc:mysql://localhost:3306/advancejava";

	private static final String USERNAME = "root";

	private static final String PASSWORD = "root";

	public static void main(String[] args) throws Exception {

		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Price");
		int price = s.nextInt();

		/*
		 * String sql="select * from books"; string is immutable if changes happend new
		 * object will be created we can solve this problem using stirnbbuffer and
		 * string builder but string buffer is thread safe thats why application
		 * performance is slow to over come we can used builder
		 * 
		 * if(price>=0) { sql.concat("where bookPrice <=?");
		 * 
		 * }
		 */
		// using stringbuilder bcz it is mutable/multiple object crated

		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		StringBuilder builder = new StringBuilder("select * from books");

		if (price > 0) {
			builder.append(" where bookPrice<= ?");
		}

		PreparedStatement prepareStatement = con.prepareStatement(builder.toString());

		if (price > 0) {

			prepareStatement.setInt(1, price);
		}
		
		ResultSet rs = prepareStatement.executeQuery();
	
	
	while (rs.next()) {
		System.out.println(rs.getInt(1));
		System.out.println(rs.getString(2));

		System.out.println(rs.getInt(3));

		
	}
	con.close();
	}
}
