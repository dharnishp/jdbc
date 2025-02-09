/*
Inserting records in relation database through the java application.
*/
package com.dharnish.jdbc.Programs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Example1 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		//STEP 1 -> loading driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//STEP 2 -> connection establish
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/add_m7?user=root&password=root");
		//STEP 3 -> issue query
		String query="INSERT INTO CUSTOMER(ID,FNAME,LNAME,AGE,COUNTRY) VALUES(8,'Sam','Curran',24,'England')";
		//STEP 4 -> create statement
		Statement stmt=con.createStatement();
		//STEP 5 -> execute query -->executes query&returns 1 integer row
		int count=stmt.executeUpdate(query);
		//STEP 6 -> Process the query 
		if(count>0)
		{
			System.out.println("Data inserted");
		}else
		{
			System.out.println("try again!!");
		}
		//STEP 7 -> Close connection 
		con.close();
		stmt.close();
	}
}
