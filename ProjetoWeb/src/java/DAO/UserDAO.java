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
public class UserDAO extends ConnectionFactory{

    private Connection conn = null;

    public boolean searchUser(String username) {
        try {
            conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT username from tb_user where username = '" 
                                                            + username + "'");
            ResultSet r = ps.executeQuery();

            if (r.next()){
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
    
    public boolean searchEmail(String email) {
        try {
            conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT username from tb_user where email = '" 
                                                            + email + "'");
            ResultSet r = ps.executeQuery();

            if (r.next()){
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

    public boolean insertUser(String username, String email, String adress, String password, String filePath) {
        
        User user;
        
        try {
            conn = getConnection();
            
            user = new User(username, email, adress, password, filePath);
         
            PreparedStatement p = conn.prepareStatement("INSERT INTO tb_user(username, email, adress, psw, file_path) "
                                                        + "VALUES (?,?,?,?,?)");
            p.setString(1, user.getUsername());
            p.setString(2, user.getEmail());
            p.setString(3, user.getAdress());
            p.setString(4, user.getPassword());
            p.setString(5, filePath);
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
    
    public User getUser(String username) {
        User user = null;
        try {
            conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * from tb_user WHERE username = '" 
                                                            + username + "'");
            ResultSet r = ps.executeQuery();

            if (r.next()){
                user = new User(r.getString("username"),r.getString("email"),r.getString("adress"),r.getString("psw"));
            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;
    }
    
    public boolean alterUser(String username, String email, String adress, String password, String filePath) {
        User user = new User(username, email, adress, password, filePath);
        
        try {
            conn = getConnection();
            PreparedStatement p;
                    
            if(password.equals("") && filePath.equals("")){ //NAO altera campo senha e file
                p = conn.prepareStatement("UPDATE tb_user SET username = ?, email = ?, "
                                           + "adress = ? WHERE username = '"+username+"'");

                p.setString(1, user.getUsername());
                p.setString(2, user.getEmail());
                p.setString(3, user.getAdress());    
                
            }else if(password.equals("") && !filePath.equals("")){ //altera o file
                p = conn.prepareStatement("UPDATE tb_user SET username = ?, email = ?, "
                                           + "adress = ?, file_path = ? WHERE username = '"+username+"'");

                p.setString(1, user.getUsername());
                p.setString(2, user.getEmail());
                p.setString(3, user.getAdress());    
                p.setString(4, user.getFile());    
                
            }else if(!password.equals("") && filePath.equals("")){ //altera a senha
                p = conn.prepareStatement("UPDATE tb_user SET username = ?, email = ?, "
                                           + "adress = ?, psw = ? WHERE username = '"+username+"'");

                p.setString(1, user.getUsername());
                p.setString(2, user.getEmail());
                p.setString(3, user.getAdress());
                p.setString(4, user.getPassword());
                
            }else{    //altera tudo
                p = conn.prepareStatement("UPDATE tb_user SET username = ?, email = ?, "  
                                          + "adress = ?, psw = ?, , file_path = ? WHERE username = '"+username+"'");

                p.setString(1, user.getUsername());
                p.setString(2, user.getEmail());
                p.setString(3, user.getAdress());  
                p.setString(4, user.getPassword());
                p.setString(4, user.getFile());

            }    
            
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
    
    public boolean deleteUser(String username) {
        
        try {
            conn = getConnection();
            PreparedStatement p = conn.prepareStatement("DELETE FROM tb_user WHERE username='"+username+"'");
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
