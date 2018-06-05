/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import controller.ConnectionFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Post;

/**
 *
 * @author mathe
 */
public class PostDAO {
    
    private Connection conn = null;
    
    public ArrayList listPosts(){
        ArrayList<Post> lista = new ArrayList();
         try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * from tb_post");
            ResultSet r = ps.executeQuery();
            while(r.next()) {
               lista.add(new Post(r.getString("title"), r.getString("caption"), r.getString("text")));
            }
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return lista;
    }
    
    public boolean insertPost(String title, String caption, String text){
        Post post = new Post(title, caption, text);
        
        try {
            conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement("INSERT INTO tb_post(title, caption, text) "
                                                            + "VALUES (?,?,?)");
            p.setString(1, post.getTitle());
            p.setString(2, post.getCaption());
            p.setString(3, post.getText());
           
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
    
    
    public void upload(String folder, String fileName, InputStream loadedFile) throws FileNotFoundException{
        String path = folder+"/"+fileName;
        File newFile = new File(path);
        FileOutputStream out = new FileOutputStream(newFile);
        toCopy(loadedFile, out);
    }
    
    public void toCopy(InputStream origem, OutputStream destino){
        int bytes = 0;
        byte[] maxSize = new byte[100*1024];
        try {
            while((bytes = origem.read(maxSize)) >= 0){
                destino.write(maxSize, 0, bytes);
            }
        } catch (IOException ex) {
            Logger.getLogger(PostDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
