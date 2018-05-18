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
       
   public Connection getConnection(String database, String user, String password) throws ClassNotFoundException, SQLException{   
        //return getMySqlConnection(database,user,password);
        return getPostgreConnection(database,user,password);
   }
   
   public Connection getMySqlConnection(String database, String user, String password) throws ClassNotFoundException, SQLException{
       String driver = "com.mysql.jdbc.Driver";
       String url = "jdbc:mysql://localhost/3306";
       Class.forName(driver);
       return DriverManager.getConnection(url+"/"+database,user,password);
   }
   
   public Connection getPostgreConnection(String database, String user, String password) throws ClassNotFoundException, SQLException{
       String driver = "org.postgresql.Driver";
       String url = "jdbc:postgresql://localhost/5432";
       Class.forName(driver);
       return DriverManager.getConnection(url+"/"+database,user,password);
   }
}
