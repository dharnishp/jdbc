The following 7 steps are very important for JDBC API programs. All 7 steps are interdependent, so all the steps are very important.


STEP 1 -> loading driver
STEP 2 -> Establish the connection
STEP 3 -> Issue the query
STEP 4 -> Create the statement
STEP 5 -> Execute the query -->executes query&returns 1 integer row
STEP 6 -> Process the query 
STEP 7 -> Close the connection 


Loading driver:
===============
Loading the driver is important part in the jdbc api we using the MySql work bench
Driver for mysql is com.mysql.cj.jdbc.Driver

How to load the Driver in java program
=======================================

By using forName() Method -> it is a pure static method present in Class<inbuild class>

  Class.forName(String Driver);
It throws an ClassNotFoundException so we have to handle the exception through the try()&catch() block or throws Keyword

Example:
========
Class.forName("com.mysql.cj.jdbc.Driver");

Establish the Connection:
=========================
This part is important in jdbc api program to connect the java application to relational database application.

How to invoke connection:
=========================
By using the getConnection() method -> It is a pure static method present in DriverManager Class<Inbuild Class>
		DriverManager.getConnection(String dburl);

It's return type is Connection Interface.
It throws an SQLException so we have to handle the exception through the try()&catch() block or throws Keyword

dbur:
=====
jdbc:mysql://localhost:3306/add_m7?user=root&password=root

Example:
========
String dburl="jdbc:mysql://localhost:3306/add_m7?user=root&password=root";
Connection con=DriverManager.getconnection(dburl);
