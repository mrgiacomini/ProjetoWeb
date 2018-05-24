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
       
   public static Connection getConnection() throws ClassNotFoundException, SQLException{   
        //return getMySqlConnection("host","database","user","password");
        return getPostgreConnection("ec2-54-235-206-118.compute-1.amazonaws.com","dc0u8pqgth59ot","depbbbrhfhudwa","b10481c3c41bab86611b858ca5ed77de97349024d1601b8eaee5e472c1416793");
   }
   
   public static Connection getMySqlConnection(String host, String database, String user, String password) throws ClassNotFoundException, SQLException{
       String driver = "com.mysql.jdbc.Driver";
       String url = "jdbc:mysql://localhost/3306";
       Class.forName(driver);
       return DriverManager.getConnection(url+"/"+database,user,password);
   }
   
   public static Connection getPostgreConnection(String host, String database, String user, String password) throws ClassNotFoundException, SQLException{
       //conecta com o banco de dados postgres no heroku
       Class.forName("org.postgresql.Driver");
       return DriverManager.getConnection("jdbc:postgresql://"+host+":5432/"+database+"?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory", user, password);
   }
}
