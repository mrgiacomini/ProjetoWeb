/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.*;

/**
 *
 * @author andrey
 */
public class ConnectionFactory {
    Connection conn = null;
    private String database, user, password;
    
   public void setURL(String database, String user, String password){
       this.database = database;
       this.user = user;
       this.password = password;
   }
   
   public void getMySqlConnection() throws ClassNotFoundException, SQLException{
       String driver = "com.mysql.jdbc.Driver";
       String url = "jdbc:mysql://localhost/3306";
       Class.forName(driver);
       conn = DriverManager.getConnection(url+"/"+this.database,user,password);
   }
   
   public void getPostgreConnection() throws ClassNotFoundException, SQLException{
       String driver = "org.postgresql.Driver";
       String url = "jdbc:postgresql://localhost/5432";
       Class.forName(driver);
       conn = DriverManager.getConnection(url+"/"+this.database,user,password);
   }
}
