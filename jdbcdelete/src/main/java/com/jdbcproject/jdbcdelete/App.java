package com.jdbcproject.jdbcdelete;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class App 
{
    public static void main( String[] args )
    {
     /* 
    	// delete record in database 
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
    		String q= "delete from employee where eid=?";
    		PreparedStatement pstmt=con.prepareStatement(q);
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		System.out.println("Enter the employee id which you want to delete");
    		int id =Integer.parseInt(br.readLine());
    		//set the values in the query
     		pstmt.setInt(1,id);
     	//	System.out.println(id);
     		pstmt.executeUpdate();
    		System.out.println("data deleted succesfully");
    		Statement stmt= con.createStatement();
     		ResultSet rs = stmt.executeQuery("select * from employee");
    		while(rs.next()) // checking if the result set has more data or not
    		{
    			//printing the data from the result set
   			System.out.println(rs.getInt(1)+"   "+rs.getString(2)+"  "+rs.getString(3));
   		}
 	

     }
   */ 
    	// update data 
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
    		String q= "update employee set ename=?  where eid=?";
    		PreparedStatement pstmt=con.prepareStatement(q);
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		System.out.println("Enter the name");
    		String name=br.readLine();
     		pstmt.setString(1,name);

    		System.out.println("Enter the employee id which you want to update");
 
    		int id =Integer.parseInt(br.readLine());
    		//set the values in the query
     		pstmt.setInt(2,id);
     	//	System.out.println(id);
     		pstmt.executeUpdate();
    		System.out.println("data updated succesfully");
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
    		System.out.println(e);
    	}
}
}