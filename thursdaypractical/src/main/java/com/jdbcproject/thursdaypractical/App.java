package com.jdbcproject.thursdaypractical;

import java.sql.*;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
    	try 
    	{
		//load and register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//establish the connection
		//url,username,password
		String url="jdbc:mysql://localhost:3306/thursdaylab_14Sep";
		String username="root";
		String password="root";
		Connection con=DriverManager.getConnection(url,username,password);
		
		// String q ="Create table employee(eid int primary key auto_increment,ename varchar(20) not null,ecity varchar(20),salary int)";
		//create statement 
		Statement stmt =con.createStatement();
		// stmt.executeUpdate(q);
		//executing the statement
	//	System.out.println("Table is created");
    	
    	Scanner sc=new Scanner(System.in);
        int operation=-1;
        while(operation !=0)
        {
            System.out.println("Choose to perform opertion:");
            System.out.println("1. Insert");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Select");
            System.out.println("5. Exit");
            System.out.println("Enter your choice to perform opertion:");
            operation=sc.nextInt();
            sc.nextLine();
            
            
            switch(operation)
            {
            case 1:
               //insert the values in  employee table 
               
  			   System.out.println("Enter employee Name:");
  			   String ename=sc.nextLine();
               System.out.println("Enter employee City:");
  			   String city=sc.nextLine();
               System.out.println("Enter employee Salary:");
  			   int salary=sc.nextInt();
  			   
  			   String insert="insert into employee(ename,ecity,salary) values (?,?,?)";
  			  //create the preparedStatementt object
 	    	   PreparedStatement pstmt=con.prepareStatement(insert);
 	    	   pstmt.setString(1, ename);
 	    	   pstmt.setString(2, city);
 	    	   pstmt.setInt(3, salary);
 	    	 //executing the prepared Statement
 	    		pstmt.executeUpdate();
 	    		System.out.println("Data is inserted successfully");  
 	    		break;
 	    		
 	    		
            case 2:
            	 //update the values in  employee table 
            	System.out.println("Enter the employee ID to update value ");
            	int eid_update=sc.nextInt();
            	sc.nextLine();
            	
            	int ch=-1;
                {
                    System.out.println("Choose to perform the opertion on update :");
                    System.out.println("1. Employee Name");
                    System.out.println("2. Employee City");
                    System.out.println("3. Employee Salary");
                    System.out.println("Enter choice to perform update:");
                    ch=sc.nextInt();
                    sc.nextLine();
                    switch(ch)
                     {
                    case 1:
            	         System.out.println("Enter the new employee name:");
            	         String newEname=sc.nextLine();
                       	 String update="update employee set ename= ? where eid = ?";
            	         PreparedStatement pstmt1=con.prepareStatement(update);
            	         pstmt1.setString(1, newEname);
            	         pstmt1.setInt(2, eid_update);
            	         //executing the prepared Statement
 	    		         pstmt1.executeUpdate();
 	    		         System.out.println("Employee name is updated successfully");  
 	    		         break;
                    case 2:
           	            System.out.println("Enter the new employee city:");
           	            String new_city=sc.nextLine();
                        String update1="update employee set ecity= ? where eid = ?";
           	            PreparedStatement pstmt2=con.prepareStatement(update1);
           	            pstmt2.setString(1, new_city);
           	            pstmt2.setInt(2, eid_update);
           	            //executing the prepared Statement
	    		        pstmt2.executeUpdate();
	    		        System.out.println("Employee city is updated successfully");    
	    		        break;
                    case 3:
           	            System.out.println("Enter the new employee salary:");
           	            int new_salary=sc.nextInt();
                        String update2="update employee set salary= ? where eid = ?";
           	            PreparedStatement pstmt3=con.prepareStatement(update2);
           	            pstmt3.setDouble(1, new_salary);
           	            pstmt3.setInt(2, eid_update);
           	            //executing the prepared Statement
	    		        pstmt3.executeUpdate();
	    		        System.out.println("Employee salary is updated successfully");      
	    		        break;
	    		   default:
	    			   System.out.println("Please enter right choice to update");
	    			   break;
              }  
                    
           }
                break;
                
            case 3:
            	System.out.println("Enter the employee ID to delete:");
            	int eid_delete=sc.nextInt();
            	String delete="delete from employee where eid=?";
            	PreparedStatement delete1=con.prepareStatement(delete);
            	delete1.setInt(1, eid_delete);
            	//executing the prepared Statement
            	delete1.executeUpdate();
 	    		System.out.println("Employee is deleted successfully");  
 	    		break;
 	    		
            case 4:
            	String select="select * from employee";
            	ResultSet select1=stmt.executeQuery(select);
            	
            	while(select1.next()) // checking if the result set has more data or not
        		 {
            		int empID=select1.getInt("eid");
            		String empName=select1.getString("ename");
            		String empCity=select1.getString("ecity");
            		int empSalary=select1.getInt("salary");
            		System.out.println(" ID: "+empID+ " ,   Name: "+empName+ ",     City: "+empCity+ ",      Salary: "+empSalary);
             	
//        			//printing the data from the result set
//       			System.out.println(select1.getInt("eid")+"   "+select1.getString("ename")+"  "+select1.getString("city")+" "+select1.getInt("salary"));
       	     }
        		 break; 
            	 
         		        	
            case 5:
            	System.out.println("Exit");
            	break;
            default:
            	System.out.println("Please enter right choice");
         }
       }
       stmt.close();
       con.close();
    }
    catch(Exception e)
    {
         System.out.println(e);   		
    }
  }
}
