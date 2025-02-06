package com.dharnish.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Assignment4 {

	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter Customer ID: ");
		int id=scn.nextInt();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/add_m7?user=root&password=root");
		String query="SELECT country FROM CUSTOMER WHERE ID=?";
		PreparedStatement pst=con.prepareStatement(query);
		pst.setInt(1, id);
		ResultSet rs=pst.executeQuery();
		System.out.println("----------");
		System.out.println("Country");
		System.out.println("----------");
		while(rs.next())
		{
			String country=rs.getString(1);
			System.out.println(country);
		}
		System.out.println("----------");
		con.close();
		pst.close();
	}

}
