package com.dharnish.batchprocessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD1 {

	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String dburl="jdbc:mysql://localhost:3306/add_m7?user=root&password=root";
		Connection con=DriverManager.getConnection(dburl);
		String query1="INSERT INTO CUSTOMER VALUES(6,'Dharnish','P',23,'USA')";
		String query2="INSERT INTO CUSTOMER VALUES(7,'Harish','M',23,'India')";
		String query3="UPDATE CUSTOMER SET FNAME='Madhan',LNAME='Kumar' WHERE ID=5";
		String query4="DELETE FROM CUSTOMER WHERE ID =4";
		Statement smt=con.createStatement();
		smt.addBatch(query1);
		smt.addBatch(query2);
		smt.addBatch(query3);
		smt.addBatch(query4);
		int[] arr=smt.executeBatch();
		for(int c:arr)
		{
			System.out.println("INSERTION | UPDATION | DELETION Done Successfully : "+c);
		}
		ResultSet rs=smt.executeQuery("SELECT * FROM CUSTOMER");
		System.out.println("============================================");
		System.out.println("ID \t FNAME \t\t LNAME \t AGE \t COUNTRY");
		System.out.println("============================================");
		while(rs.next())
		{
			int id=rs.getInt(1);
			String fname=rs.getString(2);
			String lname=rs.getString(3);
			int age=rs.getInt(4);
			String country=rs.getString(5);
			System.out.println(id+" \t "+fname+" \t "+lname+" \t "+age+" \t "+country);
		}
		System.out.println("============================================");
		con.close();
		smt.close();
		rs.close();
	}
}
