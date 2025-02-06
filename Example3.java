package com.dharnish.Programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Example3 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//STEP 1 -> Loading Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//STEP 2 -> Establish the connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/add_m7?user=root&password=root");
		//STEP 3 -> Issue the Query
		String query="UPDATE CUSTOMER SET LNAME='P' WHERE ID=6";
		//STEP 4 -> Create Statement
		Statement smt=con.createStatement();
		//STEP 5 -> Execute the query
		int count=smt.executeUpdate(query);
		//STEP 6 -> Process query
		if(count>0)
		{
			System.out.println("data updated!!!");
		}
		else
		{
			System.out.println("try again!!!");
		}
		//STEP 7 -> close connection
		con.close();
		smt.close();
	}
}

