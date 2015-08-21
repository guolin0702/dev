package org.soapWSJPA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SecondExample {

	  static final String JDBC_DRIVER = "org.postgresql.Driver";  
	  static final String DB_URL = "jdbc:postgresql://localhost:5432/demo";

	  //  Database credentials
	  static final String USER = "postgres";
	  static final String PASS = "iex.prms";
	  
	  public static void main(String[] args) {
	  Connection conn = null;
	  Statement stmt = null;
	  try{
	      //STEP 2: Register JDBC driver
	      Class.forName(JDBC_DRIVER);

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);

	      //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      String sql;
	      sql = "select * from book";
	      PreparedStatement preparestate = conn.prepareStatement(sql);
//	      preparestate.setInt(1, 5);
	      ResultSet rs = preparestate.executeQuery();
	      
	      //STEP 5: Extract data from result set
	      while(rs.next()){
	        //Retrieve by column name
	        int bookId  = rs.getInt("book_id");
	        String author = rs.getString("author");
	        String createDate = rs.getString("created_date");
	        String modifiedDate = rs.getString("modified_date");

	        //Display values
	        System.out.print("BookID: " + bookId);
	        System.out.print(", Author: " + author);
	        System.out.print(", CreateDate: " + createDate);
	        System.out.println(", ModifiedDate: " + modifiedDate);
	      }
	      
	      //STEP 6: Clean-up environment
	      rs.close();
	      preparestate.close();
	      conn.close();
	  }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	  }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	  }finally{
	      //finally block used to close resources
	      try{
	        if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	        if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	        se.printStackTrace();
	      }//end finally try
	  }//end try
	  System.out.println("Goodbye!");
	}//end main
}//end FirstExample