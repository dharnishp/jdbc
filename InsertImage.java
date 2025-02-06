package com.dharnish.Programs;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertImage {

	public static void main(String[] args) throws ClassNotFoundException,SQLException,IOException{
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter actor id:");
		int id=scn.nextInt();
		scn.nextLine();
		System.out.println("Enter actor Name:");
		String name=scn.nextLine();
		System.out.println("Enter actor Language:");
		String lang=scn.nextLine();
		System.out.println("Enter actor image path:");
		String path=scn.nextLine();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/add_m7?user=root&password=root");
		String query="INSERT INTO ACTOR (a_id,a_name,a_lang,a_image) VALUES(?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(query);
		pst.setInt(1, id);
		pst.setString(2, name);
		pst.setString(3, lang);
		FileInputStream img=new FileInputStream(path);
		pst.setBinaryStream(4, img);
		int count=pst.executeUpdate();
		if(count>0)
		{
			System.out.println("Data inserted!!!");
		}
		else
		{
			System.out.println("Try Again!!!");
		}
		con.close();
		pst.close();
	}

}
