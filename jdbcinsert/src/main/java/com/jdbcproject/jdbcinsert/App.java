package com.jdbcproject.jdbcinsert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;  //import the package
public class App 
{
    public static void main( String[] args )
    {
    	
    	try
    	{
    		// load and register the driver
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		// establish the connection    
    		// url , username , password
    		String url="jdbc:mysql://localhost:3306/school";
    		String username="root";
    		String password="root";
    		    		
    		Connection con =DriverManager.getConnection(url, username, password);
    		
//    		//created the query
//    		String q = "Create table employee(eid int primary key auto_increment , ename varchar(40) not null , ecity varchar(40))";
//    		//create the statement
//    		Statement stmt = con.createStatement();
//    		//executing the statement
//    		stmt.executeUpdate(q);
//    		System.out.println("Table is created");
//    		con.close(); //closing the connection
    		
    		String q= "insert into employee(ename,ecity) values(?,?)";
    		// created the preparedstatememt object     (use for dynamic value)
    		PreparedStatement pstmt=con.prepareStatement(q);
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		System.out.println("Enter the employee name");
    		String name =br.readLine();
    		//set the values in the query
     		pstmt.setString(1,name);
    		
    		System.out.println("Enter city name");
            String city = br.readLine();
    		pstmt.setString(2,city);

    		//executing the prerared statement
    		pstmt.executeUpdate();
    		System.out.println("data inserted succesfully");
    		
    		// statement to get data from the table
    		Statement stmt= con.createStatement();
     		ResultSet rs = stmt.executeQuery("select * from employee");
    		while(rs.next()) // checking if the result set has more data or not
    		{
    			//printing the data from the result set
   			System.out.println(rs.getInt(1)+"   "+rs.getString(2)+"  "+rs.getString(3));
   		}
 	
    		
    		
    	}
    	catch(Exception e)
    	{
   		e.printStackTrace();
   	}
    	
    } 
}
  