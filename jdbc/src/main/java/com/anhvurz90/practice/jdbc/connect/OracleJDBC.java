package com.anhvurz90.practice.jdbc.connect;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class OracleJDBC {

  public static void main(String[] args) {
    System.out.println("-----------Oracle JDBC Connection Testing----------");
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
    } catch (ClassNotFoundException e) {
      System.out.println("Where is your Oracle JDBC Driver?");
      e.printStackTrace();return;
    }
    
    System.out.println("Oracle JDBC Driver Registered!");
    Connection connection = null;
    try {
      connection = DriverManager.getConnection(
          "jdbc:oracle:thin:@localhost:1521:mkyong", "username", "password");
    } catch (SQLException e) {
      System.out.println("Connection Failed! Check output console!");
      e.printStackTrace();
      return;
    }

    System.out.println(connection != null ? 
                          "You made it, take control your database now!" :
                          "Failed to make connection!");
  }
}
