package com.dharnish.Programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Example4
{

	public static void main(String[] args) throws ClassNotFoundException,SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/add_m7?user=root&password=root");
		String query="SELECT * FROM CUSTOMER";
		Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery(query);
		System.out.println("----------------------------------------");
		System.out.println("ID\tFNAME\tLNAME\tAGE\tCOUNTRY");
		System.out.println("----------------------------------------");
		while(rs.next())
		{
			int id=rs.getInt(1);
			String fname=rs.getString(2);
			String lname=rs.getString(3);
			int age=rs.getInt(4);
			String country=rs.getString(5);
			System.out.println(id+"\t"+fname+"\t"+lname+"\t"+age+"\t"+country);
		}
		System.out.println("----------------------------------------");
		con.close();
		smt.close();
	}
}
