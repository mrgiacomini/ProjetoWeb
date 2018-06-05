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
import model.User;

/**
 *
 * @author mathe
 */
public class UserDAO {

    private Connection conn = null;

    public boolean searchUser(String username) {
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT username from tb_user where username = '" + username + "'");
            ResultSet r = ps.executeQuery();

            if (r.next() && r.getString("username").equals(username)) {
                conn.close();
                return true;
            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean insertUser(String username, String email, String adress, String password) {
        User user = new User(username, email, adress, password);
        
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement("INSERT INTO tb_user(username, email, adress, psw) "
                                                        + "VALUES (?,?,?,?)");
            p.setString(1, user.getUsername());
            p.setString(2, user.getEmail());
            p.setString(3, user.getAdress());
            p.setString(4, user.getPassword());
            p.executeUpdate();

            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

}
