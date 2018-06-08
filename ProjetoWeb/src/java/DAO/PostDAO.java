/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.ConnectionFactory;
import static controller.ConnectionFactory.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Post;
import model.User;

/**
 *
 * @author mathe
 */
public class PostDAO extends ConnectionFactory{
    
    private Connection conn = null;
    
    public ArrayList listPosts(){
        ArrayList<Post> lista = new ArrayList();
         try {
            conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * from tb_post ORDER BY id_post DESC");
            ResultSet r = ps.executeQuery();
            while(r.next()) {
               lista.add(new Post(r.getInt("id_post"), r.getString("title"), r.getString("caption"),
                       r.getString("text"), r.getString("file_path"), r.getString("username"), r.getString("user_file")));
            }
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return lista;
    }
    
    public ArrayList listPosts(String query){
        ArrayList<Post> lista = new ArrayList();
         try {
            conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * from tb_post WHERE "
                    +"title ilike ? or  caption ilike ? or text ilike ? ORDER BY id_post DESC");
            ps.setString(1, "%"+query+"%");
            ps.setString(2, "%"+query+"%");
            ps.setString(3, "%"+query+"%");
            ResultSet r = ps.executeQuery();
            while(r.next()) {
               lista.add(new Post(r.getInt("id_post"), r.getString("title"), r.getString("caption"),
                       r.getString("text"), r.getString("file_path"), r.getString("username"), r.getString("user_file")));
            }
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return lista;
    }
    
    public boolean insertPost(String title, String caption, String text, String filePath, String username){
        Post post;
        
        try {
            conn = getConnection();
            
            //consulta o usuario que esta logado para pegar a imagem
            PreparedStatement p = conn.prepareStatement("SELECT file_path from tb_user where username = '"+username+"'");
            ResultSet r = p.executeQuery();
            r.next();
            post = new Post(title, caption, text, filePath, username, r.getString("file_path"));
            
            
            p = conn.prepareStatement("INSERT INTO tb_post(title, caption, text, file_path, username, user_file) "
                                                            + "VALUES (?,?,?,?,?,?)");
            
            p.setString(1, post.getTitle());
            p.setString(2, post.getCaption());
            p.setString(3, post.getText());
            p.setString(4, post.getFile());
            p.setString(5, post.getUsername());
            p.setString(6, post.getUserFile());
           
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
    
    public boolean deletePost(int id) {
        
        try {
            conn = getConnection();
            PreparedStatement p = conn.prepareStatement("DELETE FROM tb_post WHERE id_post='"+id+"'");
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