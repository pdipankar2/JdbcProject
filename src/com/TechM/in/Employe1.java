package com.TechM.in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Employe1 {

	private static final String URL = "jdbc:mysql://localhost:3306/advancejava";

	private static final String USERNAME = "root";

	private static final String PASSWORD = "root";

	String sql = "select * from employe";

	public static void main(String[] args) throws Exception {

		Scanner s = new Scanner(System.in);

		/*
		 * System.out.println("Enter EmpId:"); int id = s.nextInt();
		 * 
		 * 
		 * System.out.println("Enter Name:"); String name = s.next();
		 * 
		 * System.out.println("Enter Email:"); String email = s.next();
		 * 
		 * System.out.println("Enter Salary:"); double salary = s.nextDouble();
		 */
		System.out.println("Enter Dept:");
		String dept = s.next();

		System.out.println("Enter Gender:");
		String gender = s.next();

		System.out.println("Enter Locaton:");
		String city = s.next();
		    //Dynamic search quary 
				//we can prepared the quarry based on the input
		StringBuilder sql = new StringBuilder("select * from employe where 1=1");

		
		
		if (dept!=null && !dept.equals("null")) {
			sql.append(" AND depertment= ?");
		}

		if (gender!=null && !gender.equals("null")) {
			sql.append(" AND gender= ?");
		}

		if (city!=null && !city.equals("null")) {
			sql.append(" AND location= ?");
		}

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
		PreparedStatement pst = con.prepareStatement(sql.toString());

		int index = 1;

		if (dept!=null && !dept.equals("null")) {
			pst.setString(index, dept);
			index++;
		}

		if (gender!=null && !gender.equals("null")) {
			pst.setString(index, gender);
			index++;
		}

		if (city!=null && !city.equals("null")) {
			pst.setString(index, city);
			
		}

		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getInt(1) + "---" + rs.getString(2) + "----" + rs.getString(3) + "----"
					+ rs.getDouble(4) + "----" + rs.getString(5) + "----" + rs.getString(6) + "----" + rs.getString(7));
		}
		
		con.close();

	}

}
