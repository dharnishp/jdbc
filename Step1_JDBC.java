/*
Java code to load the driver in JDBC API with the help of forName() method.
*/
package com.dharnish.jdbc.steps;
class Step1_JDBC
{
  public static void main(String[] args)
  {
    try
      {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Loading Driver done!!!");
      }
    catch(ClassNotFoundException e)
      {
        e.printStackTrace();
      }
  }
}
    
