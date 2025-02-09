/*

*/
// Approach-1
package com.dharnish.jdbc.steps;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
class Step2_JDBC
{
  public static void main(String[] args)
  {
    try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      String dburl="jdbc:mysql://localhost:3306:/add_m7?user=root&password=root";
      Connection con=DriverManager.getConnection(dburl);
      if(con !=null)
      {
        System.out.println("Connection Established!!! ");
      }
      else
      {
        System.out.println("Connection failed!!!");
      }
    }
    catch(ClassNotFoundException | SQLException e)
      {
        e.printStackTrace();
      }
  }
}
      
