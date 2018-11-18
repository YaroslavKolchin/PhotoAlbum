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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;



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
        String owner_id=owner;
        int own=Integer.parseInt(owner_id);
        String path="/PhotoAlbum/"+owner+"/"+name+"/";
        String driver = "com.mysql.jdbc.Driver";
        String connectionString = "jdbc:mysql://localhost:3306/AlbumsDB";
        String user = "albums_admin";
        String pass = "alBUM_2018";
            System.out.println("int owner "+own);
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(connectionString, user, pass);
        String query = " insert into ALBUMS ( album_owner_id,album_name,album_description,album_date_create,album_path)"
        + " values (?,?,?,?,?)";
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setInt (1, own);
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
    public void dbMyalbums(String owner) throws Exception, SQLException  {
      String rows="0";
      String name="a";
      String des="b";
      String data="c";
        try
      {
        /*java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(dt);*/
        String driver = "com.mysql.jdbc.Driver";
        String connectionString = "jdbc:mysql://localhost:3306/AlbumsDB";
        String user = "albums_admin";
        String pass = "alBUM_2018";
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(connectionString, user, pass);
        Statement stmt = connection.createStatement();
        String query = "SELECT album_name,album_description,album_date_create FROM ALBUMS WHERE album_owner_id='"+owner+"'";
        ResultSet rs = stmt.executeQuery(query);
          System.out.println("myalbums");
        while (rs.next()) {
             name = rs.getString("album_name");
             des = rs.getString("album_description");
             data = rs.getString("album_date_create");
              System.out.println("name "+name+" decscription "+des+" date "+data);
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
    public Map<Integer,String> dbOwnerAlbums(String owner) throws Exception, SQLException 
    {      
        Map<Integer,String> albumNamesMap = new HashMap<Integer,String>();
        try
       {
        /*java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(dt);*/
        String driver = "com.mysql.jdbc.Driver";
        String connectionString = "jdbc:mysql://localhost:3306/AlbumsDB";
        String user = "albums_admin";
        String pass = "alBUM_2018";
        Class.forName(driver);
        String name="a";
        int id=1;
        Connection connection = DriverManager.getConnection(connectionString, user, pass);
        Statement stmt = connection.createStatement();
        String query = "SELECT album_id,album_name FROM ALBUMS WHERE album_owner_id='"+owner+"'";
        ResultSet rs = stmt.executeQuery(query);
          System.out.println("myalbums");
        while (rs.next()) {
             id=rs.getInt("album_id");
             name = rs.getString("album_name");            
             // System.out.println("name Album="+name);
              albumNamesMap.put(id, name);
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
        return albumNamesMap;
    }
}
