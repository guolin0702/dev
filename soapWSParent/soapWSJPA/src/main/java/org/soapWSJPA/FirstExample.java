package org.soapWSJPA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstExample {

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
	      conn.setAutoCommit(false);
	      
	      //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql;
	      //sql = "SELECT book_id, author, title, created_date, modified_date from book";
	      sql = "insert into book values (3,'Author 3', 'title 3', '2015-07-31', '2015-08-12')";
	      int count = stmt.executeUpdate(sql);
	      conn.commit();

	      //STEP 6: Clean-up environment
	      stmt.close();
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