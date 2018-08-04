/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DB {
  public int dbAuthorisation(String email,String pass) throws Exception, SQLException  {
      int rows=0;
      try
      {        
        String driver = "com.mysql.jdbc.Driver";        
        String connectionString = "jdbc:mysql://localhost:3306/AlbumsDB";
        String user = "albums_admin";
        String password = "alBUM_2018";
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(connectionString, user, password);
        Statement stmt = connection.createStatement();
        String query = "SELECT * FROM USERS WHERE user_email='"+email+"' AND user_password='"+pass+"';";
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {           
             rows = rs.getInt(1);        
        } 
        System.out.println("rows: "+rows);
        if (!connection.isClosed()) 
        {      
            connection.close();
        }
        
      }
      catch(Exception exception)
      {
          exception.printStackTrace();
      }
      return rows;
  }
  public void dbRegistration(String email,String password) throws Exception, SQLException  {
      try
      {        
        String driver = "com.mysql.jdbc.Driver";        
        String connectionString = "jdbc:mysql://localhost:3306/AlbumsDB";
        String user = "albums_admin";
        String pass = "alBUM_2018";
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(connectionString, user, pass);
        String query = " insert into USERS (user_email, user_password)"
        + " values (?,?)"; 
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setString (1, email);
        preparedStmt.setString (2, password);
        preparedStmt.execute();
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
    public void dbAlbumAdd(String name,String description,String owner) throws Exception, SQLException  {
      try
      { 
        java.util.Date dt = new java.util.Date(); 
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(dt);
        int owner_id=1; 
        String path="/home/PhotoAlbum/User/Email/"+name+"/";
        String driver = "com.mysql.jdbc.Driver";        
        String connectionString = "jdbc:mysql://localhost:3306/AlbumsDB";
        String user = "albums_admin";
        String pass = "alBUM_2018";
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(connectionString, user, pass);
        String query = " insert into ALBUMS ( album_owner_id,album_name,album_description,album_date_create,album_path)"
        + " values (?,?,?,?,?)"; 
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setInt (1, owner_id);
        preparedStmt.setString (2, name);
        preparedStmt.setString (3, description);
        preparedStmt.setString (4, date);
        preparedStmt.setString (5, path);
        preparedStmt.execute();
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
