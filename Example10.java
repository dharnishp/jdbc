package com.dharnish.jdbcPrograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Example10 {

	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/add_m7?user=root&password=root");
		String query="SELECT fname,lname FROM CUSTOMER";
		Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery(query);
		System.out.println("------------------");
		System.out.println("FNAME\tLNAME");
		System.out.println("------------------");
		while(rs.next())
		{
			String fname=rs.getString(1);
			String lname=rs.getString(2);
			System.out.println(fname+"\t"+lname);
		}
		System.out.println("------------------");
		con.close();
		smt.close();
	}

}
