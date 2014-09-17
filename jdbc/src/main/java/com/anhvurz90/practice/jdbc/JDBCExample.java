package com.anhvurz90.practice.jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCExample {

  public static void main(String[] args) {
    System.out.println("-----MySQL JDBC Connection Testing -----");
    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      System.out.println("WHere is your MySQL JDBC Driver?");
      e.printStackTrace();
      return;
    }
    
    System.out.println("MySQL JDBC Driver Registered!");
    Connection connection = null;
    
    try {
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","");
    } catch (SQLException e) {
      System.out.println("Connection failed! Check output console!");
      e.printStackTrace();
      return;
    }
    
    if (connection != null) {
      System.out.println("You made it, take control your database now!");
    } else {
      System.out.println("Failed to make connection!");
    }
  }
}
