/*
 * Write a jdbc program to read input from user to update fname,lname and country records from table?
 */
package com.dharnish.jdbcPrograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Example4 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter First Name: ");
		String fname=scn.nextLine();
		System.out.println("Enter Last Name: ");
		String lname=scn.nextLine();
		System.out.println("Enter Country Name: ");
		String country=scn.nextLine();
		System.out.println("Enter ID to update the record: ");
		int id=scn.nextInt();
		try {
			//Step 1 -> Loading driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Step 2 -> Establish the connection
			String dburl="jdbc:mysql://localhost:3306/add_m7?user=root&password=root";
			Connection con=DriverManager.getConnection(dburl);
			//Step 3 -> Issue the query
			String query="UPDATE CUSTOMER SET FNAME=?,LNAME=?,COUNTRY=? WHERE ID = ?";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, fname);
			pst.setString(2, lname);
			pst.setString(3, country);
			pst.setInt(4, id);
			int count=pst.executeUpdate();
			if(count>0)
			{
				System.out.println("data Updated");
			}
			else
			{
				System.out.println("Try again");
			}
			con.close();
			pst.close();
		}
		catch(ClassNotFoundException |SQLException e)
		{
			e.printStackTrace();
		}
	}
}
