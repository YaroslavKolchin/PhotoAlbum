/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DB {
  public void dbConnection() throws Exception, SQLException  {
      try
      {        
        String driver = "com.mysql.jdbc.Driver";        
        String connectionString = "jdbc:mysql://localhost:3306/AlbumsDB";
        String user = "albums_admin";
        String password = "alBUM_2018";
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(connectionString, user, password);
        Statement stmt = connection.createStatement();
        String query = "select * from USERS;";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {           
            int userId = rs.getInt("user_id");
            String userName = rs.getString("user_email");
            String userPassword = rs.getString("user_password");
            System.out.println("id: "+userId+"; userName: "+userName+"; userPassword: "+userPassword);
        }        
        if (!connection.isClosed()) 
        {
            connection.close();
        }
      }
      catch(Exception exception)
      {
          exception.printStackTrace();
      }
  }
}
