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
import packageWeb.Photo;



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
    public long dbAlbumAdd(String name,String description,String owner) throws Exception, SQLException  {
        long album_id=0;
        try
        {
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(dt);
        String owner_id=owner;
        int own=Integer.parseInt(owner_id);
        String driver = "com.mysql.jdbc.Driver";
        String connectionString = "jdbc:mysql://localhost:3306/AlbumsDB";
        String user = "albums_admin";
        String pass = "alBUM_2018";
            System.out.println("int owner "+own);
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(connectionString, user, pass);
        String query = " insert into ALBUMS ( album_owner_id,album_name,album_description,album_date_create,album_path)"
        + " values (?,?,?,?,?)";
        PreparedStatement preparedStmt = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
        preparedStmt.setInt (1, own);
        preparedStmt.setString (2, name);
        preparedStmt.setString (3, description);
        preparedStmt.setString (4, date);
        preparedStmt.setString (5, "");
        int affectedRows = preparedStmt.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("failed");
        }

        try (ResultSet generatedKeys = preparedStmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
              album_id = generatedKeys.getLong(1);
            }
            else {
                throw new SQLException("Creating user failed, no ID obtained.");
            }
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
        return album_id;
    }
    public void dbUpdateAlbumAdd(String path,long album_id) throws Exception, SQLException  {
        try
        {        
        String driver = "com.mysql.jdbc.Driver";
        String connectionString = "jdbc:mysql://localhost:3306/AlbumsDB";
        String user = "albums_admin";
        String pass = "alBUM_2018";
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(connectionString, user, pass);
        String query = "update ALBUMS set album_path=? where album_id=?";
        PreparedStatement preparedStmt = connection.prepareStatement(query);      
        preparedStmt.setString(1, path);
        preparedStmt.setInt(2, (int)album_id);
        preparedStmt.executeUpdate();
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
        while (rs.next()) 
        {
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
    public Map<Integer,String> dbOwnerAlbums(String owner, boolean show) throws Exception, SQLException 
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
        if(show)
            query = "SELECT album_id, album_name FROM ALBUMS LEFT JOIN PHOTO ON ALBUMS.album_id = PHOTO.photo_album_id WHERE ALBUMS.album_owner_id='"+owner+"'GROUP BY ALBUMS.album_id HAVING COUNT(ALBUMS.album_id) < 10";
        
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
    public void dbPhotoUpload(String name,String description,String owner,String album) throws Exception, SQLException  {

        try
        {
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(dt);
        String owner_id=owner;
        String album_id=album;
        int own=Integer.parseInt(owner_id);
        int alb=Integer.parseInt(album_id);
        String path="/PhotoAlbum/"+owner+"/"+album_id+"/";
        String driver = "com.mysql.jdbc.Driver";
        String connectionString = "jdbc:mysql://localhost:3306/AlbumsDB";
        String user = "albums_admin";
        String pass = "alBUM_2018";
            System.out.println("int owner "+own);
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(connectionString, user, pass);
        String query = " insert into PHOTO ( photo_owner_id,photo_album_id,photo_name,photo_description,photo_date_upload,photo_path)"
        + " values (?,?,?,?,?,?)";
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setInt (1, own);
        preparedStmt.setInt (2, alb);
        preparedStmt.setString (3, name);
        preparedStmt.setString (4, description);
        preparedStmt.setString (5, date);
        preparedStmt.setString (6, path);
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
    
    public ArrayList <Photo> dbPhotoInfo(String albumId) throws Exception, SQLException  {
      String name="a";
      String des="b";
      String data="c";
      String path="d";

      ArrayList <Photo> photoList=new ArrayList<Photo>();
      try
      {
        String driver = "com.mysql.jdbc.Driver";
        String connectionString = "jdbc:mysql://localhost:3306/AlbumsDB";
        String user = "albums_admin";
        String pass = "alBUM_2018";
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(connectionString, user, pass);
        Statement stmt = connection.createStatement();
        String query = "SELECT * FROM PHOTO WHERE photo_album_id='"+albumId+"'";
        ResultSet rs = stmt.executeQuery(query);
        System.out.println("myalbums");
        while (rs.next()) 
        {
            Photo photo = new Photo();
            name = rs.getString("photo_name");
            des = rs.getString("photo_description");
            data = rs.getString("photo_date_upload");
            path=rs.getString("photo_path");
             
            photo.setDescription(des);
            photo.setPhotoName(name); 
            photo.setDateUploud(data);
            photo.setFilePath(path);
            photoList.add(photo);
            //System.out.println("photo name "+name+" photo decscription "+des+" photo date create "+data+" photo path "+path);
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
      return photoList;
  }
    //select count(photo_id),photo_album_id,a.album_name from PHOTO p,ALBUMS a where a.album_id=p.photo_album_id group by p.photo_album_id having count(photo_id)>1;
public Map<Integer,String> dbShowPhotos(String owner) throws Exception, SQLException 
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
        String query = "SELECT album_id, album_name FROM PHOTO right JOIN ALBUMS on PHOTO.photo_album_id = ALBUMS.album_id group by ALBUMS.album_id HAVING count(PHOTO.photo_id)>=0 OR NOT EXISTS (SELECT 1 FROM PHOTO WHERE photo_owner_id='"+owner+"' PHOTO.photo_album_id=ALBUMS.album_id)";
           System.out.println("query "+query);
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
