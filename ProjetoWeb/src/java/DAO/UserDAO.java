/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mathe
 */
public class UserDAO {
    Connection conn = null;
    
    public boolean buscaUsuario(String username){
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT username from user where name = '"+username+"'");
            ResultSet r = ps.executeQuery();
            
            if(r.getString("username").equals(username)){
                return true;
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
