/*
 * write a jdbc program to delete record from table?
 */
package com.dharnish.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Assignment2 {

	public static void main(String[] args) {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/add_m7?user=root&password=root");
			String query="DELETE FROM CUSTOMER WHERE ID=6";
			Statement smt=con.createStatement();
			int count=smt.executeUpdate(query);
			if(count>0)
			{
				System.out.println("Data Deleted");
			}
			else
			{
				System.out.println("Try again");
			}
			con.close();
			smt.close();
		}
		catch(ClassNotFoundException |SQLException e)
		{
			e.printStackTrace();
		}
	}

}
