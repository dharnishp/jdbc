package com.dharnish.Programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Example2 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter ID: ");
		int id=scn.nextInt();
		scn.nextLine();
		System.out.println("Enter FNAME: ");
		String fname=scn.nextLine();
		System.out.println("Enter LNAME: ");
		String lname=scn.nextLine();
		System.out.println("Enter AGE: ");
		int age=scn.nextInt();
		scn.nextLine();
		System.out.println("Enter COUNTRY: ");
		String country=scn.nextLine();
		//STEP 1 -> Loading Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//STEP 2 -> Establish the Connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/add_m7?user=root&password=root");
		//STEP 3 -> Issue Query
		String query="INSERT INTO CUSTOMER(ID,FNAME,LNAME,AGE,COUNTRY) VALUES(?,?,?,?,?)";
		//STEP 4 -> Create Statement
		PreparedStatement pst=con.prepareStatement(query);
		pst.setInt(1, id);
		pst.setString(2, fname);
		pst.setString(3, lname);
		pst.setInt(4,age);
		pst.setString(5, country);
		//STEP 5 -> Execute query 
		int count=pst.executeUpdate();
		//STEP 6 -> Process the query
		if(count>0)
		{
			System.out.println("data inserted");
		}
		else
		{
			System.out.println("try again");
		}
		//STEP 7 -> Close Connection
		con.close();
		pst.close();
	}
}
