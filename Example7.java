package com.dharnish.Programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Example7 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter customer ID: ");
		int idn=scn.nextInt();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/add_m7?user=root&password=root");
		String query="SELECT * FROM CUSTOMER WHERE ID=?";
		PreparedStatement pst=con.prepareStatement(query);
		pst.setInt(1, idn);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			int id=rs.getInt(1);
			String fname=rs.getString(2);
			String lname =rs.getString(3);
			int age=rs.getInt(4);
			String country=rs.getString(5);
			System.out.println("----------------------------------------");
			System.out.println("ID\tFNAME\tLNAME\tAGE\tCOUNTRY");
			System.out.println("----------------------------------------");
			System.out.println(id+"\t"+fname+"\t"+lname+"\t"+age+"\t"+country);
			System.out.println("----------------------------------------");
		}
		else
		{
			System.out.println("given customer id is invalid!!!");
		}
		con.close();
		pst.close();
	}
}
