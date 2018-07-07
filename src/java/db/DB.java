/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

  import java.sql.Connection;
  import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DB {
  public void dbConnection() throws Exception {
    String driver = "com.mysql.jdbc.Driver";
    String connection = "jdbc:mysql://localhost:3306/AlbumsDB";
    String user = "root";
    String password = "12345";
    Class.forName(driver);
    Connection con = DriverManager.getConnection(connection, user, password);
    Statement stmt = con.createStatement();
    String query = "select columnname from tablename ;";
    ResultSet rs = stmt.executeQuery(query);
      System.out.println(rs+" !rs! ");
    if (!con.isClosed()) {
      con.close();
    }
  }
}
